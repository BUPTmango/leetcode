package middle_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָ Offer 56 - II. ���������ֳ��ֵĴ��� II
 * ��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,4,3,3]
 * �����4
 * ʾ�� 2��
 * <p>
 * ���룺nums = [9,1,7,9,7,9,7]
 * �����1
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/2 5:55 ����
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {//���㷨ͬ������������nums�д��ڸ��������
        if (nums.length == 0) {
            return -1;//�������鳤�Ȳ�����Ҫ�󣬷���-1;
        }
        int[] bitSum = new int[32];//java int������32λ��������λΪ����λ
        int res = 0;
        for (int num : nums) {
            int bitMask = 1;//��Ҫ�������ʼ�������ܺ�resһ���ʼ��
            for (int i = 31; i >= 0; i--) {//bitSum[0]Ϊ����λ
                //����ͬ������ͨ��num���޷�������>>>��ʵ�֣��������������(>>)���Ჹ����λ�����ڸ��������
                //���ǲ��Ƽ�����������ò�Ҫ�޸�ԭ����nums������
                if ((num & bitMask) != 0) {
                    bitSum[i]++;//�����ж�����Ҳ����дΪ(num&bitMask)==bitMask,������==1
                }
                bitMask = bitMask << 1;//����û���޷��š������ŵ����𣬶������Ҳಹ0
            }
        }
        for (int i = 0; i < 32; i++) {//��������ʹ�ñ��㷨ͬ�������ڸ��������
            res = res << 1;
            res += bitSum[i] % 3;//������˳���ܱ䣬�������һ���������һ��
        }
        return res;
    }
}
