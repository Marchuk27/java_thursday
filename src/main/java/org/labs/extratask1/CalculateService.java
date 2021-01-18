package org.labs.extratask1;

import lombok.var;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.StringUtils.substringAfter;

public class CalculateService {

    private static Map<String, Integer> lastResultIndexes = new HashMap<>();

    public static String outputWinnerName(String[] strArray) {
        if (strArray == null) {
            throw new RuntimeException("Null array !!!");
        }
        //сохраняем историю последних попыток ("Имя" - Номер попытки)
        fillIndexesMap(strArray);
        Map<String, Integer> results = createMapFromStrArray(strArray);
        String preparatoryResultName = MapUtils.getEntryWithMaxValue(results);
        int maxValue = results.get(preparatoryResultName);
        List<String> maxValueNames = MapUtils.getListOfEntriesWithSameValue(results, maxValue);

        //если только один участник набрал наибольшее кол-во баллов, то выводим его
        if (maxValueNames.size() == 1) {
            return maxValueNames.get(0);
        }

        //если нет то смотрим историю попыток
        return getWinnerWithTheEarliestAttempt(maxValueNames);
    }

    private static Map<String, Integer> createMapFromStrArray(String[] strArray) {
        Map<String, Integer> data = new HashMap<>();
        for (String dataStr : strArray) {
            String name = substringBefore(dataStr, SPACE);
            int score = Integer.parseInt(substringAfter(dataStr, SPACE));
            putPairIntoMap(data, name, score);
        }
        return data;
    }

    private static void putPairIntoMap(Map<String, Integer> map, String key, int val) {
        if (map.containsKey(key)) {
            int updateScore = map.get(key) + val;
            map.put(key, updateScore);
        }  else {
            map.put(key, val);
        }
    }

    private static void fillIndexesMap(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            lastResultIndexes.put(substringBefore(strArray[i], SPACE), i);
        }
    }

    private static String getWinnerWithTheEarliestAttempt(List<String> maxValueNames) {
        var winnerName = new StringBuilder(maxValueNames.get(0));
        for (String name: maxValueNames) {
            if (lastResultIndexes.get(name) < lastResultIndexes.get(winnerName.toString())) {
                winnerName = new StringBuilder(name);
            }
        }
       return winnerName.toString();
    }


}
