package feiWoSCun.lt165;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/19
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.0.1", "1"));
    }

    public int compareVersion(String version1, String version2) {
        int p1 = 0;
        int p2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        while (p1 < chars1.length && p2 < chars2.length) {
            while (p1 < len1 && chars1[p1] == '0') {
                p1++;
            }
            while (p2 < len2 && chars2[p2] == '0') {
                p2++;
            }
            if (p1 < chars1.length && p2 < chars2.length) {
                if (chars1[p1] == '.' && chars2[p2] == '.') {
                    p1++;
                    p2++;
                    continue;
                } else if (chars1[p1] == '.') {
                    return -1;
                } else if (chars2[p2] == '.') {
                    return 1;
                }
            }
            int m = p1;
            int n = p2;
            while (m < chars1.length && chars1[m] != '.') {
                m++;
            }
            while (n < chars2.length && chars2[n] != '.') {
                n++;
            }
            while (m > p1 && (chars1[m] == '0'||chars1[m]=='.')){
                m--;
            }
            while (n > p2 && chars1[n] == '0'||chars2[n]=='.') {
                n--;
            }
            while (p1 <= m && p2 <= n) {
                if (chars1[p1] == chars2[p2]) {

                } else if (chars1[p1] > chars2[p2]) {
                    return 1;
                } else {
                    return -1;
                }
                p1++;
                p2++;
            }
            if (m-p1 == n-p2) {
                continue;
            }
            if (m-p1 > n-p2) {
                while (p1 <=m) {
                    if (chars1[p1++] != '0') {
                        return 1;
                    }
                }
            } else {
                while (p2 <=n) {
                    if (chars2[p2++] != '0') {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
}