package simple_level.coder_gold;

/**
 * 面试题 05.06. 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/30 10:08 上午
 */
public class ConvertInteger {
    /**
     * 即求A与B异或的值中1的个数, 通过n&(n - 1)可以去掉一个数的二进制表示的最右边的1.
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);
            count++;
        }
        return count;
    }
}
