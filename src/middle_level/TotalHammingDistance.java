package middle_level;

import hard_level.Solution;

/**
 * 477. ���������ܺ�
 * ���������ĺ������� ָ�������������ֵĶ���������Ӧλ��ͬ��������
 * <p>
 * ����һ�������У�����������֮�人��������ܺ͡�
 * <p>
 * ʾ��:
 * <p>
 * ����: 4, 14, 2
 * <p>
 * ���: 6
 * <p>
 * ����: �ڶ����Ʊ�ʾ�У�4��ʾΪ0100��14��ʾΪ1110��2��ʾΪ0010����������ʾ��Ϊ�����ֺ���λ֮���ϵ��
 * ���Դ�Ϊ��
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * ע��:
 * <p>
 * ������Ԫ�صķ�ΧΪ��0��10^9��
 * ����ĳ��Ȳ�����10^4��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/28 08:55
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                // ͳ��1�ĸ���
                c += (val >> i) & 1;
            }
            // ����� i λ�� c ��1�� n - c ��0����������֮��Ϊc * (n - c)
            ans += c * (n - c);
        }
        return ans;
    }
}
