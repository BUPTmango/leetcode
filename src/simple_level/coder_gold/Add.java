package simple_level.coder_gold;

/**
 * 面试题 17.01. 不用加号的加法
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 * ?
 *
 * 提示：
 *
 * a,?b?均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/28 10:29 上午
 */
public class Add {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
