package middle_level;

import java.util.Stack;

/**
 * 150. �沨�����ʽ��ֵ
 * �����沨����ʾ��������ʽ��ֵ��
 *
 * ��Ч�����������?+,?-,?*,?/?��ÿ��������������������Ҳ��������һ���沨�����ʽ��
 *
 * ˵����
 *
 * ��������ֻ�����������֡�
 * �����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
 * ʾ��?1��
 *
 * ����: ["2", "1", "+", "3", "*"]
 * ���: 9
 * ����: ((2 + 1) * 3) = 9
 * ʾ��?2��
 *
 * ����: ["4", "13", "5", "/", "+"]
 * ���: 6
 * ����: (4 + (13 / 5)) = 6
 * ʾ��?3��
 *
 * ����: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * ���: 22
 * ����:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 9:20 ����
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
}
