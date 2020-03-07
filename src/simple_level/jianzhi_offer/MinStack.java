package simple_level.jianzhi_offer;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * ?
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/7 8:38 上午
 */
class MinStack {

    Stack<Integer> stack = null;
    /**
     * 把最小元素放到辅助栈中，每次从辅助栈中取出最小元素
     */
    Stack<Integer> min = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {        //  注意这里x <= min.peek()是有=的，否则会报错
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
