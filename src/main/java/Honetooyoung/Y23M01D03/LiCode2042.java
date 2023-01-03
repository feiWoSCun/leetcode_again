package Honetooyoung.Y23M01D03;

public class LiCode2042 {
}

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    public boolean areNumbersAscending(String s) {
        Integer num = null;
        if (s.contains(" ")) {
            int prePointer = s.indexOf(' ');
            if (s.charAt(0) < 59 && s.charAt(0) > 48) {
                num = Integer.parseInt(s.substring(0, prePointer));
            }
            return check(prePointer, s, num);
        } else
            return true;
    }

    private boolean check(int prePointer, String s, Integer num) {
        boolean ans;
        int nextPointer = s.indexOf(' ', prePointer + 1);
        boolean b = s.charAt(prePointer + 1) < 59 && s.charAt(prePointer + 1) > 48;
        if (nextPointer != -1) {
            if (b) {
                int i = Integer.parseInt(s.substring(prePointer + 1, nextPointer));
                if (num != null)
                    num = i > num ? i : -1;
                else
                    num = i;
            }
            Integer x = -1;
            if (x.equals(num))
                return false;
            else {
                ans = check(nextPointer, s, num);
            }
        } else {
            if (b) {
                int i = Integer.parseInt(s.substring(prePointer + 1));
                if (num != null) {
                    return i > num;
                } else
                    return true;
            } else {
                return true;
            }
        }
        return ans;
    }
}
