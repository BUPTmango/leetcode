package simple_level;

import java.util.*;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/12 8:40 上午
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        // 双指针 只要保证偶数位置上是偶数就行 剩下的奇数自然就在奇数位置上了
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            // 如果A[i]为奇数 就不断移动j 直到遇见下一个偶数
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParityII s = new SortArrayByParityII();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
