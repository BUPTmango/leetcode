package simple_level;

/**
 * ���ֲ���
 * 704. ���ֲ���
 * ����һ��n��Ԫ������ģ�������������nums ��һ��Ŀ��ֵtarget ��дһ����������nums�е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
 *
 * ʾ�� 1:
 *
 * ����: nums = [-1,0,3,5,9,12], target = 9
 * ���: 4
 * ����: 9 ������ nums �в����±�Ϊ 4
 * ʾ��2:
 *
 * ����: nums = [-1,0,3,5,9,12], target = 2
 * ���: -1
 * ����: 2 ������ nums ����˷��� -1
 * 
 *
 * ��ʾ��
 *
 * ����Լ��� nums�е�����Ԫ���ǲ��ظ��ġ�
 * n����[1, 10000]֮�䡣
 * nums��ÿ��Ԫ�ض�����[-9999, 9999]֮�䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 9:59 ����
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // [left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{1,2,2,2,5}, 9));
    }
}
