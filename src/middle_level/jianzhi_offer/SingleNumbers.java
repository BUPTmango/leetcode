package middle_level.jianzhi_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ָ Offer 56 - I. ���������ֳ��ֵĴ���
 * һ���������� nums �����������֮�⣬�������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,1,4,6]
 * �����[1,6] �� [6,1]
 * ʾ�� 2��
 *
 * ���룺nums = [1,2,10,4,1,4,3,3]
 * �����[2,10] �� [10,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/7 10:19 ����
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>(2);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                resultList.add(num);
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     * ��������ͬ�����ֵַ��������� �ֱ�ȫԱ���
     * @param nums
     * @return
     */
    public int[] singleNumbers_better(int[] nums) {
        int ret = 0;
        // ȫԱ���
        for (int n : nums) {
            ret ^= n;
        }
        // �ҵ���һ��Ϊ1�ĵط� Ҳ�����������ֲ�һ���ĵط�
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // ���з������
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
