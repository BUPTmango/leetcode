package simple_level;

/**
 * 581
 * �����������������
 * ����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
 *
 * ���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����: [2, 6, 4, 8, 10, 9, 15]
 * ���: 5
 * ����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
 * ˵�� :
 *
 * ��������鳤�ȷ�Χ��?[1, 10,000]��
 * �����������ܰ����ظ�Ԫ��?�������������˼��<=��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/17 8:10 ����
 */
public class FindUnsortedSubarray {
    /**
     * ͬʱ��ǰ����ʹӺ���ǰ�������ֱ�õ�����������ұ߽����߽磻
     *
     * Ѱ���ұ߽磺��ǰ��������Ĺ����У���max��¼�����������ֵ��
     * ���max���ڵ�ǰ��nums[i]��˵��nums[i]��λ�ò���ȷ��Ӧ��������Ҫ��������飬
     * ��˽��ұ߽����Ϊi��Ȼ�����max���������տ����ҵ���Ҫ�����������ұ߽磬�ұ߽�֮���Ԫ�ض�����max��
     *
     * Ѱ����߽磺�Ӻ���ǰ�����Ĺ����У���min��¼����������Сֵ��
     * ���minС�ڵ�ǰ��nums[j]��˵��nums[j]��λ�ò���ȷ��Ӧ��������Ҫ��������飬
     * ��˽���߽����Ϊj��Ȼ�����min���������տ����ҵ���Ҫ������������߽磬��߽�֮ǰ��Ԫ�ض�С��min��
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        // [2, 6, 4, 8, 10, 9, 15]
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray f = new FindUnsortedSubarray();
//        int result = f.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15});
        int result = f.findUnsortedSubarray(new int[] {2,1});
        System.out.println(result);
    }
}
