package hard_level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单调队列
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4<= nums[i]<= 10^4
 * 1 <= k<= nums.length
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 7:52 下午
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 先填满窗口的前k-1
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                // 窗口向前移动 加入新数字
                window.push(nums[i]);
                // 记录当前窗口最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    class MonotonicQueue {
        // 要使用一种数据结构支持在头部和尾部进行插入和删除 双链表
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            // 将前面小于自己的元素都删除
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public int max() {
            // 队头元素肯定是最大的
            return queue.getFirst();
        }

        public void pop(int n) {
            // 想删除的队头元素可能已经不存在了 这时候就不用删除了
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }
}
