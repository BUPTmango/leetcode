package middle_level;

import com.sun.deploy.util.StringUtils;

/**
 * 5
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Wang Guolong
 * @create 2019-04-01 5:29 PM
 */
public class LongestPalindrome {
    /**
     * 暴力法
     *
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
                if (head >= tail && j - i + 1 > maxlength) {
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

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome_dp(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串

        // 2. 初始化 对角线上的也就是单个字符的字符串是回文字串 也可以不初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        // 注意：先填左下角
        // 重要！！！！ 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算 原因是一个值参考了它左下角的值（左下角要优先填充！！！！）
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public String longestPalindrome_center(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        // 枚举可以成为回文串中心的位置
        for (int i = 0; i < s.length(); i++) {
            // 分别取奇数和偶数情况下的最大长度
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // right = left 表示是奇数串
        // right = left + 1 表示是偶数串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 和判断回文串逻辑相反 是扩展 left左移 right右移
            --left;
            ++right;
        }
        return right - left - 1;
    }
}