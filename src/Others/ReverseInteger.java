package Others;

import java.util.Scanner;


/**
 * Given integers like 123 the algorithm would
 * reverse the number like 321.
 * Similarly, input like -123 would get a result like -321
 */

public class ReverseInteger {

    // store the result
    private static String store;

    public static void main(String[] args) {

        new ReverseInteger().solution();

    }

    private void solution() {

        // initialize all variables and objects

        store = "";
        Scanner input = new Scanner(System.in);
        // get users input
        System.out.println("Please input an integer:");
        int temp = input.nextInt();
        // run function
        while (temp != 0) {
            temp = getNumber(temp);
        }
        // output the result
        System.out.println(store);

    }

    private int getNumber(int num) {
        // process negative integer
        if (num < 0) {
            store = store + '-';
            num = num * (-1);
        }
        // get one digit one time
        int temp = num % 10;
        store = store + (temp);
        return num / 10;
    }
}


