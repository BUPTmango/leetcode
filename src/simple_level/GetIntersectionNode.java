package simple_level;

import data_structure.linked_list.ListNode;

import java.util.Stack;

/**
 * 160
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author mango
 * @create 2019-03-26 4:59 PM
 */
public class GetIntersectionNode {
    /**
     * 完全可以逆着推，这里运用了Java的栈来进行处理，
     * 把结点都入栈，然后一个个排查，直到不等就返回上一个相等的结点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA, stackB;
        stackA = new Stack<>();
        stackB = new Stack<>();
        ListNode t = null;
        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }while(headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        while(!stackA.isEmpty()&&!stackB.isEmpty()){
            if(stackA.peek() == stackB.peek()){
                t = stackA.pop();
                stackB.pop();
            }else break;
        }
        return t;
    }
}