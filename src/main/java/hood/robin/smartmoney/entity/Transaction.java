package hood.robin.smartmoney.entity;

import hood.robin.smartmoney.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author khandaker.maruf
 * @since 11/3/24
 */
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@Getter
@Setter
public class Transaction extends BaseEntity {

    private TransactionType type;

    private String category;

    private double amount;

    private String description;

    @Column(name = "transaction_time")
    private LocalDateTime time;
}
