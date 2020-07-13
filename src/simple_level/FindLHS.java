package simple_level;

import java.util.HashMap;

/**
 * 594. ���г������
 * ��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ��������1��
 *
 * ���ڣ�����һ���������飬����Ҫ�����п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����: [1,3,2,2,5,2,3,7]
 * ���: 5
 * ԭ��: ��ĺ�г�����ǣ�[3,2,2,2,3].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/13 12:25 ����
 */
public class FindLHS {
    /**
     * ��ϣӳ�� + ����ɨ��
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            // ��ϣӳ�� �����
            map.put(num, map.getOrDefault(num, 0) + 1);
            //����ɨ��һ�����飬��ɨ�赽Ԫ�� x ʱ���������Ƚ� x �����ϣӳ�䣬����ȡ��ϣӳ���� x - 1, x, x + 1 ���߳��ֵĴ��� u, v, w��
            // ��ô u + v ��Ϊ x - 1, x ��ɵĺ�г�����еĳ��ȣ�v + w ��Ϊ x, x + 1 ��ɵĺ�г�����еĳ��ȡ�
            // ������������ĺ�г�����е����һ��Ԫ���������е�λ��Ϊ i����ô��ɨ�赽 nums[i] ʱ��u + v �� v + w ��һ����һ�����Ǵ𰸡�
            // ������ַ��������ҵ���ĺ�г�����еĳ��ȡ�
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num - 1));
            }
        }
        return res;
    }
}
