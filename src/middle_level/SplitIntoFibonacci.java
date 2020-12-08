package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. �������ֳ�쳲���������
 * ����һ�������ַ��� S������ S = "123456579"�����ǿ��Խ����ֳ�쳲�����ʽ������ [123, 456, 579]��
 *
 * ��ʽ�ϣ�쳲�����ʽ������һ���Ǹ������б� F�������㣺
 *
 * 0 <= F[i] <= 2^31 - 1����Ҳ����˵��ÿ������������ 32 λ�з����������ͣ���
 * F.length >= 3��
 * �������е�0 <= i < F.length - 2������ F[i] + F[i+1] = F[i+2] ������
 * ���⣬��ע�⣬���ַ�����ֳ�С��ʱ��ÿ���������һ����Ҫ���㿪ͷ����������������� 0 ����
 *
 * ���ش� S ��ֳ���������һ��쳲�����ʽ�����п飬������ܲ���򷵻� []��
 *
 * ʾ�� 1��
 *
 * ���룺"123456579"
 * �����[123,456,579]
 * ʾ�� 2��
 *
 * ����: "11235813"
 * ���: [1,1,2,3,5,8,13]
 * ʾ�� 3��
 *
 * ����: "112358130"
 * ���: []
 * ����: ���������޷���ɡ�
 * ʾ�� 4��
 *
 * ���룺"0123"
 * �����[]
 * ���ͣ�ÿ��������ֲ������㿪ͷ����� "01"��"2"��"3" ������Ч�𰸡�
 * ʾ�� 5��
 *
 * ����: "1101111"
 * ���: [110, 1, 111]
 * ����: ��� [11,0,11,11] Ҳͬ�������ܡ�
 *
 * ��ʾ��
 *
 * 1 <= S.length<= 200
 * �ַ��� S ��ֻ�������֡�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/8 8:50 ����
 */
public class SplitIntoFibonacci {
    /**
     * ���� + ��֦
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            // ��֦---���ȴ��� 1 ������ 0 ��ͷ�ǲ�����Ҫ���
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            // ��֦---��ֳ������������ 32 λ�з�����������
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            // ��֦---����б��������� 2 ���������Ҳ�ֳ������Ѿ�������� 2 �����ĺͣ��Ͳ���Ҫ�������Բ���ˡ�
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            // �ӵ� 3 ������ʼ����Ҫ�жϲ�ֳ������Ƿ����ǰ 2 �����ĺͣ�ֻ������Ҫ��ʱ�Ž��в�֣����򲻽��в�֡�
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
