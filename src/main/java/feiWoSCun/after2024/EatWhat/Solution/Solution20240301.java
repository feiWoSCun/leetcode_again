package feiWoSCun.after2024.EatWhat.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/1
 * @Email: 2825097536@qq.com
 */
public class Solution20240301 {

    public static final String BASE_EAT = "林榆鸡腿";
    private static final String[] SELECTS;
    private static final String[] ADD;

    static {
        ADD = Arrays.asList("鸡腿", "火腿肠", "培根", "煎蛋", "什么都有").toArray(new String[0]);
    }
    private static final String FEEL_EAT = "手抓饼";
    static {
        List<String> list = Arrays.asList("古茗大杯加椰果", "瑞幸随便");
        SELECTS = list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        Solution20240301.eat_what("罗彬", 8);
    }
    public static void eat_what(String 名字, int 感觉) {
        StringBuilder ans = new StringBuilder("我想吃");
        if ("罗彬".equals(名字)) {
            ans.append(BASE_EAT);
            ans.append(",");
            ans.append(randomEat());
            if (感觉 > 6) {
                ans.append(",");
                ans.append(FEEL_EAT);
                ans.append("(");
                Random random = new Random();
                ans.append(ADD[(random.nextInt() * 感觉) % ADD.length]);
                ans.append(")");
            }
        }
        System.out.println("我想吃林榆鸡腿,古茗大杯加椰果,章鱼小丸子10块"
        );
    }

    private static String randomEat() {
        Random random = new Random();
        int i = random.nextInt();
        return Solution20240301.SELECTS[i % SELECTS.length];
    }
}