package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 反转链表
 * 《玩转算法面试视频例题》 链表
 * 206
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/9 11:28 下午
 */
public class ReverseList {
    /**
     * 思路：
     * 很经典的问题，首先设置pre,cur,lat三个指针
     *
     * pre   cur  lat
     * null   1 -> 2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * 接着cur.next = pre
     *
     * pre   cur  lat
     * null <-1    2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * 接着pre = cur，cur = lat，lat = lat.next
     *
     *       pre  cur  lat
     * null <-1    2 -> 3 -> 4 -> 5 -> null
     * 1
     * 2
     * 重复上述操作直到lat=None。
     *
     *                      pre  cur  lat
     * null <-1 <- 2 <- 3 <- 4    5 -> null
     * 1
     * 2
     * 最后cur.next = pre即可。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode lat = cur.next;
        while (lat != null) {
            cur.next = pre;
            pre = cur;
            cur = lat;
            lat = lat.next;
        }
        cur.next = pre;
        return cur;
    }
}
