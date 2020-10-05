package hard_level;

import data_structure.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 《玩转算法面试视频例题》优先队列
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/5 8:45 下午
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // 添加所有链表的头指针到优先队列中
        for (ListNode node : lists) {
            // ！！！ 注意要加上if (node != null) 否则会出现空指针
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while (!heap.isEmpty()) {
            // 取出最小的节点
            ListNode element = heap.poll();
            // 如果链表后面还有元素的话 添加
            if (element.next != null) {
                heap.add(element.next);
            }
            // 断掉element的指针
            element.next = null;
            pointer.next = element;
            pointer = pointer.next;
        }

        return dummy.next;
    }
}
