package Others;

import java.util.ArrayList;
import java.util.Scanner;

public class Special_Number_1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please input an integer");
        print(result(input.nextInt()));


//        if (checker(input.nextInt())){
//            System.out.println("It is! Congrats!");
//        }else System.out.println("Nah, it is not.");

    }


    private static ArrayList<Integer> result(int num) {
        ArrayList<Integer> temp = new ArrayList<>();

        int upperBound = power(10, num) - 1;
        int lowerBound = power(10, num - 1);

        for (int i = lowerBound; i < upperBound; i++) {
            if (checker(i)) {
                temp.add(i);
            }
        }
        return temp;

    }

    private static boolean checker(int num) {
        // check if the input is valid
        if (num < 0) {
            return false;
        }


        int temp = num;
        ArrayList<Integer> allnum = new ArrayList<>();
        while (temp != 0) {
            allnum.add(0, temp % 10);
            temp = temp / 10;
        }
        int sum = 0;
        for (int i = 0; i < allnum.size(); i++) {
            allnum.set(i, power(allnum.get(i), allnum.size()));
            sum = sum + allnum.get(i);

        }

//        showCal(num, sum);
        return sum == num;
    }


    private static int power(int bt, int pw) {

        if (pw == 1) {
            return bt;
        } else if (pw == 0) {
            return 1;
        } else {


            int[] temp = new int[pw];
            temp[0] = bt;
            for (int i = 0; i < pw; i++) {
                temp[i] = bt;
            }
            int sum = 1;
            for (int i : temp) {
                sum = sum * i;
            }
            return sum;
        }
    }

    private static void print(ArrayList<Integer> list) {

        if (list.size() < 1) {
            System.out.println("Empty");
            return;
        }

        for (Integer I : list) {
            System.out.print("[" + I + "]");
        }

        System.out.println();
    }
    /////

    private static void showCal(int num, int sum) {
        String temp = "";
        int i = num;
        while (i != 0) {
            temp = " + " + i % 10 + temp;
            i = i / 10;
        }

        temp = temp + " = " + sum;

        System.out.println(temp.substring(2));
    }
}
