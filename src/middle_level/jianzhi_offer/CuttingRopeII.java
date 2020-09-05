package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 14- II. ������ II
 * ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m?�Σ�m��n����������n>1����m>1����ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m - 1] ������ k[0]*k[1]*...*k[m - 1] ���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
 *
 * ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ����: 2
 * ���: 1
 * ����: 2 = 1 + 1, 1 �� 1 = 1
 * ʾ��?2:
 *
 * ����: 10
 * ���: 36
 * ����: 10 = 3 + 3 + 4, 3 ��?3 ��?4 = 36
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/4 5:21 ����
 */
public class CuttingRopeII {
    public int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        // �����ܶ����3��Ƭ�Σ����ǿ�����n>4����Ϊѭ��������
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }
}