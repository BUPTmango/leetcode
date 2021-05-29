package middle_level;

import java.util.HashMap;

/**
 * 560. ��ΪK��������
 * ����һ�����������һ������?k������Ҫ�ҵ��������к�Ϊ?k?��������������ĸ�����
 * <p>
 * ʾ�� 1 :
 * <p>
 * ����:nums = [1,1,1], k = 2
 * ���: 2 , [1,1] �� [1,1] Ϊ���ֲ�ͬ�������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/17 8:54 ����
 */
public class SubarraySum {
    /**
     * ǰ׺�ͼӹ�ϣ���Ż�
     * [j..i] ����������Ϊ k ����������ǿ���ת��Ϊ : pre[i]?pre[j?1]==k
     * ���ǿ����� i ��β�ĺ�Ϊ k ���������������ʱֻҪͳ���ж��ٸ�ǰ׺��Ϊ pre[i]?k �� pre[j] ���ɡ�
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // hash
        // ��¼���ʵ������ַ�������
        int count = 0;
        // ��¼ǰ���������֮��
        int pre = 0;
        // map��¼ǰ��������֮��ΪK������ͬ�͵Ĵ���ΪV
        HashMap<Integer, Integer> map = new HashMap<>();
        // ��ʼ��
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // ���ǰ������֮�ͼ�������������õ���K������һ�����ּ���nums[i]���ΪK
            // ˵���ҵ���
            if (map.containsKey(pre - k)) {
                // �ۼ�
                count += map.get(pre - k);
            }
            // �����µĺͷ���map
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
