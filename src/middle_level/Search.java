package middle_level;

/**
 * 33. ������ת��������
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 *
 * ( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
 *
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
 *
 * ����Լ��������в������ظ���Ԫ�ء�
 *
 * ����㷨ʱ�临�Ӷȱ�����?O(log?n) ����
 *
 * ʾ�� 1:
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 * ʾ��?2:
 *
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 12:11 ����
 */
public class Search {
    /**
     * ���ֲ���
     * middle�ֳɵ����߿϶���һ��������ģ�ͨ���˵�����ж���һ������
     * �����ǱߵĶ˵���max��min�������ж�target�ǲ���������
     * ��������Ļ���ȥ��һ��Ѱ��
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = left + (right-left) / 2;
        while (left <= right) {
            if (nums[middle] == target) {
                return middle;
            }
            // �������
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target <= nums[middle]) {
                    // target����߷�Χ��
                    right = middle - 1;
                } else {
                    // ֻ�ܴ��ұ���
                    left = middle + 1;
                }
            } else {
                if(target >= nums[middle] && target <= nums[right]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
            middle = left + (right-left) / 2;
        }
        return -1;
    }
}
