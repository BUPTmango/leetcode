package simple_level;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，?A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/12 9:31 上午
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // 双指针
        int fast = 0, slow = 0;
        // fast找下一个偶数
        while (fast < A.length) {
            if (A[fast] % 2 == 0) {
                swap(A, fast, slow);
                slow++;
            }
            fast++;
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
