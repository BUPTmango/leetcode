package simple_level.jianzhi_offer;

/**
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * ?
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:04 上午
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        if (n < 1) {
            return null;
        }
        int length = (int) Math.pow(10, n) - 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            // 注意！！！！ 这里注意索引的关系 索引从0开始 要错位赋值
            result[i] = i + 1;
        }
        return result;
    }
}
