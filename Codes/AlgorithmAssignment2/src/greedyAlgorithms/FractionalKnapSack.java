/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyAlgorithms;

import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class FractionalKnapSack {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int n = userInput.nextInt();
        int maxCapacity = userInput.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = userInput.nextInt();
            weights[i] = userInput.nextInt();
        }
        System.out.printf("the maximum value possible is %.4f \n", solveFractionalKnapSack(values, weights, maxCapacity));
    }
    public static double solveFractionalKnapSack(int[] values, int[] weights,double maxCapacity){
        double maxValue = 0;
        int  maxIndex=0;
        double availableWeights = 0;
        if(maxCapacity==0){
            return 0;
        }
        for(int i = 0; i<values.length;i++){
            maxIndex = getMaxIndex(values,weights);// get the index of item with maximum value/wieght ratio
            availableWeights = Math.min(weights[maxIndex],maxCapacity);//the remaining weight to be filled to the knapsack
            maxValue += availableWeights*(double)values[maxIndex]/(double)weights[maxIndex];// add the weights to the knapsack
            weights[maxIndex] -=availableWeights;// update the weights of the item after taking some or all of it 
            maxCapacity -=availableWeights;//update the remaining carrying capacity of the knapsack    
        }
        return maxValue;
    }
    public static int getMaxIndex(int[] values, int[]weights){
        int index = 0;
        double max = 0.000;
        for(int i = 0; i < values.length; i++){
            if(weights[i]!=0 && (double)values[i]/weights[i]>max){
                max = (double)values[i]/weights[i];
                index = i;
            }
        }
        return index;
    }
}
