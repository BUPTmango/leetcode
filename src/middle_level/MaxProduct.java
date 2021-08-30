package middle_level;

/**
 * 152. �˻����������
 * ����һ���������� nums?�������ҳ������г˻��������������飨�������������ٰ���һ�����֣���
 *
 * ʾ�� 1:
 *
 * ����: [2,3,-2,4]
 * ���: 6
 * ����:?������ [2,3] �����˻� 6��
 * ʾ�� 2:
 *
 * ����: [-2,0,-1]
 * ���: 0
 * ����:?�������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/7 12:01 ����
 */
public class MaxProduct {
    /**
     * �� nums[i] >= 0 ����dpMax[i-1] > 0��dpMax[i] = dpMax[i-1] * nums[i]
     * �� nums[i] >= 0 ����dpMax[i-1] < 0����ʱ�����ǰ�ߵ����۳˵Ļ������ɸ���������dpMax[i] = nums[i]
     * �� nums[i] < 0����ʱ���ǰ���۳˽����һ���ܴ�ĸ������͵�ǰ�����۳˵Ļ��ͻ���һ������������������ǻ���Ҫһ������ dpMin ����¼�Ե� i ��Ԫ�صĽ�β�������飬�˻���С��ֵ��
     *   ��dpMin[i-1] < 0��dpMax[i] = dpMin[i-1] * nums[i]
     *   ��dpMin[i-1] >= 0��dpMax[i] = nums[i]
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //���� dpMin ��ʱ����Ҫ dpMax ֮ǰ����Ϣ�������ȱ�������
            int preMax = dpMax;
            // nums[i]<0��һ����� + >0���������������dpMax��������
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            // nums[i]>0��һ����� + <0���������������dpMax��������
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
