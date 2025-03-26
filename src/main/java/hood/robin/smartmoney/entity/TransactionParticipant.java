package hood.robin.smartmoney.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransactionParticipant extends BaseEntity{

    @NotNull
    String name;

    String phoneNumber;

    String description;
}
