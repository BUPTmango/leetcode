package simple_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ������39. �����г��ִ�������һ�������
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * <p>
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * <p>
 * ʾ��?1:
 * <p>
 * ����: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * ���: 2
 * ?
 * ���ƣ�
 * <p>
 * 1 <= ���鳤�� <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/4 9:46 ����
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Ʊ���ͣ� �����������ֵĴ����������鳤�ȵ�һ�룻���� ���� ��Ʊ��Ϊ +1 �������� ��Ʊ��Ϊ -1 ����һ�����������ֵ� Ʊ���� > 0 ��
     *
     * @param nums
     * @return
     */
    public int majorityElement_vote(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            // ��̬ѡ�� ��Ĭ�ϵ�һ��Ϊ���� ���votes��Ϊ0 ��ѡ����һ������
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }

        // ȷʵ���� 1/2 �ŷ���   ��Ϊ�п������������в���������
        votes = 0;
        for (int num : nums) {
            if (num == x) {
                votes++;
            }
        }
        if (votes > nums.length / 2) {
            return x;
        }
        return 0;
    }
}
