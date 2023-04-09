import javax.swing.text.html.HTMLDocument.RunElement;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *  
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
    示例 1：
    输入：s = "Hello World"
    输出：5
    解释：最后一个单词是“World”，长度为5。

    示例 2：
    输入：s = "   fly me   to   the moon  "
    输出：4
    解释：最后一个单词是“moon”，长度为4。

    示例 3：
    输入：s = "luffy is still joyboy"
    输出：6
    解释：最后一个单词是长度为6的“joyboy”。

 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int len = s.length();
        for (int index = len - 1; index >= 0; index--) {
            char ele = s.charAt(index);
            if (ele != ' ') {
                ans++;
            } else if (ans != 0) {
                return ans;
            }
            //这里，如果 ele == ' '的话，说明最后一个单词被遍历完了，就判断else if的状态，返回长度 
        }
        return ans;
    }
}
// @lc code=end
