package simple_level.jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * ?
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/2 11:33 上午
 */
public class FindContinuousSequence {
    /**
     * 利用双指针，low = 1,high = 2;
     * sum记录low 与high 之间所有数字的和，
     * 接下来比较sum 与 target的关系，
     * 如果sum大，就说明需要减小一个值， 此时减掉一个low，
     * 如果sum小，说明需要继续增加high，加入到sum中
     * 如果二者相等，就将low 和high之间的所有数字加入一个数组，并将这个数组存入一个链表，
     * 到最后使用 list.toArray() 返回一个数组即可
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        // 从1和2开始计算
        int low = 1;
        int high = 2;
        // 计算sum
        int sum = low + high;
        List<int[]> list = new ArrayList<>();
        while (low < high && high < target) {
            // sum小 增加一个值 添加high
            if (sum < target) {
                high++;
                sum += high;
                // sum大 需要减少一个值 减掉一个low
            } else if (sum > target) {
                sum -= low;
                low++;
                // 找到了 将low和high之间的连续正数添加到结果集中
            } else {
                int[] sub = new int[high - low + 1];
                int j = low;
                for (int i = 0; i < high - low + 1; i++, j++) {
                    sub[i] = j;
                }
                list.add(sub);
                sum -= low;
                low++;
            }
        }
        int[][] out = new int[list.size()][];
        return list.toArray(out);
    }
}
