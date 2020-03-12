package simple_level.jianzhi_offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ������53 - II. 0��n-1��ȱʧ������
 * һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0��n-1֮�ڡ��ڷ�Χ0��n-1�ڵ�n������������ֻ��һ�����ֲ��ڸ������У����ҳ�������֡�
 *
 * ʾ�� 1:
 *
 * ����: [0,1,3]
 * ���: 2
 * ʾ��?2:
 *
 * ����: [0,1,2,3,4,5,6,7,9]
 * ���: 8
 *
 * ���ƣ�
 *
 * 1 <= ���鳤�� <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/12 9:31 ����
 */
public class MissingNumber {
    /**
     * �Լ�д��
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * �������ö��ֲ���
     * @param nums
     * @return
     */
    public int missingNumber_better(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid != nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
