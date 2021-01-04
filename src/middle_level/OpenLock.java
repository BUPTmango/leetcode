package middle_level;

import java.util.*;

/**
 * 双向BFS
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为? '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * ?
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/6 6:30 下午
 */
public class OpenLock {
    /**
     * 广度优先搜索
     * 我们可以将 0000 到 9999 这 10000 状态看成图上的 10000 个节点，
     * 两个节点之间存在一条边，当且仅当这两个节点对应的状态只有 1 位不同，
     * 且不同的那位相差 1（包括 0 和 9 也相差 1 的情况），并且这两个节点均不在数组 deadends 中。
     * 那么最终的答案即为 0000 到 target 的最短路径。
     * <p>
     * 我们用广度优先搜索来找到最短路径，从 0000 开始搜索。
     * 对于每一个状态，它可以扩展到最多 8 个状态，即将它的第 i = 0, 1, 2, 3 位增加 1 或减少 1，
     * 将这些状态中没有搜索过并且不在 deadends 中的状态全部加入到队列中，并继续进行搜索。
     * 注意 0000 本身有可能也在 deadends 中。
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        // 将deadends放入set中 dead
        Set<String> dead = new HashSet();
        Collections.addAll(dead, deadends);

        Queue<String> queue = new LinkedList();
        // 添加初始状态
        queue.offer("0000");

        // 表示已经出现过的情形
        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                String node = queue.poll();
                // 如果遇到dead继续遍历
                if (dead.contains(node)) {
                    continue;
                }
                if (node.equals(target)) {
                    return depth;
                }
                // 四个轮子
                for (int i = 0; i < 4; ++i) {
                    // 每个轮子可以进行上下拨动 也就是1或者是-1
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }


    /**
     * 双向BFS
     * 因为直到终点 可以使用双向BFS
     * @param deadends
     * @param target
     * @return
     */
    public int openLock_another(String[] deadends, String target) {
        // 将deadends放入set中 dead
        Set<String> dead = new HashSet();
        Collections.addAll(dead, deadends);

        // 用集合不用队列 可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        // 一个添加起点 一个添加终点 两者轮换进行 一个从上往下 一个从下往上 共同寻路
        q1.add("0000");
        q2.add(target);

        // 表示已经出现过的情形
        Set<String> seen = new HashSet();

        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // set在遍历中不能修改，使用temp存储扩散结果
            Set<String> temp = new HashSet<>();

            // 将q1中的所有节点向周围扩散
            for (String cur : q1) {
                // 如果遇到dead继续遍历
                if (dead.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                seen.add(cur);

                // 四个轮子
                for (int i = 0; i < 4; ++i) {
                    // 每个轮子可以进行上下拨动 也就是1或者是-1
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((cur.charAt(i) - '0') + d + 10) % 10;
                        String nei = cur.substring(0, i) + ("" + y) + cur.substring(i + 1);
                        if (!seen.contains(nei)) {
                            temp.add(nei);
                        }
                    }
                }
            }
            step++;
            // 这里交换q1q2，下一轮就是扩散q2
            // temp就相当于是q1
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
