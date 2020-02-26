package simple_level.jianzhi_offer;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * ?
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:11 上午
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.replace(" ", "%20");
        return s;
    }
}
