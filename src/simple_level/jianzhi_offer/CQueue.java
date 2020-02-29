package simple_level.jianzhi_offer;

import java.util.Stack;

/**
 * ������09. ������ջʵ�ֶ���
 * ������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ���ֱ�����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead?�������� -1 )?
 *
 * ʾ�� 1��
 *
 * ���룺
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * �����[null,null,3,-1]
 * ʾ�� 2��
 *
 * ���룺
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * �����[null,-1,null,null,5,2]
 * ��ʾ��
 *
 * 1 <= values <= 10000
 * �����?appendTail��deleteHead ����?10000?�ε���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/29 9:07 ����
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * �൱������������ȳ�ʵ��һ���Ƚ��ȳ�
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
