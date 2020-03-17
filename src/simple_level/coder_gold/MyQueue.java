package simple_level.coder_gold;

import java.util.Stack;

/**
 * ������ 03.04. ��ջΪ��
 * ʵ��һ��MyQueue�࣬����������ջ��ʵ��һ�����С�
 *
 * ʾ����
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // ���� 1
 * queue.pop();   // ���� 1
 * queue.empty(); // ���� false
 *
 * ˵����
 *
 * ��ֻ��ʹ�ñ�׼��ջ���� -- Ҳ����ֻ�� push to top, peek/pop from top, size �� is empty �����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
 * �������в���������Ч�� �����磬һ���յĶ��в������ pop ���� peek ��������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/17 10:49 ����
 */
class MyQueue {

    private Stack<Integer> numStack;
    private Stack<Integer> helpStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        numStack = new Stack<>();
        helpStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        numStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return helpStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (helpStack.isEmpty()) {
            while (!numStack.isEmpty()) {
                helpStack.push(numStack.pop());
            }
        }

        return helpStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return helpStack.isEmpty() && numStack.isEmpty();
    }
}

