package hard_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 895. ���Ƶ��ջ
 * ʵ�� FreqStack��ģ������ջ�����ݽṹ�Ĳ�����һ���ࡣ
 *
 * FreqStack������������
 *
 * push(int x)��������x����ջ�С�
 * pop()�����Ƴ�������ջ�г�����Ƶ����Ԫ�ء�
 * �����Ƶ����Ԫ�ز�ֻһ�������Ƴ���������ӽ�ջ����Ԫ�ء�
 * 
 *
 * ʾ����
 *
 * ���룺
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * �����[null,null,null,null,null,null,null,5,7,5,4]
 * ���ͣ�
 * ִ������ .push ������ջ�Ե�����Ϊ [5,7,5,7,4,5]��Ȼ��
 *
 * pop() -> ���� 5����Ϊ 5 �ǳ���Ƶ����ߵġ�
 * ջ��� [5,7,5,7,4]��
 *
 * pop() -> ���� 7����Ϊ 5 �� 7 ����Ƶ����ߵģ��� 7 ��ӽ�ջ����
 * ջ��� [5,7,5,4]��
 *
 * pop() -> ���� 5 ��
 * ջ��� [5,7,4]��
 *
 * pop() -> ���� 4 ��
 * ջ��� [5,7]��
 * 
 *
 * ��ʾ��
 *
 * ��FreqStack.push(int x)�ĵ�����0 <= x <= 10^9��
 * ���ջ��Ԫ����ĿΪ�㣬��֤������� FreqStack.pop()��
 * �������������У���FreqStack.push���ܵ��ô������ᳬ��10000��
 * �������������У���FreqStack.pop���ܵ��ô������ᳬ��10000��
 * ���в��������У���FreqStack.push�� FreqStack.pop���ܵ��ô������ᳬ��150000��
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 4:33 ����
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    // �ھ�����ͬ�ģ����Ƶ�ʵ�Ԫ���У���ô�ж��Ǹ�Ԫ�������µģ�
    // ���ǿ���ʹ��ջ����ѯ��һ��Ϣ������ջ����Ԫ��������Ը���һЩ��
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }
}
