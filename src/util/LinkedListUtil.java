package util;

import data_structure.linked_list.ListNode;

/**
 * ��������Ĺ�����
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/24 7:44 ����
 */
public class LinkedListUtil {
    /**
     * �������鴴������
     * @param arr
     * @return
     */
    public static ListNode create(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("NULL");
    }
}
