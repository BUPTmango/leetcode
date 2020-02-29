package simple_level.jianzhi_offer;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead?操作返回 -1 )?
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对?appendTail、deleteHead 进行?10000?次调用
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/29 9:07 上午
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * 相当于用两个后进先出实现一个先进先出
     */
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        stack1.add(value);
    }

    public int deleteHead() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}
