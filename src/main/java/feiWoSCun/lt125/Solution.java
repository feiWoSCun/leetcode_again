package feiWoSCun.lt125;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/14
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        new Solution().isPalindrome(".,");
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;
        while (p2 - p1 > 0) {
            while (p1<chars.length-1&&!this.ifC(chars[p1])) {
                p1++;
            }
            while (p2>=0&&!this.ifC(chars[p2])) {
                p2--;
            }

            if(p1>p2||p2<0||p1>chars.length-1){
                break;
            }
            int a = Math.abs(chars[p2] - chars[p1]);
            if (chars[p1]>57&&chars[p2]>57) {
                if (a == sub || 0 == a) {
                } else {
                    return false;
                }
            }else if(chars[p1]<=57&&chars[p2]<=57){
                if(a==0){
                }else {
                    return false;
                }
            }else{
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    int sub = Math.abs('A' - 'a');
    int bigBegin = 'A';
    int bigEnd = 'Z';
    int smallBegin = 'a';
    int smallEnd = 'z';
    int szBegin='0';
    int szEnd='9';


    private boolean ifC(Character c) {
        int num = (int) c;
        return (num <= smallEnd && num >= smallBegin) || (num <= bigEnd && num >= bigBegin)||(szBegin<=num&&num<=szEnd);
    }
}