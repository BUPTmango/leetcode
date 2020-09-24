package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 《玩转算法面试视频例题》 链表
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤?m?≤?n?≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/3 3:24 下午
 */
public class ReverseBetween {
    /**
     * 迭代解法 推荐
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_iterator(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        // 找到起始点
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // tail 指针指向从链表头起的第 m 个结点，此结点是反转后链表的尾部，故称为 tail。
        // con 指针指向第 m 个结点的前一个结点，此结点是新链表的头部。'
        // tail 和 con 指针在算法开始时被初始化，在算法最后被调用，用于完成链表反转。
        ListNode con = prev, tail = cur;

        // 反转链表
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // 使用 con 指针来连接 prev 指针
        // 利用 tail 指针来连接 prev 指针之后的结点 cur
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }


    private boolean stop;
    private ListNode left;

    /**
     * 递归解法
     * 我们需要两个不同指针，一个指向第 m 个结点，另一个指向第 n 个结点。
     * 一旦有了这两个指针，我们就可以不断地交换这两个指针指向结点的数据，并将两个指针相向移动，就像字符串的情况那样。
     *
     * @param right
     * @param m
     * @param n
     */
    public void recurseAndReverse(ListNode right, int m, int n) {

        // 当n的值到达1时，我们就回溯
        if (n == 1) {
            return;
        }

        // 右移right指针
        right = right.next;

        // 右移left指针
        if (m > 1) {
            this.left = this.left.next;
        }

        // m和n同时减一继续递归
        this.recurseAndReverse(right, m - 1, n - 1);

        // 如果左右指针交叉或者指向同一个节点 就停止
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // 修改left和right节点的数据的值 有可能不允许
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween_recursive(ListNode head, int m, int n) {
        // 最开始left和right节点都指向head节点
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
