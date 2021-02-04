package middle_level;

/**
 * ���ö����������
 * 1011. �� D �����ʹ����������
 * ���ʹ��ϵİ��������� D ���ڴ�һ���ۿ����͵���һ���ۿڡ�
 * <p>
 * ���ʹ��ϵĵ� i������������Ϊweights[i]��ÿһ�죬���Ƕ��ᰴ����������˳�������ʹ���װ�ذ���������װ�ص��������ᳬ�������������������
 * <p>
 * �������� D ���ڽ����ʹ��ϵ����а����ʹ�Ĵ����������������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * �����15
 * ���ͣ�
 * ����������� 15 ���ܹ��� 5 �����ʹ����а�����������ʾ��
 * �� 1 �죺1, 2, 3, 4, 5
 * �� 2 �죺6, 7
 * �� 3 �죺8
 * �� 4 �죺9
 * �� 5 �죺10
 * <p>
 * ��ע�⣬������밴�ո�����˳��װ�ˣ����ʹ����������Ϊ 14 �Ĵ���������װ�ֳ� (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) �ǲ�����ġ�
 * ʾ�� 2��
 * <p>
 * ���룺weights = [3,2,2,4,1,4], D = 3
 * �����6
 * ���ͣ�
 * ����������� 6 ���ܹ��� 3 �����ʹ����а�����������ʾ��
 * �� 1 �죺3, 2
 * �� 2 �죺2, 4
 * �� 3 �죺1, 4
 * ʾ�� 3��
 * <p>
 * ���룺weights = [1,2,3,1,1], D = 4
 * �����3
 * ���ͣ�
 * �� 1 �죺1
 * �� 2 �죺2
 * �� 3 �죺3
 * �� 4 �죺1, 1
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/4 10:44 ����
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // ��СֵΪmin(weights) ���ֵΪsum(weights)
        int min = Integer.MAX_VALUE, max = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            max += weight;
        }
        int left = min, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int load, int D) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxLoad = load;
            while ((maxLoad -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
