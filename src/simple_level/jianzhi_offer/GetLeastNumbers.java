package simple_level.jianzhi_offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * ?
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]?<= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/9 9:25 上午
 */
public class GetLeastNumbers {
    /**
     * 应用PriorityQueue
     * 但是耗时会比较长
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for(int i : arr) {
            if(queue.size() < k) {
                queue.add(i);
            } else {
                if(queue.peek() > i) {
                    queue.remove();
                    queue.add(i);
                }
            }
        }
        int[] ref = new int[k];
        int cnt = 0;
        while(queue.size() > 0) {
            ref[cnt++] = queue.remove();
        }
        return ref;
    }
}
