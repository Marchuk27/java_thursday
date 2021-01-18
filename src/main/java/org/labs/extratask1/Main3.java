package org.labs.extratask1;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author - Марчук Александр
 */
@Slf4j
public class Main3{

    //Ivan 5, Petr 3, Alex 10, Petr 8, Ivan 6, Alex 5, Ivan 1, Petr 5, Alex 1

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String[] stringArray = StringHelper.getArrayFromString(inputText);
        System.out.println(
                CalculateService.outputWinnerName(stringArray)
        );
    }
}