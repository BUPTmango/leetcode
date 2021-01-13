package simple_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. �ö���ʵ��ջ
 * ʹ�ö���ʵ��ջ�����в�����
 * <p>
 * push(x) -- Ԫ�� x ��ջ
 * pop() -- �Ƴ�ջ��Ԫ��
 * top() -- ��ȡջ��Ԫ��
 * empty() -- ����ջ�Ƿ�Ϊ��
 * ע��:
 * <p>
 * ��ֻ��ʹ�ö��еĻ�������-- Ҳ����?push to back, peek/pop from front, size, ��?is empty?��Щ�����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧�ֶ��С�?�����ʹ�� list ���� deque��˫�˶��У���ģ��һ������?, ֻҪ�Ǳ�׼�Ķ��в������ɡ�
 * ����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/3 12:21 ����
 */
class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // �����Ԫ��
        queue1.add(x);
        // ����һ�����е���ӹ���
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        // ����
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue2.isEmpty();
    }
}
