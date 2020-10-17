package middle_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.04. �ָ�����
 * ��д������ x Ϊ��׼�ָ�����ʹ������С�� x �Ľڵ����ڴ��ڻ���� x �Ľڵ�֮ǰ����������а��� x��x ֻ�������С�� x ��Ԫ��֮��(������ʾ)���ָ�Ԫ�� x ֻ�账�ڡ��Ұ벿�֡����ɣ��䲻��Ҫ����������������֮�䡣
 *
 * ʾ��:
 *
 * ����: head = 3->5->8->5->10->2->1, x = 5
 * ���: 3->1->2->10->5->5->8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 9:28 ����
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode q = head;
        // qΪ����ָ��
        while (q != null) {
            if (q.val < x) {
                // p��q����val
                int middle = p.val;
                p.val = q.val;
                q.val = middle;
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}
