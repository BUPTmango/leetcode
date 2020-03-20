package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.07. �����ཻ
 * �������������������ж������Ƿ��ཻ�����ؽ��㡣��ע���ཻ�Ķ�����ڽڵ�����ã������ǻ��ڽڵ��ֵ�����仰˵�����һ������ĵ�k���ڵ�����һ������ĵ�j���ڵ���ͬһ�ڵ㣨������ȫ��ͬ�����������������ཻ��
 * ʾ�� 1��
 *
 * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * �����Reference of the node with value = 8
 * ������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬��������б��ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]���� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/20 9:50 ����
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
