package middle_level;

/**
 * ��ת��������
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
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
