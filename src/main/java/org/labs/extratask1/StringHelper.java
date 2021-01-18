package org.labs.extratask1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.substringBetween;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringHelper {

    private static final String COMMA = ",";

    public static String[] getArrayFromString(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            log.warn("Строка пустая или null !!");
            throw new RuntimeException("Empty or null string");
        }
        final int size = calculateCommasAmount(inputText) + 1;
        return createArrayValues(inputText, size);
    }

    private static int calculateCommasAmount(String text) {
        int counter = 0;
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == COMMA.charAt(0)) {
                counter++;
            }
        }
        return counter;
    }

    private static String[] createArrayValues(String inputText, int size) {
        var modifiedText = new StringBuilder(COMMA + inputText + COMMA);
        String[] resultArray = new String[size];
        for (int i = 0; i < size; i++) {
            String valueStr = substringBetween(modifiedText.toString(), COMMA);
            resultArray[i] = valueStr.trim();
            modifiedText.replace(0, valueStr.length(), EMPTY);
        }
        return resultArray;
    }
}
