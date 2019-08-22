/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class MinimumDotProduct {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] matrix1 = new int[size];
        for (int i = 0; i < size; i++) {
            matrix1[i] = scanner.nextInt();
        }
        int[] matrix2 = new int[size];
        for (int i = 0; i < size; i++) {
            matrix2[i] = scanner.nextInt();
        }
        System.out.println(minimumDotProduct(matrix1, matrix2));
    }
    private static long minimumDotProduct(int[] m1, int[] m2) {
        Arrays.sort(m1);
        Arrays.sort(m2);
        reverse(m2);
        long result = 0;
        for (int i = 0; i < m1.length; i++) {
            result += (long) m1[i] * m2[i];
        }
        return result;
    }

    public static void reverse(int[] input) { 
        int last = input.length - 1; 
        int middle = input.length / 2; 
        for (int i = 0; i <= middle; i++) {
            int temp = input[i]; 
            input[i] = input[last - i]; 
            input[last - i] = temp; 
        } 
    }

}
