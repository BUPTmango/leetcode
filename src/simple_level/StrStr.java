package simple_level;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author mango
 * @create 2019-03-08 1:46 PM
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int index = 0;
            int j = i;
            while (j < haystack.length()) {
                if (haystack.charAt(j) == needle.charAt(index)) {
                    j++;
                    index++;
                    if (index == needle.length()) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }
}