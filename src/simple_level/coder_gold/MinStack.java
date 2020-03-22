package simple_level.coder_gold;

/**
 * ������ 03.02. ջ����Сֵ
 * �����һ��ջ�����˳���ջ֧�ֵ�pop��push�������⣬��֧��min�������ú�������ջԪ���е���Сֵ��ִ��push��pop��min������ʱ�临�Ӷȱ���ΪO(1)��
 * <p>
 * <p>
 * ʾ����
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.getMin();   --> ���� -2.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/22 10:20 ����
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
            /*�¼���ڵ��min�ֶΣ���Сֵ��Ϊ���Լ���ֵ��ջ����ֵ��С���Ǹ�*/
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