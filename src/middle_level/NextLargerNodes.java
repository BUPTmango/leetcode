package middle_level;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点head作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于node_i，如果其next_larger(node_i)是node_j.val，那么就有j > i且node_j.val > node_i.val，而j是可能的选项中最小的那个。如果不存在这样的j，那么下一个更大值为0。
 *
 * 返回整数答案数组answer，其中answer[i] = next_larger(node_{i+1})。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为2，第二个节点值为 1，第三个节点值为5 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * 
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val<= 10^9
 * 给定列表的长度在 [0, 10000]范围内
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 11:36 上午
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 创建一个单调栈
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        // 从后向前遍历
        for (int i = list.size() - 1; i >= 0; i--) {
            // 清空栈中比当前元素小的所有元素
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            // 取出栈顶元素作为结果的i位置
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            // 将list中的i位置加入栈中
            stack.push(list.get(i));
        }
        return res;
    }
}
