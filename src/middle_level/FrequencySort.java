package middle_level;

import java.util.PriorityQueue;

/**
 * 《玩转算法面试视频例题》查找问题
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/19 9:25 下午
 */
public class FrequencySort {
    /**
     * 用哈希表存储每个字符的出现次数，
     * 再通过一个大顶堆（根据出现次数排序），不断取出堆顶元素，
     * 使用StringBuilder不断append即可。
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        int[] letters = new int[128];
        // 用hash表存储每个元素的出现次数
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        // 根据元素的出现次数将元素放入一个大顶堆中
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }

        // 将出现次数不为0的字符append到stringBuilder中
        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
