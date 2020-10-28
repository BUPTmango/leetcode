package middle_level;

/**
 * ���ֲ���
 * 34. �����������в���Ԫ�صĵ�һ�������һ��λ��
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * <p>
 * ����㷨ʱ�临�Ӷȱ�����O(log n) ����
 * <p>
 * ��������в�����Ŀ��ֵ������[-1, -1]��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: [3,4]
 * ʾ��2:
 * <p>
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: [-1,-1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 11:05 ����
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] rangeRes = new int[]{-1, -1};

        int index = binarySearch(nums, target);
        if (index == -1) {
            return rangeRes;
        }

        // �ҵ�λ�ú���������չ
        int start = index, end = index;
        while (start - 1 >= 0 && nums[start - 1] == target) {
            start--;
        }
        while (end + 1 < nums.length && nums[end + 1] == target) {
            end++;
        }

        rangeRes[0] = start;
        rangeRes[1] = end;
        return rangeRes;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
