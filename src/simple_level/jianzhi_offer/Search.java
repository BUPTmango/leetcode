package simple_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ������53 - I. �����������в������� I
 * ͳ��һ�����������������г��ֵĴ�����
 *
 * ʾ�� 1:
 *
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: 2
 * ʾ��?2:
 *
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: 0
 * ?
 * ���ƣ�
 *
 * 0 <= ���鳤�� <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/11 8:13 ����
 */
public class Search {
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.get(target) == null ? 0 : map.get(target);
    }
}