package simple_level;

import java.util.Stack;

/**
 * 155
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author mango
 * @create 2019-03-26 9:56 AM
 */

/**
 * 使用两个栈 s1， s2，s1 正常的入栈出栈，s2存放s1中所有节点的最小值。
 * 入栈
 * 待入栈的值 x 不是最小值，s1 正常入栈，s2不操作
 * 待入栈的值 x 小于等于 s2 栈顶的值，说明有新的最小值，s1 正常入栈， 同时把 x 入到 s2 栈中，始终保持 s2 栈顶元素是最小值。
 * 出栈
 * 出栈的值不是最小值，s1 正常出栈，s2 不操作
 * 出栈的值是最小值，s1 正常出栈，最小值要更新，所以 s2 也出栈
 * 获取最小值
 * 直接就是 s2 的栈顶元素。
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MinStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) {
            s2.push(x);
        }
    }

    public void pop() {
        if (s2.peek().equals(s1.peek())) {//注意这里必须要使用equals，因为Integer是一个整数对象
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */