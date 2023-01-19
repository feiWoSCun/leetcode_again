package Honetooyoung.Y23M01D12;

class Solution2 {
    /*给你一个下标从 0开始长度为 n的字符串num，它只包含数字。

如果对于 每个0 <= i < n的下标i，都满足数位i在 num中出现了num[i]次，那么请你返回true，否则返回false。*/
    public static void main(String[] args) {
        System.out.println(new Solution2().digitCount("1210"));
    }

    public boolean digitCount(String num) {
        StringBuilder temp = new StringBuilder(num);
        for (int i = 0; i < num.length(); i++) {
            int t = Integer.parseInt(String.valueOf(num.charAt(i)));
            char x;
            try {
                x = temp.charAt(t);
            } catch (Exception e) {
                return false;
            }
            int t2 = Integer.parseInt(String.valueOf(x));
            t2--;
            if (t2 < 0) {
                return false;
            }
            temp.replace(t, t + 1, Integer.toString(t2));
        }
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != '0')
                return false;
        }
        return true;
    }
}