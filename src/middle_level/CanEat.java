package middle_level;

import hard_level.Solution;

/**
 * 1744. ����������ϲ��������Ե�����ϲ�����ǹ���
 * ����һ���±�� 0 ��ʼ������������candiesCount������candiesCount[i]��ʾ��ӵ�еĵ�i���ǹ�����Ŀ��ͬʱ����һ����ά����queries������queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]��
 *
 * �㰴�����¹������һ����Ϸ��
 *
 * ��ӵ�0�쿪ʼ���ǹ���
 * ���ڳ��� ���е� i - 1���ǹ�֮ǰ�����ܳ��κ�һ�ŵ� i���ǹ���
 * �ڳ��������ǹ�֮ǰ�������ÿ�� ���ٳ� һ���ǹ���
 * ���㹹��һ������������answer������answer.length == queries.length ��answer[i]Ϊtrue�������ǣ���ÿ��� ������ dailyCapi���ǹ���ǰ���£�������ڵ�favoriteDayi��Ե���favoriteTypei���ǹ������� answer[i]Ϊ false��ע�⣬ֻҪ�������� 3 �������еĵڶ���������Ϳ�����ͬһ��Բ�ͬ���͵��ǹ���
 *
 * ���㷵�صõ�������answer��
 *
 * ʾ�� 1��
 *
 * ���룺candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * �����[true,false,true]
 * ��ʾ��
 * 1- �ڵ� 0 ��� 2 ���ǹ�(���� 0������ 1 ��� 2 ���ǹ������� 0������ 2 ������ԳԵ����� 0 ���ǹ���
 * 2- ÿ�������� 4 ���ǹ�����ʹ�� 0 ��� 4 ���ǹ������� 0������ 1 ��� 4 ���ǹ������� 0 ������ 1������Ҳû�취�ڵ� 2 ��Ե����� 4 ���ǹ�������֮����û����ÿ��� 4 ���ǹ����������ڵ� 2 ��Ե��� 4 ���ǹ���
 * 3- �����ÿ��� 1 ���ǹ���������ڵ� 13 ��Ե����� 2 ���ǹ���
 * ʾ�� 2��
 *
 * ���룺candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * �����[false,true,true,false,false]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/1 09:10
 */
public class CanEat {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // ǰ׺��
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            // ��Ϊ�Ǵӵ�0�쿪ʼ�� ����Ҫ+1
            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            // ע�������һ���ǹ�Ҫ����Ϊ1����Ϊ�϶��ܳԵ�
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }
}
