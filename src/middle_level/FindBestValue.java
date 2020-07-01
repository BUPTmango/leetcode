package middle_level;

import java.util.Arrays;

/**
 * 1300. ת���������ӽ�Ŀ��ֵ�������
 * ����һ����������?arr ��һ��Ŀ��ֵ?target �����㷵��һ������?value?��ʹ�ý����������д���?value ��ֵ���?value ������ĺ���ӽ�? target?����ӽ���ʾ����֮��ľ���ֵ��С����
 *
 * ����ж���ʹ�ú���ӽ�?target?�ķ��������㷵����Щ�����е���Сֵ��
 *
 * ��ע�⣬�𰸲�һ����?arr �е����֡�
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺arr = [4,9,3], target = 10
 * �����3
 * ���ͣ���ѡ�� value Ϊ 3 ʱ��������� [3, 3, 3]����Ϊ 9 ��������ӽ� target �ķ�����
 * ʾ�� 2��
 *
 * ���룺arr = [2,3,5], target = 10
 * �����5
 * ʾ�� 3��
 *
 * ���룺arr = [60864,25176,27249,21296,20204], target = 56803
 * �����11361
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/1 5:52 ����
 */
public class FindBestValue {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }
}
