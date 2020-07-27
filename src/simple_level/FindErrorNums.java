package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 645. ����ļ���
 * ���� S ������1��?n?�����������ҵ��ǣ���Ϊ���ݴ��󣬵��¼�������ĳһ��Ԫ�ظ����˳��˼������������һ��Ԫ�ص�ֵ�����¼��϶�ʧ��һ������������һ��Ԫ���ظ���
 *
 * ����һ������ nums �����˼��� S ���������Ľ�����������������Ѱ�ҵ��ظ����ֵ����������ҵ���ʧ�����������������������ʽ���ء�
 *
 * ʾ�� 1:
 *
 * ����: nums = [1,2,2,4]
 * ���: [2,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/27 2:17 ����
 */
public class FindErrorNums {
    /**
     * ��� 1 �� n ��ÿ�������� map �г��ִ��������һ�������� map ��û�г��֣�������ȱʧ���֡����һ�����ֵĳ��������Σ��������ظ����֡�
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Map< Integer, Integer > map = new HashMap();
        int dup = -1, missing = 1;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }
}
