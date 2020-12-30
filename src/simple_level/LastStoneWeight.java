package simple_level;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/30 9:07 上午
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 创建优先队列 每次取出最大的两个 再放入一个或者不放
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() >= 2) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            int diff = Math.abs(stone1 - stone2);
            if (diff > 0) {
                queue.add(diff);
            }
        }
        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
