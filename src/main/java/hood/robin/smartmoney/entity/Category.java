package hood.robin.smartmoney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Category.findByUuid", query = "SELECT c FROM Category c WHERE c.uuid = :uuid"),
        @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c order by c.name")
})
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 500)
    private String description;
}
