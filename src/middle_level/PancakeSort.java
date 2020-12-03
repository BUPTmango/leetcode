package middle_level;

import java.util.LinkedList;
import java.util.List;

/**
 * 969. �������
 * ��������A�����ǿ��Զ�����м����ת������ѡ��һЩ������k<= A.length��Ȼ��ת A ��ǰ k��Ԫ�ص�˳������Ҫִ����λ��μ����ת����˳��һ�ν�һ�εؽ��У�����ɶ����� A ������
 *
 * ������ʹA ����ļ����ת��������Ӧ�� k ֵ���С��κν����������ҷ�ת������10 * A.length ��Χ�ڵ���Ч�𰸶������ж�Ϊ��ȷ��
 *
 * ʾ�� 1��
 *
 * ���룺[3,2,4,1]
 * �����[4,2,4,3]
 * ���ͣ�
 * ����ִ�� 4 �μ����ת��k ֵ�ֱ�Ϊ 4��2��4���� 3��
 * ��ʼ״̬ A = [3, 2, 4, 1]
 * ��һ�η�ת�� (k=4): A = [1, 4, 2, 3]
 * �ڶ��η�ת�� (k=2): A = [4, 1, 2, 3]
 * �����η�ת�� (k=4): A = [3, 2, 1, 4]
 * ���Ĵη�ת�� (k=3): A = [1, 2, 3, 4]����ʱ���������
 * ʾ�� 2��
 *
 * ���룺[1,2,3]
 * �����[]
 * ���ͣ�
 * �����Ѿ�������˲���Ҫ��ת�κ����ݡ�
 * ��ע�⣬�������ܵĴ𰸣���[3��3]��Ҳ�������ܡ�
 * 
 * ��ʾ��
 *
 * 1 <= A.length <= 100
 * A[i] ��[1, 2, ..., A.length]������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/3 6:50 ����
 */
public class PancakeSort {
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    private void sort(int[] cakes, int n) {
        // base case
        if (n == 1) {
            return;
        }

        // Ѱ������ձ�������
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        // ��һ�η�ת ��������ת��������
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // �ڶ��η�ת ����������������
        reverse(cakes, 0, n - 1);
        res.add(n);

        // �ݹ����
        sort(cakes, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
