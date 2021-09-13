package middle_level;

import java.util.Random;

/**
 * 384. ��������
 *
 * ����һ���������� nums ������㷨������һ��û���ظ�Ԫ�ص����顣
 *
 * ʵ�� Solution class:
 *
 * Solution(int[] nums) ʹ���������� nums ��ʼ������
 * int[] reset() �������鵽���ĳ�ʼ״̬������
 * int[] shuffle() ��������������Һ�Ľ��
 * ?
 *
 * ʾ����
 *
 * ����
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * ���
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * ����
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ�����磬���� [3, 1, 2]
 * solution.reset();      // �������鵽���ĳ�ʼ״̬ [1, 2, 3] ������ [1, 2, 3]
 * solution.shuffle();    // ����������� [1, 2, 3] ���Һ�Ľ�������磬���� [1, 3, 2]
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums �е�����Ԫ�ض��� Ψһ��
 * �����Ե��� 5 * 104 �� reset �� shuffle
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/8 20:34
 */
public class ShuffleArray {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
