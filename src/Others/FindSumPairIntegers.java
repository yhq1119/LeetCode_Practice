package Others;

import java.util.ArrayList;
import java.util.Set;

/**
 * Given an array of non-negative integers
 * and a positive integer n,
 * print out all the pairs of integers whose sum is n.
 *
 * { 1, 2, 9, 12}, 10 => 1 9
 * { 1, 9, 1, 9}, 10 => 1 9 \n 1 9
 * { 1, 9, 1} => 1 9
 *
 */

public class FindSumPairIntegers {

    public static void main(String[] args) {
        int[] test1 = {1 , 2, 9,12};
        int sum = 10;
        int[] test2 = {1,9,1,9};
        int[] test3 = {1,2,9,10,12};
        int[] test4 = {1,2,5};
        new FindSumPairIntegers().findPair(test1,sum);
        new FindSumPairIntegers().findPair(test2,sum);
        new FindSumPairIntegers().findPair(test3,sum);
        new FindSumPairIntegers().findPair(test4,sum);

    }

    private class Pair{

        int X;
        int Y;

        public Pair(int x, int y){
            this.X = x;
            this.Y = y;
        }

        public String toString(){
            return " "+X+" "+Y+" ";
        }
    }

    private ArrayList<Pair> findPair(int[] ints, int sum){
        ArrayList<Pair> temp = new ArrayList<>();
        int[] copy = ints.clone();
        if (ints.length<2){
            System.out.println("Invalid array");
            return null;
        }

        for (int i = 0; i < ints.length ;i++){
            if (ints[i]>sum){
                continue;
            }
            int search = sum - ints[i];
            for (int j = i+1;j<ints.length;j++){
                if (ints[j]==search){
                    temp.add(new Pair(ints[i],ints[j]));
                    ints[i] +=sum;
                    ints[j] +=sum;
                    break;
                }
            }
        }

        System.out.println("Result of "+showInts(copy)+" sum of ["+sum+"]");

        if (temp.size()<1){
            System.out.print("Empty"+"\n");
        }else {
            for (Pair P : temp) {
                System.out.print(P.toString() + "\n");
            }
        }
        System.out.println();

        return temp;
    }

    private String showInts(int[] arr){
        String temp = "";
        for (int i:arr){
            temp = temp+i+",";
        }
        temp = temp.substring(0,temp.length()-1);
        temp = "{"+temp+"}";
        return temp;
    }

}
