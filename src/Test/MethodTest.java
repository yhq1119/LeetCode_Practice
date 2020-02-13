package Test;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MethodTest {

    String test1 = "1110000";
    String test2 = "1111000";
    String test3 = "10";
    String str1 = "a[b]2cd[ef]99ghi";
    String str2 = "a[b[c]2]3"; // ab[c]2b[c]2b[c]2 --> abccbccbcc

    @Test
    public void test1() throws ParseException {

        str1 = jsonTest(str1);
        str2 = jsonTest(str2);
        str1 = "{" + str1 + "}";
        str2 = "{" + str2 + "}";
        System.out.println(str1);
        System.out.println(str2);

        JSONParser parser = new JSONParser();
        JSONObject string1 = (JSONObject) parser.parse(str1);
        JSONObject string2 = (JSONObject) parser.parse(str2);
        System.out.println(string1);
        System.out.println(string2);

    }

    private void detectFromIndex(int i) {

    }

    @Test
    public void test2() {

        System.out.println(str1.charAt(1) == '[');
        System.out.println(str1.charAt(4));

        extend(str1);
        extend(str2);

    }

    private String extend(String origin) {
        String temp = "";

        boolean findStarter = false;

        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        int startIndex = 0, endIndex = 0;


        for (int i = 0; i < origin.length(); i++) {

            if (!findStarter) {
                if (origin.charAt(i) == '[') {
                    findStarter = true;
                    startIndex = i + 1;
                    indexes.add(i);
                }
            }
            if (findStarter) {
                if (origin.charAt(i) == ']') {
                    findStarter = false;
                    indexes.add(i);
                    endIndex = i;

                    words.add(origin.substring(startIndex, endIndex));

                }
            }
        }


        printArray(words);
        System.out.println();

        return temp;

    }

    private void printArray(ArrayList list) {

        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print("{" + list.get(i) + "}");
        }

    }


    private String jsonTest(String str) {

        String temp = str.replaceAll("\\[", "{");
        String temp2 = temp.replaceAll("\\]", "}");
        System.out.println(temp2);
        return temp2;

    }
}
