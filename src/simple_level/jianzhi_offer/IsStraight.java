package simple_level.jianzhi_offer;

import java.util.Arrays;

/**
 * ������61. �˿����е�˳��
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2��10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 �����Կ����������֡�A ������Ϊ 14��
 *
 * ʾ��?1:
 *
 * ����: [1,2,3,4,5]
 * ���: True
 *
 * ʾ��?2:
 *
 * ����: [0,0,1,2,5]
 * ���: True
 *
 * ���ƣ�
 *
 * ���鳤��Ϊ 5?
 *
 * �������ȡֵΪ [0, 13] .
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/14 2:31 ����
 */
public class IsStraight {
    /**
     * ����һ ��ʹ������
     *
     * ��������ܹ�֪�� 5 ���˿����е����ֵ maxValue ����Сֵ minValue ��
     * �����Ǿ�֪����Ҫʹ��Ϊ˳����Ҫ maxValue - minValue + 1 ���ơ�
     * �ڲ��� maxValue �� minValue �����У�������С�� 0 ��
     * ��� maxValue - minValue + 1 > 5��
     * ˵����Ŀ���� 5 ���Ʋ����Թ���˳�ӣ����� false .
     * ��ʹ�����д�С����Ҳ���������ʹ������˳�ӡ�
     * ��� maxValue - minValue + 1 <= 5��˵�� 5 �������Թ���˳�ӣ����� true��
     * ����Ĵ�С����ں���λ�ü��ɡ�
     * ͬʱ�������ٶ���һ����־�����ж��Ƿ����ظ����֣������ظ�����ֱ�ӷ��� false ���ɡ�
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        boolean[] flag = new boolean[15];
        int minValue = 14, maxValue = 0;
        for (int item : nums) {
            if (item == 0) {
                continue;
            }
            // �г���0�������ͬԪ�� �϶��������˳��
            if (flag[item]) {
                return false;
            }
            flag[item] = true;
            minValue = Math.min(minValue, item);
            maxValue = Math.max(maxValue, item);
        }
        return maxValue - minValue + 1 <= 5;
    }

    /**
     * ������ ʹ������
     *
     * ����֮���˿��ƾ������ˣ����ǾͿ���ֱ���ж�����������֮����Ҫ���ٸ�������С�������
     * �����Ҫ���С�����������������д�С�����������򷵻� falsefalse .
     * �෴�������Ҫ���С����������С�ڻ�������д�С�����������򷵻� truetrue .
     *
     * @param nums
     * @return
     */
    public boolean isStraight_sort(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i ++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i+1]) {
                return false;
            }
            zero -= nums[i+1]-nums[i] - 1;
        }
        return zero >= 0;
    }

    public static void main(String[] args) {
        IsStraight is = new IsStraight();
        System.out.println(is.isStraight(new int[]{0, 0, 1, 2, 6}));
    }
}
