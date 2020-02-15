package test_cases;

import exceptions.InvalidInputException;

import java.util.Random;

public class Cases {

    public static int[] incrementInts(int start, int end, int stepValue) throws InvalidInputException {
        if (start>end){
            throw new InvalidInputException("start["+start+"]is smaller than end["+end+"]");
        }

        int[] temp = new int[end - start + 1];
        for (int i = 1;i<temp.length;i++){
            temp[i] = temp[i-1]+stepValue;
        }
        System.out.println(toString(temp));
        return temp;
    }

    public static int[] randomInts(int lowerBound,int upperBound, int size) throws InvalidInputException {
        if (size<1){
            throw new InvalidInputException("Size cannot be 0");
        }

        if (lowerBound>upperBound){
            throw new InvalidInputException(
                    "Lower Bound["+lowerBound+"]is smaller than Upper Bound["+upperBound+"]");
        }

        int[] temp = new int[size];
        for (int i = 0;i<temp.length;i++){
            temp[i] = randomInt(lowerBound,upperBound);
        }
        System.out.println(toString(temp));
        return temp;
    }

    private static int randomInt(int lowerBound, int upperBound) throws InvalidInputException {
        if (lowerBound>upperBound){
            throw new InvalidInputException(
                    "Lower Bound["+lowerBound+"]is smaller than Upper Bound["+upperBound+"]");
        }

        Random random = new Random();
        return lowerBound + random.nextInt(upperBound-lowerBound+1);
    }

    private static String toString(int[] ints){
        String temp = "";
        for (int i:ints){
            temp = temp + i+", ";
        }
        temp = temp.substring(0,temp.length()-2);
        temp = "Test integer array:" +"\n"+
                "{"+temp+"}";
        return temp;
    }
}
