package middle_level;

/**
 * ���ö����������
 * 875. �����㽶������
 * ����ϲ�����㽶��������N���㽶���� i ������piles[i]���㽶�������Ѿ��뿪�ˣ�����HСʱ�������
 * <p>
 * ������Ծ��������㽶���ٶ�K����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ���㽶�����гԵ� K �����������㽶���� K ���������Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��
 * <p>
 * ����ϲ�������ԣ�����Ȼ���ھ�������ǰ�Ե����е��㽶��
 * <p>
 * ������������ H Сʱ�ڳԵ������㽶����С�ٶ� K��K Ϊ��������
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: piles = [3,6,7,11], H = 8
 * ���: 4
 * ʾ��2��
 * <p>
 * ����: piles = [30,11,23,4,20], H = 5
 * ���: 30
 * ʾ��3��
 * <p>
 * ����: piles = [30,11,23,4,20], H = 6
 * ���: 23
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/4 10:24 ����
 */
public class MinEatingSpeed {
    /**
     * ����ʹ�ö��������������з�Χ�Ľ��������ͨ�����ַ��������
     *
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        // speed��СΪ1 ���Ϊmax(piles)
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, speed);
        }
        return time <= H;
    }

    private int timeOf(int pile, int speed) {
        return pile / speed + ((pile % speed > 0) ? 1 : 0);
    }
}
