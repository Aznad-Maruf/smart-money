package hood.robin.smartmoney.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {

    @NotNull
    @Size(max = 100)
    private String name;

    @Size(max = 500)
    private String description;
}
