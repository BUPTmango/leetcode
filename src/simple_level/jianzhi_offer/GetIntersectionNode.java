package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * ������52. ��������ĵ�һ�������ڵ�
 *
 * �������������ҳ����ǵĵ�һ�������ڵ㡣
 * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * �����Reference of the node with value = 8
 * ������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬��������б��ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]���� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 *
 * ע�⣺
 *
 * �����������û�н��㣬���� null.
 * �ڷ��ؽ���������������뱣��ԭ�еĽṹ��
 * �ɼٶ���������ṹ��û��ѭ����
 * ���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/5 10:09 ����
 */
public class GetIntersectionNode {
    /**
     * ����ʹ������ָ�� node1��node2 �ֱ�ָ���������� headA��headB ��ͷ��㣬
     * Ȼ��ͬʱ�ֱ����������
     * �� node1 �������� headA ��ĩβʱ�����¶�λ������ headB ��ͷ��㣻
     * �� node2 �������� headB ��ĩβʱ�����¶�λ������ headA ��ͷ��㡣
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
