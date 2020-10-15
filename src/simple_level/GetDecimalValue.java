package simple_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 9:41 上午
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        // 反转链表
        head = reverseList(head);
        // 遍历获取结果
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
            // 更新索引
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
