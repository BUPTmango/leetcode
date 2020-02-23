package simple_level;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 注意两处防止溢出的处理 就是越界问题
 *      换加法为减法 换乘法为除法
 *
 * @author mango
 * @create 2019-03-15 7:52 PM
 */
public class MySqrt {
    public static int mySqrt(int x) {
        int result = 0;
        if (x <= 0) {
            return result;
        }
        if (x == 1) {
            return 1;
        }
        //可以通过二分法计算
        int left = 0, right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;//防止越界
            //if (middle * middle <= x) 用乘法出现越界 可以改用除法解决
            //除法还要注意0的问题
            if (middle  <= x / middle) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}