package hood.robin.smartmoney.helper;

import hood.robin.smartmoney.command.TransactionCommand;
import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.entity.Transaction;
import hood.robin.smartmoney.service.CategoryService;
import hood.robin.smartmoney.utils.NumUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionHelper {

    private final CategoryService categoryService;

    public TransactionHelper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Transaction createTransaction(TransactionCommand command) {
        Transaction transaction = new Transaction();

        transaction.setTime(LocalDateTime.now());
        transaction.setType(command.getType());
        transaction.setDescription(command.getDescription());
        transaction.setUuid(UUID.randomUUID());

        Category category = categoryService.find(command.getCategoryUuid());
        transaction.setCategory(category);

        BigDecimal amount = NumUtils.round(command.getAmount());
        transaction.setAmount(amount);

        return transaction;
    }

    public List<Transaction> parse(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        List<Transaction> transactions = new ArrayList<>();

        try {
            String extractedText = extractTextFromPdf(file);
            System.out.println(extractedText);
            Transaction transaction = new Transaction();
            transaction.setDescription(extractedText);
            transactions.add(transaction);

            return transactions;

        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to extract text from file");
        }
    }

    private String extractTextFromPdf(MultipartFile file) throws IOException {
        PDDocument pdDocument = PDDocument.load(file.getInputStream());
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        return pdfTextStripper.getText(pdDocument);
    }
}
