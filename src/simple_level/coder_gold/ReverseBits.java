package simple_level.coder_gold;

/**
 * ������ 05.03. ��ת��λ
 * ����һ��32λ���� num������Խ�һ����λ��0��Ϊ1�����дһ�������ҳ����ܹ���õ����һ��1�ĳ��ȡ�
 *
 * ʾ�� 1��
 *
 * ����: num = 1775(110111011112)
 * ���: 8
 * ʾ�� 2��
 *
 * ����: num = 7(01112)
 * ���: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/1 9:32 ����
 */
public class ReverseBits {
    /**
     * ������
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int curNum = 0, preNum = 0, maxNum = 0;
        for(int i = 0; i < 32; ++i){
            if((num & 1) == 1){
                curNum++;
            }else{
                curNum -= preNum;
                curNum++;
                preNum = curNum;
            }
            maxNum = Math.max(maxNum, curNum);
            num >>= 1;
        }
        return maxNum;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(111));
    }
}
