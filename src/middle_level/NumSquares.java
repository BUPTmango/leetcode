package middle_level;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷���� ͼ��BFS
 * 279. ��ȫƽ����
 * ����������?n���ҵ����ɸ���ȫƽ����������?1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * <p>
 * ʾ��?1:
 * <p>
 * ����: n = 12
 * ���: 3
 * ����: 12 = 4 + 4 + 4.
 * ʾ�� 2:
 * <p>
 * ����: n = 13
 * ���: 2
 * ����: 13 = 4 + 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/30 1:58 ����
 */
public class NumSquares {

    /**
     * ��ǩ����̬�滮
     * ���ȳ�ʼ������Ϊn+1������dp��ÿ��λ�ö�Ϊ0
     * ���nΪ0������Ϊ0
     * ��������б������±�Ϊi��ÿ�ζ�����ǰ�����ȸ���Ϊ���Ľ������dp[i]=i������i=4������Ϊ4=1+1+1+1��Ϊ4������
     * ��̬ת�Ʒ���Ϊ��dp[i] = MIN(dp[i], dp[i - j * j] + 1)��i��ʾ��ǰ���֣�j*j��ʾƽ����
     * ʱ�临�Ӷȣ�O(n*sqrt(n))��sqrtΪƽ����
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // Ĭ�ϳ�ʼ��ֵ��Ϊ0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // ����������ÿ��+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // ��̬ת�Ʒ���
            }
        }
        return dp[n];
    }

    /**
     * ����������� BFS
     * ��������ת��Ϊͼ������
     * ��n��0 ÿ�����ֱ�ʾһ���ڵ�
     * �����������x��y���һ����ȫƽ���� ����һ����
     * �������ǵõ���һ����Ȩͼ
     * ԭ����ת���� �������Ȩͼ�д�n��0�����·��
     *
     * ע�⴦���������⣡����
     *
     * @param n
     * @return
     */
    public int numSquares_BFS(int n) {

        Queue<Integer> queue = new LinkedList<>();
        // �����������
        boolean[] visited = new boolean[n + 1];
        int step = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.remove();
                // num - j * j ������������ ��������ֻ��һ�����ڵ� ͼ�ж��ַ�ʽ����һ���ڵ�
                for (int j = 1; num - j * j >= 0; j++) {
                    int remain = num - j * j;
                    if (remain == 0) {
                        return step;
                    } else {
                        if (!visited[remain]) {
                            queue.add(remain);
                            visited[remain] = true;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
