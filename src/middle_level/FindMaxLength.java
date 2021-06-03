package middle_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. ��������
 * ����һ������������ nums , �ҵ�������ͬ������ 0 �� 1 ������������飬�����ظ�������ĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����: nums = [0,1]
 * ���: 2
 * ˵��: [0, 1] �Ǿ�����ͬ����0��1������������顣
 * ʾ�� 2:
 *
 * ����: nums = [0,1,0]
 * ���: 2
 * ˵��: [0, 1] (�� [1, 0]) �Ǿ�����ͬ����0��1������������顣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/3 09:08
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        // �ȼ��� 1 ��������ȥ 0 ���������� 0
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // ����������ʹ�ù�ϣ��洢ÿ��ǰ׺�͵�һ�γ��ֵ��±�
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
