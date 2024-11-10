package hood.robin.smartmoney.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.isNull;

public class NumUtils {

    public static BigDecimal round(BigDecimal value) {
        if (isNull(value)) {
            return null;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
