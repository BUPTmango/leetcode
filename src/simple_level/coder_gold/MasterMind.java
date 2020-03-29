package simple_level.coder_gold;

/**
 * ������ 16.15. ��������
 * ����������Ϸ��the game of master mind�����淨���¡�
 *
 * �������4���ۣ�ÿ���۷�һ������ɫ�����Ǻ�ɫ��R������ɫ��Y������ɫ��G������ɫ��B�������磬�����������RGGB 4�֣���1Ϊ��ɫ����2��3Ϊ��ɫ����4Ϊ��ɫ������Ϊ�û�������ͼ�³���ɫ��ϡ�����ȷ�������ܻ��YRGB��Ҫ�ǲ¶�ĳ���۵���ɫ������һ�Ρ����С���Ҫ��ֻ�¶���ɫ����λ�´��ˣ�����һ�Ρ�α���С���ע�⣬�����С��������롰α���С���
 *
 * ����һ����ɫ���solution��һ���²�guess����дһ�����������ز��к�α���еĴ���answer������answer[0]Ϊ���еĴ�����answer[1]Ϊα���еĴ�����
 *
 * ʾ����
 *
 * ���룺 solution="RGBY",guess="GGRR"
 * ����� [1,1]
 * ���ͣ� ����1�Σ�α����1�Ρ�
 * ��ʾ��
 *
 * len(solution) = len(guess) = 4
 * solution��guess������"R","G","B","Y"��4���ַ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/29 12:35 ����
 */
public class MasterMind {
    /**
     * ��˼·�����Կ�����������Ϸ���Ѿ���ͬ�ġ����С��飬�ڲ���֮���Եڶ��μ��ġ�α���С�����ɸ��ţ������к�����Ϊ��������ֱ�ǡ�
     * α�������ȡͬ����˼·���ı�Ϊ��һ�����֣���ֹ������ѭ�����и��ţ���Ϊ�򵥵�����������⡣
     *
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int len = solution.length();

        char[] ch1 = solution.toCharArray();
        char[] ch2 = guess.toCharArray();

        for( int i=0; i<len; i++ ){
            if( ch1[i] == ch2[i] ){
                ans[0]++;
                ch1[i] = ch2[i] = '0';
            }

        }
        for( int i=0; i<len; i++ ){
            for( int j=0; j<len; j++ ){
                if( ch1[i] == ch2[j] && i!=j && ch1[i] != '0' ){
                    ans[1]++;
                    ch1[i] = '8';
                    ch2[j] = '7';
                }
            }
        }
        return ans;
    }
}
