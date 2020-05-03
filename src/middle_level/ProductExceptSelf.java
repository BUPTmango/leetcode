package middle_level;

/**
 * 238. ��������������ĳ˻�
 * ����һ������Ϊ?n?����������?nums������?n > 1�������������?output?������ output[i]?����?nums?�г�?nums[i]?֮�������Ԫ�صĳ˻���
 *
 * ʾ��:
 *
 * ����: [1,2,3,4]
 * ���: [24,12,8,6]
 *
 * ��ʾ����Ŀ���ݱ�֤����֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺���������������飩�ĳ˻����� 32 λ������Χ�ڡ�
 *
 * ˵��: �벻Ҫʹ�ó���������?O(n) ʱ�临�Ӷ�����ɴ��⡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/3 11:47 ����
 */
public class ProductExceptSelf {
    /**
     * ��Ϊ���Ҳ��� �����������
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            // �������ʼ��Ϊ1
            res[i] = k;
            k = k * nums[i]; // ��ʱ����洢���ǳ�ȥ��ǰԪ����ߵ�Ԫ�س˻�
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // kΪ�����ұߵĳ˻���
            k *= nums[i]; // ��ʱ���������ߵ� * �����ұߵġ�
        }
        return res;
    }
}
