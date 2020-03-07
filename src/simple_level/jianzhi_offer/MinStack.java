package simple_level.jianzhi_offer;

import java.util.Stack;

/**
 * ������30. ����min������ջ
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
 *
 * ʾ��:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.min();   --> ���� -2.
 * ?
 * ��ʾ��
 *
 * �������ĵ����ܴ��������� 20000 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/7 8:38 ����
 */
class MinStack {

    Stack<Integer> stack = null;
    /**
     * ����СԪ�طŵ�����ջ�У�ÿ�δӸ���ջ��ȡ����СԪ��
     */
    Stack<Integer> min = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {        //  ע������x <= min.peek()����=�ģ�����ᱨ��
            min.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
