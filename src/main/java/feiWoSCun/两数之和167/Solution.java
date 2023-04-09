package feiWoSCun.两数之和167;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/3/23
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {2,3,4};
        int target=6;
        Solution solution = new Solution();
        int[] ints1 = solution.twoSum(ints, target);
        System.out.println(ints1);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        //index1的下标
        int j = 0;
        int length = numbers.length;
        while (j < length) {
            //确定target
            int index2 = target - numbers[j];
            //二分
            int left = 0;
            int right = length;
            int middle = 0;
            while (left < right) {
                middle = left + (right - left) / 2;
                int temp = numbers[middle];
                if (temp > index2) {
                    right = middle;
                } else if (temp < index2) {
                    left = middle + 1;
                } else if (temp == index2) {
                    //防止index1==index2;
                    if (middle == j) {
                        left = middle + 1;
                        continue;
                    }
                    result[0] = j+1;
                    result[1] = middle+1;
                  //  int[] ints = {1, 2};
                    return result;
                }
            }
            j+=1;
        }
        return result;
    }
}
