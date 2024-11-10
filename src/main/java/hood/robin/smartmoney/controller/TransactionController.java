package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.command.TransactionCommand;
import hood.robin.smartmoney.entity.Transaction;
import hood.robin.smartmoney.helper.TransactionHelper;
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
public class TransactionController {

    private final TransactionService transactionService;

    private final TransactionHelper transactionHelper;

    public TransactionController(TransactionService transactionService, TransactionHelper transactionHelper) {
        this.transactionHelper = transactionHelper;
        this.transactionService = transactionService;
    }

    @GetMapping("/health")
    public String health() {
        return "Healthy";
    }

    @PostMapping()
    public ResponseEntity<Transaction> save(@RequestBody @Valid TransactionCommand command) {
        Transaction transaction = transactionHelper.createTransaction(command);

        transaction = transactionService.save(transaction);

        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll(){
        // TODO Add pagination
        List<Transaction> transactions = transactionService.findAll();

        return ResponseEntity.ok(transactions);
    }
}
