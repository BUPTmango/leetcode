package middle_level;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 * 
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/20 09:04
 */
public class TopKFrequentString {
    public List<String> topKFrequent(String[] words, int k) {
        // 统计单词出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 自定义排序并放入堆中
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);
            } else {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 遍历输出
        List<String> top_k = new ArrayList<>();
        while (!queue.isEmpty()) {
            top_k.add(queue.poll());
        }
        // 倒序
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        TopKFrequentString top = new TopKFrequentString();
        List<String> strings = top.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        strings.forEach(System.out::println);
    }
}
