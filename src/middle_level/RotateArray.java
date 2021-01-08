package middle_level;

/**
 * 189. ��ת����
 * ����һ�����飬�������е�Ԫ�������ƶ�k��λ�ã�����k�ǷǸ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3,4,5,6,7] �� k = 3
 * ���: [5,6,7,1,2,3,4]
 * ����:
 * ������ת 1 ��: [7,1,2,3,4,5,6]
 * ������ת 2 ��: [6,7,1,2,3,4,5]
 * ������ת 3 ��: [5,6,7,1,2,3,4]
 * ʾ��2:
 * <p>
 * ����: [-1,-100,3,99] �� k = 2
 * ���: [3,99,-1,-100]
 * ����:
 * ������ת 1 ��: [99,-1,-100,3]
 * ������ת 2 ��: [3,99,-1,-100]
 * ˵��:
 * <p>
 * �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
 * Ҫ��ʹ�ÿռ临�Ӷ�ΪO(1) ��ԭ���㷨��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/8 10:44 ����
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0)
            return;

        // ע�⣡����  ����k�п��ܴܺ� ����Ҫȡ����
        int turns = k % nums.length;
        int middle = nums.length - turns;

        // reverse left part
        reverse(nums, 0, middle - 1);
        // reverse right part
        reverse(nums, middle, nums.length - 1);
        // reverse whole part
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
