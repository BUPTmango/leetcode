package simple_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 1290. ����������ת����
 * ����һ������������ý��head��������ÿ������ֵ���� 0 ���� 1����֪��������һ���������ֵĶ����Ʊ�ʾ��ʽ��
 *
 * ���㷵�ظ���������ʾ���ֵ� ʮ����ֵ ��
 *
 * ʾ�� 1��
 *
 * ���룺head = [1,0,1]
 * �����5
 * ���ͣ��������� (101) ת��Ϊʮ������ (5)
 * ʾ�� 2��
 *
 * ���룺head = [0]
 * �����0
 * ʾ�� 3��
 *
 * ���룺head = [1]
 * �����1
 * ʾ�� 4��
 *
 * ���룺head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * �����18880
 * ʾ�� 5��
 *
 * ���룺head = [0,0]
 * �����0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 9:41 ����
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        // ��ת����
        head = reverseList(head);
        // ������ȡ���
        int count = 0;
        ListNode p = head;
        int multi = 0;
        while (p != null) {
            if (p.val == 1) {
                count += Math.pow(2, multi);
            }
            multi++;
            p = p.next;
        }
        return count;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            // ��������
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        GetDecimalValue get = new GetDecimalValue();
        ListNode head = LinkedListUtil.create(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0});
        System.out.println(get.getDecimalValue(head));
    }
}
