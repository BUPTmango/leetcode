package simple_level.jianzhi_offer;


/**
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * ?
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * ?
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/8 9:50 上午
 */
public class ConstructArr {
    /**
     * 自己写的方法 超过时间限制 不通过
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int product = 1;
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    product *= a[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    /**
     * 从左往右遍历累乘，结果保存在数组 ret 中，此时 ret[i] 表示，A[i] 左边所有元素的乘积
     * 然后从右往左遍历累乘，获取A[i] 右边所有元素的乘积
     * 两边遍历之后得到的 ret，就是最终结果
     *
     * @param a
     * @return
     */
    public int[] constructArr_better(int[] a) {
        int length = a.length;
        int[] result = new int[length];
        int left = 1;
        for (int i = 0; i < length; i++) {
            result[i] = left;
            left *= a[i];
        }
        int right = 1;
        for (int j = length - 1; j >= 0; j--) {
            result[j] *= right;
            right *= a[j];
        }
        return result;
    }

    public static void main(String[] args) {
        ConstructArr c = new ConstructArr();
        int[] result = c.constructArr(new int[]{1,2,3,4,5});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
