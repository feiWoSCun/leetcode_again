package Honetooyoung.年前.Y22M12D31;

import java.util.Arrays;
import java.util.List;

class LeetCode2037 {
    /*一个房间里有 n个座位和 n名学生，房间用一个数轴表示。给你一个长度为 n的数组seats，其中seats[i] 是第 i个座位的位置。

    同时给你一个长度为 n的数组students，其中students[j]是第 j位学生的位置。

    你可以执行以下操作任意次：

    增加或者减少第i位学生的位置，每次变化量为 1（也就是将第 i位学生从位置 x移动到 x + 1或者 x - 1）

    请你返回使所有学生都有座位坐的 最少移动次数，并确保没有两位学生的座位相同。

    请注意，初始时有可能有多个座位或者多位学生在 同一位置。*/
}

class Solution {
    public static void main(String[] args) {
        int[] a = {11, 21, 3, 4, 2, 15};
        int[] b = {5, 3, 8, 2, 3, 11};
        System.out.println(Solution.minMovesToSeat(a, b));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        List<Integer> seatList = Arrays.stream(seats).boxed().sorted(Integer::compareTo).toList();
        List<Integer> studentList = Arrays.stream(students).boxed().sorted(Integer::compareTo).toList();
            /*Arrays.sort(seats);
                Arrays.sort(students);
                这样就行了    /捂脸
                */
        int ans = 0;
        for (int i = 0; i < seatList.size(); i++) {
            ans += Math.abs(seatList.get(i) - studentList.get(i));
        }
        return ans;
    }
}
