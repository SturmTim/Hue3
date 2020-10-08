/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos3.tsturm18;

import java.util.function.Predicate;

/**
 *
 * @author timst
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Predicate<Integer> isEven = (number -> number % 2 == 0);
        final Predicate<Integer> isPositive = (number -> number >= 0);
        final Predicate<Integer> isZero = (number -> number == 0);
        final Predicate<Integer> isNull = (number -> number == null);
        final Predicate<String> isShortWord = (string -> string.length() < 4);

        System.out.println("isEven 2: " + isEven.test(2));
        System.out.println("isEven 3: " + isEven.test(3));

        System.out.println("isPositive 1: " + isPositive.test(1));
        System.out.println("isPositive -1: " + isPositive.test(-1));

        System.out.println("isZero 1: " + isZero.test(1));
        System.out.println("isZero 0: " + isZero.test(0));

        System.out.println("isNull 1: " + isNull.test(1));
        System.out.println("isNull null: " + isNull.test(null));

        System.out.println("isShortWord seas: " + isShortWord.test("seas"));
        System.out.println("isShortWord bye: " + isShortWord.test("bye"));

        System.out.println("Even + Positive 2: " + isPositive.and(isEven).test(2));

        System.out.println("positive + notEven 5: " + isPositive.and(isEven.negate()).test(5));
    }

}
