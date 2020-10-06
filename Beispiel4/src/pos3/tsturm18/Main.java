/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos3.tsturm18;

import java.util.stream.IntStream;

/**
 *
 * @author timst
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int ergebniss = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 1).reduce(0, (b1, b2) -> b1 + b2);
        System.out.println(ergebniss);
    }

}
