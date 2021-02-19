package middle_level;

/**
 * 540. ���������еĵ�һԪ��
 * ����һ��ֻ�����������������飬ÿ��Ԫ�ض���������Σ�Ψ��һ����ֻ�����һ�Σ��ҳ��������
 *
 * ʾ�� 1:
 *
 * ����: [1,1,2,3,3,4,4,8,8]
 * ���: 2
 * ʾ�� 2:
 *
 * ����: [3,3,7,7,10,11,11]
 * ���: 10
 * ע��: ���ķ���Ӧ���� O(log n)ʱ�临�ӶȺ� O(1)�ռ临�Ӷ������С�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/19 9:03 ����
 */
public class SingleNonDuplicate {
    /**
     * midÿ�ζ�Ҫȡż�������ж�nums[mid]==nums[mid+1]�����ɵ�֪��������߻����Ұ�ߡ�
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
