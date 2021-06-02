package middle_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. �������������
 * ����һ���������� nums ��һ������k ����дһ���������жϸ������Ƿ���ͬʱ�����������������������飺
 * <p>
 * �������С ����Ϊ 2 ����
 * ������Ԫ���ܺ�Ϊ k �ı�����
 * ������ڣ����� true �����򣬷��� false ��
 * <p>
 * �������һ������ n �������� x ���� x = n * k ����� x �� k ��һ��������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [23,2,4,6,7], k = 6
 * �����true
 * ���ͣ�[2,4] ��һ����СΪ 2 �������飬���Һ�Ϊ 6 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [23,2,6,4,7], k = 6
 * �����true
 * ���ͣ�[23, 2, 6, 4, 7] �Ǵ�СΪ 5 �������飬���Һ�Ϊ 42 ��
 * 42 �� 6 �ı�������Ϊ 42 = 7 * 6 �� 7 ��һ��������
 * ʾ�� 3��
 * <p>
 * ���룺nums = [23,2,6,4,7], k = 13
 * �����false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/2 09:10
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            // ����k�ı�������ʾ���߳���k��������ͬ
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                // ��hashmap��¼ÿ��������һ�γ��ֵ��±�
                map.put(remainder, i);
            }
        }
        return false;
    }
}
