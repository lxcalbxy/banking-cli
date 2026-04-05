package lv.v3nom.infrastructure.util.impl;

import lv.v3nom.infrastructure.util.DateTimeProvider;

import java.time.LocalDateTime;

public class SystemDateTimeProvider implements DateTimeProvider {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
