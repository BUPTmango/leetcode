package simple_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是?push to back, peek/pop from front, size, 和?is empty?这些操作是合法的。
 * 你所使用的语言也许不支持队列。?你可以使用 list 或者 deque（双端队列）来模拟一个队列?, 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/3 12:21 下午
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
        // 先添加元素
        queue1.add(x);
        // 将另一个队列的添加过来
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        // 交换
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
