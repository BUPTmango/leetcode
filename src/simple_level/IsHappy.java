package simple_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 202
 * ������
 * ��дһ���㷨���ж�һ�����ǲ��ǡ�����������
 *
 * һ����������������Ϊ������һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ����������ѭ����ʼ�ձ䲻�� 1��������Ա�Ϊ 1����ô��������ǿ�������
 *
 * ʾ��:?
 *
 * ����: 19
 * ���: true
 * ����:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/19 10:15 ����
 */
public class IsHappy {
    /**
     * ���ڷǿ��������϶����ܽ�����ѭ������ô�϶�ѭ�����е�һ���̶ȣ����ֻ��֮ǰ���ֹ�n�ظ���
     * ������Ǳ���ÿһ�����n�����ڵõ��µ�n��ʱ���жϸ������Ƿ���ֹ������ֹ���Ϊ�ǿ�����������ѭ����
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = changeNum(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    private int changeNum(int input) {
        int output = 0;
        while (input != 0) {
            output += (input % 10) * (input % 10);
            input /= 10;
        }
        return output;
    }

    public static void main(String[] args) {
        IsHappy happy = new IsHappy();
        int input = 55;
        for (int i = 0; i < 20; i++) {
            System.out.println(input);
            input = happy.changeNum(input);
        }
    }
}
