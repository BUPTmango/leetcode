package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/31 9:22 上午
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1. 确定所求数位的所在数字的位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2. 确定所求数位所在的数字
        long num = start + (n - 1) / digit;
        // 3. 确定所求数位在 numnum 的哪一数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
