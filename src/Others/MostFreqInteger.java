package Others;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find the most frequent integer.
 * Write a method that takes an array of integers and returns an integer.
 */



public class MostFreqInteger {

    public static void main(String[] args) {

        int[] arr = {1,2,44,5,22,2,5,5};

       int result = new MostFreqInteger().findFrequency(arr);
        System.out.println(result);
    }

    private int findFrequency(int[] ints){

        // store the result
        Map<Integer,Integer> freq = new HashMap<>();
        // use number in the array as key
        for(int i = 0; i < ints.length; i++){
            if (freq.containsKey(ints[i])){
                int freqNum = freq.get(ints[i]);
                freq.put(ints[i], ++freqNum);

            }else freq.put(ints[i], 1);
        }

        int number = Integer.MIN_VALUE;
        int frequency = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry:
        freq.entrySet()){
            if (entry.getValue() > frequency){
                number = entry.getKey();
                frequency = entry.getValue();
            }
        }
        return number;
    }
}
