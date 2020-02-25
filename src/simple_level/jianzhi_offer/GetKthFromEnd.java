package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * ������22. �����е�����k���ڵ�
 * ����һ����������������е�����k���ڵ㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ�������������β�ڵ��ǵ�����1���ڵ㡣���磬һ��������6���ڵ㣬��ͷ�ڵ㿪ʼ�����ǵ�ֵ������1��2��3��4��5��6���������ĵ�����3���ڵ���ֵΪ4�Ľڵ㡣
 *
 * ʾ����
 *
 * ����һ������: 1->2->3->4->5, �� k = 2.
 *
 * �������� 4->5.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/25 10:37 ����
 */
public class GetKthFromEnd {
    /**
     * ����ָ��
     * ���ÿ����k��λ��
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                slow = slow.next;
            } else {
                k--;
            }
        }
        return slow;
    }
}
