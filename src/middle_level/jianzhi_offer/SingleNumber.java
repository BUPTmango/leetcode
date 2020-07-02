package middle_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָ Offer 56 - II. ���������ֳ��ֵĴ��� II
 * ��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [3,4,3,3]
 * �����4
 * ʾ�� 2��
 *
 * ���룺nums = [9,1,7,9,7,9,7]
 * �����1
 *
 * ���ƣ�
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/2 5:55 ����
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
