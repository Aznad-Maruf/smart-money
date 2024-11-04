package hood.robin.smartmoney.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author khandaker.maruf
 * @since 11/3/24
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @GetMapping("/health")
    public String health() {
        return "Healthy";
    }
}
