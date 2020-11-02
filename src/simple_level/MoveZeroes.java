package simple_level;

/**
 * ˫ָ�� ԭ���޸�
 * ����ת�㷨������Ƶ���⡷
 * 283
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 *
 * ʾ��:
 *
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ˵��:
 *
 * ������ԭ�����ϲ��������ܿ�����������顣
 * �������ٲ���������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 10:08 ����
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }
        int currentIndex = 0;
        while (currentIndex + 1 < nums.length) {
            if (nums[currentIndex] == 0) {
                int i = currentIndex + 1;
                while (nums[i] == 0) {
                    i++;
                    if (i >= nums.length) {
                        return;
                    }
                }
                nums = switchElement(nums, i, currentIndex);
            }
            currentIndex++;
        }
    }

    private int[] switchElement(int[] nums, int oneIndex, int anotherIndex) {
        int middle = nums[anotherIndex];
        nums[anotherIndex] = nums[oneIndex];
        nums[oneIndex] = middle;
        return nums;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[] {0,1,0,3,12});
    }

    /**
     * ����ָ�� һ������ָ����һ���Ǵ洢����λ�õ�ָ��
     * @param nums
     */
    public void moveZeroes_better(int[] nums) {
        int temp;
        // idxָ����һ��Ҫ������0��λ��
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
    }
}
