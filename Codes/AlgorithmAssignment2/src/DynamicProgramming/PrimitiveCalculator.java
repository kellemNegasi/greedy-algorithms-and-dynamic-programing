/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Kelly
 */
public class PrimitiveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int n=16;
        List<Integer> sequence = dynamic_sequence(n);
        System.out.println(sequence.size() - 1);
        sequence.stream().forEach((x) -> {
            System.out.print(x + " ");
        });
    } 
    private static List<Integer> dynamic_sequence(int n) {
        int[] c = new int[n + 1];
        int[] predecessor = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            c[i] =  c[i - 1]+ 1;
            predecessor[i] = i - 1;
            if (i % 3 == 0) {
                if (c[i / 3] < c[i]) {
                    c[i] = c[i / 3] + 1;
                    predecessor[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (c[i / 2] < c[i]) {
                    c[i] = c[i / 2] + 1;
                    predecessor[i] = i / 2;
                }
            }
        }

        ArrayList<Integer> sequence = new ArrayList<Integer>();

        for (int i = n; i != 0; i = predecessor[i]) {
            sequence.add(i);
        }

        Collections.reverse(sequence);
        return sequence;
    }   
}
