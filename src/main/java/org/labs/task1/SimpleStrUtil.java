package org.labs.task1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SimpleStrUtil {

    public static final String SEPARATE_LINE = "<<<<<<------------->>>>>>>\n";

    public static String getTimeLogStr(String text) {
        return "Текущая дата " + LocalDateTime.now() + " " + text;
    }
}
