package feiWoSCun.after2024.lt165;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/17
 * @Email: 2825097536@qq.com
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.1.11", "1.1.101"));
    }

    public int compareVersion(String version1, String version2) {
        int p1 = 0;
        int p2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        int res = 0;
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        while (p1 < len1 && p2 < len2) {
            while (p1 < len1 && chars1[p1] == '0') {
                System.out.println(p1);
                p1++;
            }
            while (p2 < len2 && chars2[p2] == '0') {
                p2++;
            }
            if (p1 >= len1 || p2 >= len2) {
                break;
            }
            if (chars1[p1] == '.' && chars2[p2] == '.') {
                p1++;
                p2++;
                continue;
            } else if (chars1[p1] == '.') {
                res = -1;
                break;
            } else if (chars2[p2] == '.') {
                res = 1;
                break;
            }
            while (p1 < len1 && p2 < len2 && chars1[p1] != '.' && chars2[p2] != '.') {
                if (chars1[p1] == chars2[p2]) {
p1++;
p2++;
                } else if (chars1[p1] > chars2[p2]) {
                    res = 1;
                    break;
                } else {
                    res = -1;
                    break;
                }

            }

            if (p1 < len1 && chars1[p1] != '.') {
                while (chars1[p1] != '.') {
                    if (chars1[p1] > '0') {
                        res = 1;
                        break;
                    }
                    p1++;
                }

            }
            if (p2 < len2 && chars2[p2] != '.') {
                while (chars2[p2] != '.') {
                    if (chars2[p2] > '0') {
                        res = -1;
                        break;
                    }
                    p2++;

                }
            }
        }
        if (p1 == len1 && p2 == len2) {

        }
        if (p1 == len1) {
            while (++p2 < len2 && chars2[p2] != '.' && chars2[p2] != '0') {
                return -1;
            }
        }
        if (p2 == len2) {
            while (++p1 < len1 && (chars1[p1] == '.' || chars1[p1] == '0')) {
                return 1;
            }
        }
        return res;
    }
}