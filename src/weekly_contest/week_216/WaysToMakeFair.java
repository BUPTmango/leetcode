package weekly_contest.week_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 5607. ����ƽ������ķ�����
 * ����һ���������� nums ������Ҫѡ�� ǡ�� һ���±꣨�±�� 0 ��ʼ����ɾ����Ӧ��Ԫ�ء���ע��ʣ��Ԫ�ص��±���ܻ���Ϊɾ�������������ı䡣
 *
 * �ȷ�˵����� nums = [6,1,7,4,1] ����ô��
 *
 * ѡ��ɾ���±� 1 ��ʣ�µ�����Ϊ nums = [6,7,4,1] ��
 * ѡ��ɾ���±� 2 ��ʣ�µ�����Ϊ nums = [6,1,4,1] ��
 * ѡ��ɾ���±� 4 ��ʣ�µ�����Ϊ nums = [6,1,7,4] ��
 * ���һ���������������±�Ԫ�صĺ���ż���±�Ԫ�صĺ���ȣ����������һ�� ƽ������ ��
 *
 * ���㷵��ɾ��������ʣ�µ����� nums �� ƽ������ �� ������ ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [2,1,6,4]
 * �����1
 * ���ͣ�
 * ɾ���±� 0 ��[1,6,4] -> ż��Ԫ���±�Ϊ��1 + 4 = 5 ������Ԫ���±�Ϊ��6 ����ƽ�⡣
 * ɾ���±� 1 ��[2,6,4] -> ż��Ԫ���±�Ϊ��2 + 4 = 6 ������Ԫ���±�Ϊ��6 ��ƽ�⡣
 * ɾ���±� 2 ��[2,1,4] -> ż��Ԫ���±�Ϊ��2 + 4 = 6 ������Ԫ���±�Ϊ��1 ����ƽ�⡣
 * ɾ���±� 3 ��[2,1,6] -> ż��Ԫ���±�Ϊ��2 + 6 = 8 ������Ԫ���±�Ϊ��1 ����ƽ�⡣
 * ֻ��һ����ʣ�������Ϊƽ������ķ�����
 * ʾ�� 2��
 *
 * ���룺nums = [1,1,1]
 * �����3
 * ���ͣ������ɾ������Ԫ�أ�ʣ�����鶼��ƽ�����顣
 * ʾ�� 3��
 *
 * ���룺nums = [1,2,3]
 * �����0
 * ���ͣ�����ɾ���ĸ�Ԫ�أ�ʣ�����鶼����ƽ�����顣
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/22 11:02 ����
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int length = nums.length;
        // ǰ׺�� ������ǰ ż���ں�
        int[][] front = new int[length][2];
        for (int i = 1; i < length; i++) {
            int preOdd = front[i - 1][0];
            int preEven = front[i - 1][1];
            if (i % 2 == 0) {
                preOdd += nums[i - 1];
            } else {
                preEven += nums[i - 1];
            }
            front[i][0] = preOdd;
            front[i][1] = preEven;
        }

        // ��׺��
        int[][] back = new int[length][2];
        for (int i = length - 2; i >= 0; i--) {
            int preOdd = back[i + 1][0];
            int preEven = back[i + 1][1];
            if (i % 2 == 0) {
                preOdd += nums[i + 1];
            } else {
                preEven += nums[i + 1];
            }
            back[i][0] = preOdd;
            back[i][1] = preEven;
        }

        int res = 0;
        // ��׺��ת���
        for (int i = 0; i < length; i++) {
            int odd = front[i][0] + back[i][1];
            int even = front[i][1] + back[i][0];
            if (odd == even) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeFair fair = new WaysToMakeFair();
        System.out.println(fair.waysToMakeFair(new int[]{1,1,1}));
    }
}
