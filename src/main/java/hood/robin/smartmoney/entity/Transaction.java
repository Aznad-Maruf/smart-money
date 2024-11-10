package hood.robin.smartmoney.entity;

import hood.robin.smartmoney.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author khandaker.maruf
 * @since 11/3/24
 */
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Transaction.findByUuid", query = "FROM Transaction t WHERE t.uuid = :uuid"),
        @NamedQuery(name = "Transaction.findAll", query = "FROM Transaction t")
})
public class Transaction extends BaseEntity {

    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(length = 500)
    private String description;

    @Column(name = "transaction_time")
    private LocalDateTime time;
}
