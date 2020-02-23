package simple_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 202
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:?
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/19 10:15 上午
 */
public class IsHappy {
    /**
     * 对于非快乐数，肯定不能进入死循环，那么肯定循环进行到一定程度，数字会和之前出现过n重复，
     * 因此我们保存每一步骤的n，并在得到新的n的时候判断该数字是否出现过，出现过就为非快乐数，跳出循环。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = changeNum(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    private int changeNum(int input) {
        int output = 0;
        while (input != 0) {
            output += (input % 10) * (input % 10);
            input /= 10;
        }
        return output;
    }

    public static void main(String[] args) {
        IsHappy happy = new IsHappy();
        int input = 55;
        for (int i = 0; i < 20; i++) {
            System.out.println(input);
            input = happy.changeNum(input);
        }
    }
}
