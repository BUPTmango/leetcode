package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ 17.10. ��ҪԪ��
 * ��������ж�һ���������ͬһ�������֮Ϊ��ҪԪ�ء�����һ���������飬�ҵ�������ҪԪ�ء���û�У�����-1��
 *
 * ʾ�� 1��
 *
 * ���룺[1,2,5,9,5,9,5,5,5]
 * �����5
 * ?
 *
 * ʾ�� 2��
 *
 * ���룺[3,2]
 * �����-1
 * ?
 *
 * ʾ�� 3��
 *
 * ���룺[2,2,1,1,1,2,2]
 * �����2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/22 10:14 ����
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int num :nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > length / 2) {
                return num;
            }
        }
        return -1;
    }
}
