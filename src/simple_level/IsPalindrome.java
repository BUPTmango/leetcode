package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 234
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 10:59 下午
 */
public class IsPalindrome {
    /**
     * https://blog.csdn.net/ds19980228/article/details/84191952
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        //注意点,这里fast的赋值
        ListNode fast=head.next,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        ListNode newhead=null;
        slow.next = null;
        //逆置后半段链表
        while(tmp!=null){
            ListNode cur=tmp.next;
            tmp.next = newhead;
            newhead=tmp;
            tmp=cur;
        }
        //将两段链表进行比较
        while(newhead!=null){
            if(newhead.val!=head.val){
                return false;
            }
            newhead=newhead.next;
            head=head.next;
        }
        return true;
    }

}
