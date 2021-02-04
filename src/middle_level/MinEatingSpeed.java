package middle_level;

/**
 * 利用二分搜索穷举
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/4 10:24 上午
 */
public class MinEatingSpeed {
    /**
     * 可以使用二分搜索，对于有范围的结果，可以通过二分法进行穷举
     *
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        // speed最小为1 最大为max(piles)
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, speed);
        }
        return time <= H;
    }

    private int timeOf(int pile, int speed) {
        return pile / speed + ((pile % speed > 0) ? 1 : 0);
    }
}
