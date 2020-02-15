package stack;

import exceptions.InvalidInputException;
import test_cases.Cases;

/** Given a sequence of n integers a1, a2, ..., an,
 * a 132 pattern is a subsequence ai, aj, ak such
 * that i < j < k and ai < ak < aj. Design an algorithm
 * that takes a list of n numbers as input and checks whether
 * there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:
 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.
 Example 2:
 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 Example 3:
 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence:
 [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*/
public class OneThreeTwoPattern {

    public static void main(String[] args) throws InvalidInputException {

        int[] test = Cases.randomInts(0,15,100);

        int[] test1 = {1,2,3,4,5,6,7};
        int[] test2 = {-1,4,1,1,3,3,4};
        int[] test3 = {-1, 0 ,3 ,3, 2, 0};
        System.out.println(new OneThreeTwoPattern().bruteForce(test3));
        System.out.println(new OneThreeTwoPattern().bruteForceImpvd(test3));
        System.out.println(new OneThreeTwoPattern().bruteForceImpvd2(test3));
        System.out.println(new OneThreeTwoPattern().bruteForce(test));
    }

    public boolean bruteForce(int[] nums){
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j< nums.length - 1;j++){
                for (int k = j + 1; k<nums.length;k++){
                    if (nums[k] > nums[i] && nums[j] > nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bruteForceImpvd(int[] nums){
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j <nums.length - 1;j++){
                if (nums[i]<nums[j]){
                    for (int k = j + 1;k <nums.length;k++){
                        if (nums[j]>nums[k] && nums[k]>nums[i]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean bruteForceImpvd2(int[] nums){
        int min_first = Integer.MAX_VALUE;
        for (int j = 0; j< nums.length-1; j++){
            min_first = Math.min(min_first, nums[j]);
            for (int k = j + 1; k < nums.length;k++){
                if (nums[k] < nums[j] && min_first < nums[k]){
                    return true;
                }
            }
        }return false;
    }
}
