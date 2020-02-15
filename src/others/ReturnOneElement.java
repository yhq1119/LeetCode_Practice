package others;

/**
 * Given an array of integers, you may assume that
 * every element appears twice except one. (So a.length >= 3.)
 * Return that one element
 *
 * {1, 9, 9, 1, 5, 12, 12} => 5
 * {12, 12, 1} => 1
 *
 * Constant Space
 * and O(n) time
 */
public class ReturnOneElement {
    public static void main(String[] args) {

        int[] a = {1, 9, 9, 1, 5, 12, 12};
        int[] b = {12, 12, 1};
        System.out.println(new ReturnOneElement().solution(a));
        System.out.println(new ReturnOneElement().solution(b));
    }

    private int solution(int[] arr){
        int temp = 0;
        for (int i = 0; i<arr.length;i++){
            temp ^= arr[i];
        }
        return temp;
    }



}
