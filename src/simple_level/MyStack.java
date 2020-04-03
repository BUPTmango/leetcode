package simple_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. �ö���ʵ��ջ
 * ʹ�ö���ʵ��ջ�����в�����
 *
 * push(x) -- Ԫ�� x ��ջ
 * pop() -- �Ƴ�ջ��Ԫ��
 * top() -- ��ȡջ��Ԫ��
 * empty() -- ����ջ�Ƿ�Ϊ��
 * ע��:
 *
 * ��ֻ��ʹ�ö��еĻ�������-- Ҳ����?push to back, peek/pop from front, size, ��?is empty?��Щ�����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧�ֶ��С�?�����ʹ�� list ���� deque��˫�˶��У���ģ��һ������?, ֻҪ�Ǳ�׼�Ķ��в������ɡ�
 * ����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/3 12:21 ����
 */
class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        q1.remove();
        int res = top;
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
