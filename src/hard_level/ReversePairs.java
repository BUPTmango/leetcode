package hard_level;

/**
 * 493. ��ת��
 * ����һ������nums�����i < j��nums[i] > 2*nums[j]���Ǿͽ�(i, j)����һ����Ҫ��ת�ԡ�
 *
 * ����Ҫ���ظ��������е���Ҫ��ת�Ե�������
 *
 * ʾ�� 1:
 *
 * ����: [1,3,2,3,1]
 * ���: 2
 * ʾ�� 2:
 *
 * ����: [2,4,3,5,1]
 * ���: 3
 * ע��:
 *
 * ��������ĳ��Ȳ��ᳬ��50000��
 * ���������е��������ֶ���32λ�����ı�ʾ��Χ�ڡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/28 10:59 ����
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        res += mergeSort(nums, lo, mid);
        res += mergeSort(nums, mid + 1, hi);
        res += merge(nums, lo, mid, hi);
        return res;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        // �Ƚ��м���
        int count = 0;
        int p = lo, q = mid + 1;
        while (p <= mid && q <= hi) {
            if ((long) nums[p] > (long) 2 * nums[q]) {
                // ����1��3��4 ����3�����1��������ô�������Ҳһ����1������������Ҫ������ȥ
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }

        // �ٽ���������merge����
        int[] a = new int[hi - lo + 1];
        p = lo;
        q = mid + 1;
        int index = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                a[index++] = nums[q++];
            } else {
                a[index++] = nums[p++];
            }
        }
        while (p <= mid) {
            a[index++] = nums[p++];
        }
        while (q <= hi) {
            a[index++] = nums[q++];
        }
        System.arraycopy(a, 0, nums, lo, hi - lo + 1);
        return count;
    }
}
