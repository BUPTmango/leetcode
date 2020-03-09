package simple_level.jianzhi_offer;

import java.util.LinkedList;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * ?
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出:?3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出:?2
 *
 * 限制：
 *
 * 1 <= n?<= 10^5
 * 1 <= m <= 10^6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/9 9:41 上午
 */
public class LastRemaining {
    /**
     * 通过链表来模拟
     * 但是超出时间限制
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_linkedList(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 记录要删除的索引
        int removeIndex = 0;
        while (list.size() > 1) {
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }
        return list.get(0);
    }

    /**
     * 约瑟夫环问题
     * 公式： f(n,m) = (f(n-1, m) + m) % n      最后的这个n是一直在变化的，就是长度
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_better(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
