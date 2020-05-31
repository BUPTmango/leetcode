package middle_level;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串?s?，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即?'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o?各 2 个，以及 0 个 a，u 。
 * 示例 2：
 *
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 *
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/31 4:29 下午
 */
public class FindTheLongestSubstring {
    /**
     *
     * 看不懂
     *
     * 将这么一个结构当作我们哈希表存储的键值，如果题目稍作修改扩大了字符集，那么维护起来可能会比较吃力。考虑到出现次数的奇偶性其实无非就两个值，00 代表出现了偶数次，11 代表出现了奇数次，我们可以将其压缩到一个二进制数中，第 kk 位的 00 或 11 代表了第 kk 个元音字母出现的奇偶性。举一个例子，假如到第 ii 个位置，u o i e a 出现的奇偶性分别为 1 1 0 0 1，那么我们就可以将其压成一个二进制数 (11001)_2=(25)_{10}(11001)
     * 2
     * ?
     *  =(25)
     * 10
     * ?
     *   作为它的状态。这样我们就可以将 55 个元音字母出现次数的奇偶性压缩到了一个二进制数中，且连续对应了二进制数的 [(00000)_2,(11111)_2][(00000)
     * 2
     * ?
     *  ,(11111)
     * 2
     * ?
     *  ] 的范围，转成十进制数即 [0,31][0,31]。因此我们也不再需要使用哈希表，直接用一个长度为 3232 的数组来存储对应状态出现的最早位置即可。
     *
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
