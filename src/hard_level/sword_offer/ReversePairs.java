package hard_level.sword_offer;

/**
 * ��ָ Offer 51. �����е������
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬�����������е�����Ե�������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [7,5,6,4]
 * ���: 5
 * <p>
 * ���ƣ�
 * <p>
 * 0 <= ���鳤�� <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/9 10:12 ����
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        // �����Զ������� ����˵������
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        // ��ʹ��һ����ʱ���� ������̫��
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] ��������Ը�����������
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // �Ż������� ����Ѿ����� ֱ�ӷ��� ����merge
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] ����nums[mid + 1..right] ����
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // merge��ʱ����temp��������ռ�
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                // ��������������С��ǰ����������� �����Ҫ����ǰ������ʣ�����ֵĸ���
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
