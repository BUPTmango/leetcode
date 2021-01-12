package middle_level;

/**
 * 只出现一次的数字
 * 260. 只出现一次的数字 III
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子，[5, 3]也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/11 10:57 上午
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int ret = 0;
        // 全员异或
        for (int n : nums) {
            ret ^= n;
        }
        // 找到第一个异或为1的地方 也就是两个数字不一样的地方 通过这个标准来对数组重新分为两组 就可以把这两个单独的数字分别放在两个组中
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // 进行分组异或
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
