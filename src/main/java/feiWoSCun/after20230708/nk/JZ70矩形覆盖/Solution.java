package feiWoSCun.after20230708.nk.JZ70矩形覆盖;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/23
 * @Email: 2825097536@qq.com
 */

import java.util.*;

public class Solution {
    public int rectCover(int target) {
        if (target <= 2) {
            return target;
        }

        int dpFir = 1;
        int dpSec = 2;

        int res = dpFir + dpSec;
        for (int i = 3; i <= target; i++) {
            res = dpFir + dpSec;
            dpFir = dpSec;
            dpSec = res;
        }
        return res;
    }
}