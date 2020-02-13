package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlgorithmTest {


    public static void main(String[] args) {

        String str1 = "a[b]2cd[ef]5ghi";
        String str2 = "a[b[c]2]3"; // ab[c]2b[c]2b[c]2 --> abccbccbcc

        String test1 = new AlgorithmTest().detect(str1);
        String test2 = new AlgorithmTest().detect(str2);


    }

    private String detect(String str) {

        String copy = str;
        String front = "";
        String rear = "";
//        ArrayList<String> words = new ArrayList<>();
        boolean startBrace = false;
        int startIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            if (!startBrace) {

                if (str.charAt(i) == '[') {
                    startBrace = true;
                    startIndex = i;
                }
            } else {
                if (str.charAt(i) == ']') {
                    startBrace = false;
                    String temp = str.substring(startIndex, i)
                            .replaceAll("\\[", "")
                            .replaceAll("]", "");

                    int k = i + 1;
                    String digit = "";

                    while (Character.isDigit(str.charAt(k))) {
                        digit = digit + (str.charAt(k));
                        k++;
                    }

                    int times = Integer.parseInt(digit);
                    String t = "";
                    while (times>0){
                        t = t +temp;
                        times--;
                    }


                    System.out.println(copy.substring(0,startIndex));
                    System.out.println();

                    copy = copy.substring(0,startIndex)+t+copy.substring(k);


//                    words.add(t + "," + digit);
                }
                if (str.charAt(i) == '[') {
                    startIndex = i;
                }
            }

        }

//        printArray(words);

        System.out.println(copy);

        return copy;

    }

    private void printArray(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {

                System.out.print(list.get(i)+" , ");
            }
        }
        System.out.println();
    }



}
