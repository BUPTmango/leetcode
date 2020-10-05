package hard_level;

import data_structure.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ����ת�㷨������Ƶ���⡷���ȶ���
 * 23. �ϲ�K����������
 * ����һ���������飬ÿ�������Ѿ����������С�
 *
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
 * �����[1,1,2,3,4,4,5,6]
 * ���ͣ������������£�
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * �����Ǻϲ���һ�����������еõ���
 * 1->1->2->3->4->4->5->6
 * ʾ�� 2��
 *
 * ���룺lists = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺lists = [[]]
 * �����[]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/5 8:45 ����
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // ������������ͷָ�뵽���ȶ�����
        for (ListNode node : lists) {
            // ������ ע��Ҫ����if (node != null) �������ֿ�ָ��
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while (!heap.isEmpty()) {
            // ȡ����С�Ľڵ�
            ListNode element = heap.poll();
            // ���������滹��Ԫ�صĻ� ���
            if (element.next != null) {
                heap.add(element.next);
            }
            // �ϵ�element��ָ��
            element.next = null;
            pointer.next = element;
            pointer = pointer.next;
        }

        return dummy.next;
    }
}
