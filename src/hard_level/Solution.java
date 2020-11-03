package hard_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ���ݽṹ���
 * 710. �������е������
 * ����һ������ [0��n ) �ж��ص������ĺ����� B��дһ�������� [ 0��n ) �з���һ������ B �е����������
 *
 * ���������Ż�ʹ�価���ٵ���ϵͳ���� Math.random() ��
 *
 * ��ʾ:
 *
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N)������N����ϸ�μ�interval notation��
 * ʾ�� 1:
 *
 * ����:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * ���: [null,0,0,0]
 * ʾ�� 2:
 *
 * ����:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * ���: [null,1,1,1]
 * ʾ�� 3:
 *
 * ����:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * ʾ�� 4:
 *
 * ����:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * ���: [null,1,3,1]
 * �����﷨˵����
 *
 * �����������б����ó�Ա�������͵��õĲ�����Solution�Ĺ��캯��������������N�ͺ�����B��pickû�в��������������һ���б���ʹ����Ϊ�գ�Ҳ������һ�� [] ���б�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/2 9:23 ����
 */
public class Solution {
    private int sz;
    private Map<Integer, Integer> mapping;
    private Random random = new Random();
    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        mapping = new HashMap<>();
        // ��ֵΪ���ٶ����� Ŀ���ǰѼ��浽��ϣ����������ж������Ƿ��ں�������
        for (int b : blacklist) {
            mapping.put(b, 666);
        }
        int last = N - 1;
        for (int b : blacklist) {
            // ���b�Ѿ�������[sz, N]
            if (b >= sz) {
                continue;
            }
            // �������к������е�����
            while (mapping.containsKey(last)) {
                last--;
            }
            // ���������е�����ӳ�䵽�Ϸ�����
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        // ���ѡȡһ������
        int index = random.nextInt(sz);
        // ������������˺����� ��Ҫ��ӳ�䵽����λ��
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        // ���û�����к����� ֱ�ӷ���
        return index;
    }
}
