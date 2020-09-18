package simple_level;

/**
 * 《玩转算法面试视频例题》对撞指针
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/28 7:22 下午
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 定义元音字母
        String vowels = "aeiouAEIOU";

        // 将字符串转化成char类型数组
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            // 双指针相向而行找元音字符
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }
            // 找到后交换字母
            swap(chars, start, end);
            // 更新两端索引
            start++;
            end--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }
}
