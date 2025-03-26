package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.command.TransactionCommand;
import hood.robin.smartmoney.entity.Transaction;
import hood.robin.smartmoney.helper.TransactionHelper;
import hood.robin.smartmoney.service.BaseService;
import org.springframework.web.multipart.MultipartFile;
import hood.robin.smartmoney.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author khandaker.maruf
 * @since 11/3/24
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController extends BaseController<Transaction>{

    private final TransactionHelper transactionHelper;
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService,
                                 TransactionHelper transactionHelper) {

        super(transactionService);
        this.transactionHelper = transactionHelper;
        this.transactionService = transactionService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        List<Transaction> transactions = transactionHelper.parse(file);

        for (Transaction transaction : transactions) {
//            transactionService.save(transaction);
        }

        return ResponseEntity.ok(transactions);
    }
}
