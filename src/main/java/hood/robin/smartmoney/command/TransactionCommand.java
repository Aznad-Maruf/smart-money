package hood.robin.smartmoney.command;

import hood.robin.smartmoney.entity.Transaction;
import hood.robin.smartmoney.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author khandaker.maruf
 * @since 11/3/24
 */
@Getter
@Setter
@NoArgsConstructor
public class TransactionCommand {

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @NotNull
    private UUID categoryUuid;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String description;
}
