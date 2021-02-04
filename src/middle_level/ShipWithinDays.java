package middle_level;

/**
 * 利用二分搜索穷举
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/4 10:44 上午
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // 最小值为min(weights) 最大值为sum(weights)
        int min = Integer.MAX_VALUE, max = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            max += weight;
        }
        int left = min, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int load, int D) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxLoad = load;
            while ((maxLoad -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
