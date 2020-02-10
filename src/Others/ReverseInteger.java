package Others;

import java.util.Scanner;

public class ReverseInteger {

    // store the result
    private static String store;

    public static void main(String[] args) {

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

    private static int getNumber(int num) {
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


