package simple_level.coder_gold;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/22 10:20 上午
 */

import java.util.Stack;

class MinStack {
    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head = null;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        }
            /*新加入节点的min字段（最小值）为：自己的值和栈顶的值较小的那个*/
        else if (head != null) {
            int min = Math.min(x, head.min);
            Node node = new Node(x, min, head);
            head = node;
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}