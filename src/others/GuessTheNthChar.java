package others;

/**
 * Given a String like "X[Y]n"
 * it means the content Y inside the [] would
 * be repeated n times. This type of String allows
 * nested rules like "X[Z[Y]n]m"
 *
 * Now design an algorithm to get the Nth char of
 * such String.
 *
 */

public class GuessTheNthChar {


    public static void main(String[] args) {

        String str1 = "a[b]2cd[ef]5ghi";
        String str2 = "a[b[c[ok]2]2]2"; // ab[c]2b[c]2b[c]2 --> abccbccbcc

        new GuessTheNthChar().showAt(str1,18);
        new GuessTheNthChar().showAt(str2,5);


//        System.out.println("fin " + test1);
//        System.out.println("fin " + test2);


    }

    private void showAt(String str, int n){

        String detect = detect(str);

        if (str!=null&&detect.length()>0){
            if (n>0&&n<detect.length()+1){
                System.out.println(
                        "The character of "+str+" at ["+n+"] is ["+detect.charAt(n-1)+"]"
                );}
            else {
                System.out.println("Not a valid n");
            }
        }else {
            System.out.println("Not a valid String");
        }
    }

    private String detect(String str) {

        String copy = str;
        int count = 0;

        boolean startBrace = false;
        int startIndex = 0;

        for (int i = 0; i < copy.length(); i++) {

            if (!startBrace) {

                if (copy.charAt(i) == '[') {
                    startBrace = true;
                    startIndex = i;
                }
            } else {
                if (copy.charAt(i) == ']') {
                    String temp = copy.substring(startIndex, i)
                            .replaceAll("\\[", "")
                            .replaceAll("]", "");

                    int k = i;
                    k = k + 1;
                    String digit = "";


                    if (k > copy.length() - 1) {

                    } else {
//                        System.out.println(k);
                        while (Character.isDigit(copy.charAt(k))) {
                            digit = digit + (copy.charAt(k));

                            k++;
                            if (k > copy.length() - 1) {
                                break;
                            }
                        }
                    }

                    int times = Integer.parseInt(digit);
                    String t = "";
                    while (times > 0) {
                        t = t + temp;
                        times--;
                    }
                    startBrace = false;
                    copy = copy.substring(0, startIndex) + t + copy.substring(k);

                } else if (copy.charAt(i) == '[') {
                    startIndex = i;
                    count++;
                    startBrace = true;
                }

            }

        }

//        printArray(words);

//        System.out.println(copy);
        while (count > 0) {
            copy = detect(copy);
            count--;
        }

        return copy;

    }

//    private void printArray(ArrayList list) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) != null) {
//
//                System.out.print(list.get(i) + " , ");
//            }
//        }
//        System.out.println();
//    }
}
