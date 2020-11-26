package hard_level;

import java.util.Arrays;

/**
 * 164. �����
 * ����һ����������飬�ҳ�����������֮������Ԫ��֮�����Ĳ�ֵ��
 *
 * �������Ԫ�ظ���С�� 2���򷵻� 0��
 *
 * ʾ��1:
 *
 * ����: [3,6,9,1]
 * ���: 3
 * ����: ������������ [1,3,6,9], ��������Ԫ�� (3,6) �� (6,9) ֮�䶼��������ֵ 3��
 * ʾ��2:
 *
 * ����: [10]
 * ���: 0
 * ����: ����Ԫ�ظ���С�� 2����˷��� 0��
 * ˵��:
 *
 * ����Լ�������������Ԫ�ض��ǷǸ�����������ֵ�� 32 λ�з���������Χ�ڡ�
 * �볢��������ʱ�临�ӶȺͿռ临�Ӷȵ������½�������⡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/26 11:04 ����
 */
public class MaximumGap {
    /**
     * һ����򵥵�˼·�ǽ�������������ҳ�����࣬����ͳ�Ļ��ڱȽϵ������㷨���������򡢹鲢����ȣ�����Ҫ O(NlogN) ��ʱ�临�Ӷȡ�
     * ���Ǳ���ʹ�������������㷨�����磬������������� O(N) ��ʱ�����������֮�������
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            // 0-9ʮ��Ͱ
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                // ����ȡ����λʮλ�ȵȽ�������
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            // �����ۼ�ÿ��Ͱ���ֵĸ���
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
