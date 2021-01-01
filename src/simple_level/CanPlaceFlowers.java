package simple_level;

/**
 * 605. �ֻ�����
 * ��������һ���ܳ��Ļ�̳��һ���ֵؿ���ֲ�˻�����һ����ȴû�С����ǣ����ܲ�����ֲ�����ڵĵؿ��ϣ����ǻ�����ˮԴ�����߶�����ȥ��
 * <p>
 * ����һ����̳����ʾΪһ���������0��1������0��ʾû��ֲ����1��ʾ��ֲ�˻�������һ����n���ܷ��ڲ�������ֲ��������������n�仨�����򷵻�True�������򷵻�False��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: flowerbed = [1,0,0,0,1], n = 1
 * ���: True
 * ʾ�� 2:
 * <p>
 * ����: flowerbed = [1,0,0,0,1], n = 2
 * ���: False
 * ע��:
 * <p>
 * ���������ֺõĻ�����Υ����ֲ����
 * ��������鳤�ȷ�ΧΪ [1, 20000]��
 * n �ǷǸ��������Ҳ��ᳬ����������Ĵ�С��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/1 12:08 ����
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // ÿ��������
        for (int i = 0; i < flowerbed.length; i += 2) {
            // �����ǰΪ�յ�
            if (flowerbed[i] == 0) {
                // ��������һ�������һ��Ϊ��
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
