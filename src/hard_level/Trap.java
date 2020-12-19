package hard_level;

/**
 * ˮ���������
 * 42. ����ˮ
 * ����n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * <p>
 * ʾ�� 1��
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����
 * ʾ�� 2��
 * <p>
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 10:03 ����
 */
public class Trap {
    /**
     * ˫ָ�� ���߱���
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;

        int l_max = height[0];
        int r_max = height[n - 1];

        while (left <= right) {
            // �����������ӵ����߶�
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            // ȡ���ҽ�С�ļ�����ˮ
            if (l_max < r_max) {
                ans += l_max - height[left++];
            } else {
                ans += r_max - height[right--];
            }
        }

        return ans;
    }
}
