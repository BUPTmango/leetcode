package simple_level;

/**
 * 461
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/8 10:57 下午
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        //取x,y的异或，得到一个2进制，其中1的个数就是汉明距离
        int z = x ^ y;
        //用z与z-1做与运算，结果也做相同操作，运算几次就有几个1
        while (z != 0) {
            hammingDistance++;
            //  & 从高位开始比较，如果两个数都为1则为1，否则为0。
            z = z & (z - 1);
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        HammingDistance distance = new HammingDistance();
        System.out.println(distance.hammingDistance(1,4));
    }
}
