package simple_level.coder_gold;

/**
 * ������ 08.03. ħ������
 * ħ�������� ������A[0...n-1]�У�����ν��ħ����������������A[i] = i������һ�������������飬��дһ�ַ����ҳ�ħ�����������еĻ���������A���ҳ�һ��ħ�����������û�У��򷵻�-1�����ж��ħ����������������ֵ��С��һ����
 *
 * ʾ��1:
 *
 *  ���룺nums = [0, 2, 3, 4, 5]
 *  �����0
 *  ˵��: 0�±��Ԫ��Ϊ0
 * ʾ��2:
 *
 *  ���룺nums = [1, 1, 1]
 *  �����1
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/21 8:55 ����
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
