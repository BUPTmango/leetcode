package hard_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. ���������
 * ����һ��δ������������飬�ҳ���������еĳ��ȡ�
 *
 * Ҫ���㷨��ʱ�临�Ӷ�Ϊ?O(n)��
 *
 * ʾ��:
 *
 * ����:?[100, 4, 200, 1, 3, 2]
 * ���: 4
 * ����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/13 10:20 ����
 */
public class LongestConsecutive {
    /**
     * ��һ������������װ��HashSet�У�
     * �ڶ������������һ��Ԫ�ؿ�ʼ��HashSet,����Ҫ����ǰ��ģ���Ҫ��������ģ����磺3��2��1��4��6����3����ǰ��Ļ�鵽2��1�������Ļ�鵽4��
     * һ��һ��Ԫ�ر��鵽��ֱ�ӽ��������Set���Ƴ�������һ����3��2��1��4ֱ��ȫ���߳�Set��
     * �ٿ�ʼ��2��2�Ѿ����߳�ȥ�ˣ�HashSet�в�����2��������ֱ��������1��4������ˣ�����6��
     * ��������ֻ��Ҫ��¼�м���ļ��ɡ�
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }
        int cnt = 0;
        int result = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int j = 0; j < nums.length; j++){
            if(!hash.contains(nums[j])) {
                continue;
            }
            // ��¼����
            cnt = 0;
            // ��¼��ǰԪ��
            tmp1 = nums[j];
            // ��¼��һ��Ԫ��
            tmp2 = nums[j]+1;
            // ��Ϊ��ɾ�� ����Ҫ���ǲ��Ǵ���
            while(hash.contains(tmp1)) {
                // ���ȼ�һ ��ɾ��
                cnt++;
                hash.remove(tmp1);
                // ɾ����������� ��ǰ�鿴
                tmp1--;
            }
            // ��Ϊ��ɾ�� ����Ҫ���ǲ��Ǵ���
            while(hash.contains(tmp2)) {
                // ���ȼ�һ ��ɾ��
                cnt++;
                hash.remove(tmp2);
                // ɾ����������� ���鿴
                tmp2++;
            }
            result = cnt > result ? cnt : result;
        }
        return result;
    }
}
