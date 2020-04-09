package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 24. �������������еĽڵ�
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ʾ��:
 *
 * ���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 11:48 ����
 */
public class SwapPairs {
    /**
     * �ݹ鷨(����Ϊ�ݹ鷨�ĵ���Ӧ��)
     * ���ڵݹ鷨���ԣ���Ҫ��ע����ؼ�����Ҫ�أ�����ֵ�����õ�Ԫ�Ĳ�������ֹ������
     * a) ����ֵ��������ɺ��������
     * b) ���õ�Ԫ��������Ҫ�����������ڵ�ΪfirstNode��secondNode��firstNode�������Ӻ��潻����ɵ�������secondNode����firstNode����ɱ��ֽ���������
     * c) ��ֹ������firstNode����secondNodeΪ�գ���Ӧ��ǰû�нڵ����ʣ�����һ�������Ľڵ�������
     * ������
     * a) �������ŷ�Ϊ������ŵĽڵ��ż����ŵĽڵ㡣(Ҫ��ɵĲ����ǽ���Ӧ�ڵ���������)
     * b) ���������ڵ㡣
     * c) ά��һ��preNode�ڵ㣬preNode.nextָ�򽻻����ͷ�ڵ㡣
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
