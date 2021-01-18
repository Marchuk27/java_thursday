package org.labs.extratask1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MapUtils {

    public static String getEntryWithMaxValue(Map<String, Integer> map) {
        Optional<Map.Entry<String, Integer>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getKey();
    }

    public static List<String> getListOfEntriesWithSameValue(Map<String, Integer> map, int value) {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == value) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
