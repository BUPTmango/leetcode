package simple_level.jianzhi_offer;

/**
 * 面试题05. ti替换空格
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

    public String replaceSpace_array(String s) {
        int length = s.length();
        // 声明为3倍的大小 就算全是空格也不会越界
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
