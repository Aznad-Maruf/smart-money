package hood.robin.smartmoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Message.findByUuid", query = "SELECT m FROM Message m WHERE m.uuid = :uuid"),
        @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
})
public class Message extends BaseEntity {

    @NotNull
    private String message;
}
