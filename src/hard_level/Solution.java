package hard_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 数据结构设计
 * 710. 黑名单中的随机数
 * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
 *
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 *
 * 提示:
 *
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N)不包含N，详细参见interval notation。
 * 示例 1:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出: [null,0,0,0]
 * 示例 2:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出: [null,1,1,1]
 * 示例 3:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * 示例 4:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出: [null,1,3,1]
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N和黑名单B。pick没有参数，输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/2 9:23 下午
 */
public class Solution {
    private int sz;
    private Map<Integer, Integer> mapping;
    private Random random = new Random();
    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        mapping = new HashMap<>();
        // 赋值为多少都可以 目的是把键存到哈希表，方便快速判断数字是否在黑名单内
        for (int b : blacklist) {
            mapping.put(b, 666);
        }
        int last = N - 1;
        for (int b : blacklist) {
            // 如果b已经在区间[sz, N]
            if (b >= sz) {
                continue;
            }
            // 跳过所有黑名单中的数字
            while (mapping.containsKey(last)) {
                last--;
            }
            // 将黑名单中的数字映射到合法数字
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        // 随机选取一个索引
        int index = random.nextInt(sz);
        // 这个索引命中了黑名单 需要被映射到其他位置
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        // 如果没有命中黑名单 直接返回
        return index;
    }
}
