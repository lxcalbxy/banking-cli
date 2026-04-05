package lv.v3nom.infrastructure.util;

import java.time.LocalDateTime;

public interface DateTimeProvider {
    LocalDateTime now();
}
