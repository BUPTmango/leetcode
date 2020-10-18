package middle_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * 给定链表头结点head，该链表上的每个结点都有一个 唯一的整型值 。
 *
 * 同时给定列表G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表G中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表G中）构成的集合。
 *
 * 示例1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * 
 * 提示：
 *
 * 如果N是给定链表head的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为[0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 9:49 上午
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] G) {
        // G -> set
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        // 标记是否为新组件的开始
        boolean flag = false;
        int count = 0;
        // 遍历链表
        ListNode pointer = head;
        while (pointer != null) {
            // 包含 如果是新组件的开始 count++
            if (set.contains(pointer.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                // 不包含 继续寻找新组件的开始
                flag = false;
            }
            pointer = pointer.next;
        }
        return count;
    }
}
