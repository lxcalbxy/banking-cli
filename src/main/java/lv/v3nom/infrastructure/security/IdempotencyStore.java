package lv.v3nom.infrastructure.security;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IdempotencyStore {
    private final Set<String> processedKeys = ConcurrentHashMap.newKeySet();

    public boolean isProcessed(String key) {
        return processedKeys.contains(key);
    }
    public void markProcessed(String key) {
        processedKeys.add(key);
    }
}
