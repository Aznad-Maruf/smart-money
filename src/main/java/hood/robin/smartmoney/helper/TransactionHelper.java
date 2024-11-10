package hood.robin.smartmoney.helper;

import hood.robin.smartmoney.command.TransactionCommand;
import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.entity.Transaction;
import hood.robin.smartmoney.service.CategoryService;
import hood.robin.smartmoney.utils.NumUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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

        Category category = categoryService.getCategory(command.getCategoryUuid());
        transaction.setCategory(category);

        BigDecimal amount = NumUtils.round(command.getAmount());
        transaction.setAmount(amount);

        return transaction;
    }
}
