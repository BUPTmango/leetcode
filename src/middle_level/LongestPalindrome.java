package middle_level;

import com.sun.deploy.util.StringUtils;

/**
 * 5
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 * @author Wang Guolong
 * @create 2019-04-01 5:29 PM
 */
public class LongestPalindrome {
    /**
     * 暴力法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.equals("")) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int maxlength = 1;//最长字符串长度
        int start = 0;//回文开始的地方
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int head = 0;
                int tail = 0;
                // 对每个子串都从两边开始向中间遍历
                for (head = i, tail = j; head < tail; head++, tail--) {
                    if (s.charAt(head) != s.charAt(tail)) {
                        break;
                    }
                }
                // 若index1=index2,表示串是类似于abcba这种类型；若大于，则是abccba这种类型
                if(head >= tail && j - i + 1 > maxlength) {
                    maxlength = j - i + 1;
                    start = i;
                }
            }
        }
        if (maxlength > 0) {
            return s.substring(start, start + maxlength);
        }
        return null;
    }
}