package middle_level;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前?k?高的元素。
 *
 * ?
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/10 11:45 上午
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 通过map统计数字出现次数
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 定义优先队列排序规则 根据出现次数排序
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(count::get));

        // 保持队列中有k个元素
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 遍历输出
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        // 倒序
        Collections.reverse(top_k);
        return top_k;
    }
}
