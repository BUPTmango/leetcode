package middle_level;

import data_structure.linked_list.ListNode;

import java.util.Stack;

/**
 * 445. ������� II
 * ���������ǿ����������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢�������֡�����������ӻ᷵��һ���µ�����
 *
 * ?
 *
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 *
 * ����:
 *
 * ��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��
 *
 * ʾ��:
 *
 * ����: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * ���: 7 -> 8 -> 0 -> 7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/9 11:50 ����
 */
public class AddTwoNumbers {
    /**
     * ���ܷ�ת�����Խ���ջ��ѹ��ջ�У���ջ��Ԫ�����
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
