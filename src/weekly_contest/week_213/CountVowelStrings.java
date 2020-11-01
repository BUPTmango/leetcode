package weekly_contest.week_213;

import java.util.Arrays;

/**
 * 5555. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 *
 * 输入：n = 33
 * 输出：66045
 *
 * 提示：
 *
 * 1 <= n <= 50
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 11:10 上午
 */
public class CountVowelStrings {
    public int countVowelStrings(int n) {
        int[] times = new int[5];
        Arrays.fill(times, 1);

        while (n-- > 1) {
            for (int i = 1; i < 5; i++) {
                times[i] += times[i - 1];
            }
        }

        return sumArray(times);
    }

    private int sumArray(int[] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountVowelStrings count = new CountVowelStrings();
        System.out.println(count.countVowelStrings(33));
    }
}
