package hard_level;

/**
 * 493. 翻转对
 * 给定一个数组nums，如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/28 10:59 上午
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        res += mergeSort(nums, lo, mid);
        res += mergeSort(nums, mid + 1, hi);
        res += merge(nums, lo, mid, hi);
        return res;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        // 先进行计数
        int count = 0;
        int p = lo, q = mid + 1;
        while (p <= mid && q <= hi) {
            if ((long) nums[p] > (long) 2 * nums[q]) {
                // 比如1，3，4 这里3如果比1两倍大，那么后面的数也一定比1的两倍大，所以要都加上去
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }

        // 再进行正常的merge操作
        int[] a = new int[hi - lo + 1];
        p = lo;
        q = mid + 1;
        int index = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                a[index++] = nums[q++];
            } else {
                a[index++] = nums[p++];
            }
        }
        while (p <= mid) {
            a[index++] = nums[p++];
        }
        while (q <= hi) {
            a[index++] = nums[q++];
        }
        System.arraycopy(a, 0, nums, lo, hi - lo + 1);
        return count;
    }
}
