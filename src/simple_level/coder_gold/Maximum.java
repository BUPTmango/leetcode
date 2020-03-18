package simple_level.coder_gold;

/**
 * 面试题 16.07. 最大数值
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * <p>
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/18 11:05 上午
 */
public class Maximum {
    /**
     * 判断a-b为正数还是负数,int类型负数首位为1，正数为0
     * 所以右移31位 得到正负数 0或1 然后与a，b相乘得结果
     * 由于溢出问题，int转为long进行右移
     *
     * 并不理解！！！！！！！！
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((c - d) >>> 63);// >>>和>>区别 >>>无符号右移
        return b * res + a * (res ^ 1);
    }
}
