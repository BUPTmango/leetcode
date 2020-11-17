package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * ����ת�㷨������Ƶ���⡷
 * 215. �����еĵ�K�����Ԫ��
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 *
 * ʾ�� 1:
 *
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * ʾ��?2:
 *
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/25 12:00 ����
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // Comparator.comparingInt(n -> n)�ȼ���(n1, n2) -> n1 - n2
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        // ���������
        for (int n : nums) {
            heap.add(n);
            // ά����СΪk�Ķ�
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * ����ѡ���㷨
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_quick_select(int[] nums, int k) {
        // ���������������
        shuffle(nums);
        int lo = 0, hi = nums.length - 1;
        // ����ת�� ת��������ĵ�k����
        k = nums.length - k;
        while (lo <= hi) {
            // �� nums[lo..hi] ��ѡһ���ֽ��
            int p = partition(nums, lo, hi);
            if (p < k) {
                // �� k ���Ԫ���� nums[p+1..hi] ��
                lo = p + 1;
            } else if (p > k) {
                // �� k ���Ԫ���� nums[lo..p-1] ��
                hi = p - 1;
            } else {
                // �ҵ��� k ��Ԫ��
                return nums[p];
            }
        }
        return -1;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // �� i ��������ѡһ��Ԫ��
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        // Ĭ�Ͻ�nums[lo]��ΪĬ�Ϸֽ�� pivot
        int pivot = nums[lo];
        // j = hi + 1 ��Ϊwhile����ִ�� --
        int i = lo, j = hi + 1;
        while (true) {
            // ��֤ nums[lo...i] ��С�� pivot
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            // ��֤ nums[j...hi] ������ pivot
            while (nums[--j] > pivot) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            // ��֤ nums[lo...i] < pivot < nums[j...hi]
            swap(nums, i, j);
        }
        // ��pivot��������ȷ��λ��
        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
