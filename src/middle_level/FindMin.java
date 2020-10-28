package middle_level;

/**
 * ���ֲ���
 * 153. Ѱ����ת���������е���Сֵ
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * <p>
 * ( ���磬����[0,1,2,4,5,6,7] ���ܱ�Ϊ[4,5,6,7,0,1,2])��
 * <p>
 * ���ҳ�������С��Ԫ�ء�
 * <p>
 * ����Լ��������в������ظ�Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [3,4,5,1,2]
 * ���: 1
 * ʾ�� 2:
 * <p>
 * ����: [4,5,6,7,0,1,2]
 * ���: 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 10:21 ����
 */
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        // �����һ��Ԫ���Ѿ������һ��С�� �Ǿ���������û�о�����ת������ ֱ�ӷ��ص�һ��Ԫ�ؾͺ��� ������Сֵ
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // ˵��mid+1��ת�۵�
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // ˵��mid��ת�۵�
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            // ע�⣡�� ����midÿ�κ�����ĵ�һ��Ԫ�����Ƚ�
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
