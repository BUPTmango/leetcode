package simple_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1365. �ж���С�ڵ�ǰ���ֵ�����
 * ����һ������nums����������ÿ��Ԫ��nums[i]������ͳ�������б���С���������ֵ���Ŀ��
 *
 * ������֮������ÿ��nums[i]�����������Ч��j������������ j ����j != i �� nums[j] < nums[i]��
 *
 * ��������ʽ���ش𰸡�
 *
 * ʾ�� 1��
 *
 * ���룺nums = [8,1,2,2,3]
 * �����[4,0,1,1,3]
 * ���ͣ� 
 * ���� nums[0]=8 �����ĸ�����С�����֣���1��2��2 �� 3���� 
 * ���� nums[1]=1 �����ڱ���С�����֡�
 * ���� nums[2]=2 ����һ������С�����֣���1���� 
 * ���� nums[3]=2 ����һ������С�����֣���1���� 
 * ���� nums[4]=3 ������������С�����֣���1��2 �� 2����
 * ʾ�� 2��
 *
 * ���룺nums = [6,5,4,8]
 * �����[2,1,0,3]
 * ʾ�� 3��
 *
 * ���룺nums = [7,7,7,7]
 * �����[0,0,0,0]
 * 
 *
 * ��ʾ��
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 1:41 ����
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * ��������
     * ע�⵽����Ԫ�ص�ֵ��Ϊ [0,100]�����Կ��Կ��ǽ���һ��Ƶ������ cnt ��cnt[i] ��ʾ���� i ���ֵĴ�����
     * ��ô�������� i ���ԣ�С��������Ŀ��Ϊ cnt[0...i-1] ���ܺ͡�
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent_better(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }
}
