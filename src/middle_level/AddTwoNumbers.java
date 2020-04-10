package middle_level;

import data_structure.linked_list.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 * ?
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/9 11:50 下午
 */
public class AddTwoNumbers {
    /**
     * 不能翻转，可以借用栈，压入栈中，按栈顶元素相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack();
        Stack<Integer> stack2=new Stack();
        ListNode node1=l1;
        while(node1!=null){
            stack1.push(node1.val);
            node1=node1.next;
        }
        ListNode node2=l2;
        while(node2!=null){
            stack2.push(node2.val);
            node2=node2.next;
        }
        ListNode head=null;
        int flag=0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||flag!=0){
            int value=0;
            if(!stack1.isEmpty()) {
                value+=stack1.pop();
            }
            if(!stack2.isEmpty()) {
                value+=stack2.pop();
            }
            value+=flag;
            ListNode node=new ListNode(value%10);
            flag=value/10;
            node.next=head;
            head=node;
        }
        return head;
    }
}
