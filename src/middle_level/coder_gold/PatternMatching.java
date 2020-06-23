package middle_level.coder_gold;

/**
 * ������ 16.18. ģʽƥ��
 * ���������ַ�������pattern��value�� pattern�ַ�������ĸ"a"��"b"��ɣ����������ַ����е�ģʽ�����磬�ַ���"catcatgocatgo"ƥ��ģʽ"aabab"������"cat"��"a"��"go"��"b"�������ַ���Ҳƥ����"a"��"ab"��"b"������ģʽ������ע��"a"��"b"����ͬʱ��ʾ��ͬ���ַ�������дһ�������ж�value�ַ����Ƿ�ƥ��pattern�ַ�����
 *
 * ʾ�� 1��
 *
 * ���룺 pattern = "abba", value = "dogcatcatdog"
 * ����� true
 * ʾ�� 2��
 *
 * ���룺 pattern = "abba", value = "dogcatcatfish"
 * ����� false
 * ʾ�� 3��
 *
 * ���룺 pattern = "aaaa", value = "dogcatcatdog"
 * ����� false
 * ʾ�� 4��
 *
 * ���룺 pattern = "abba", value = "dogdogdogdog"
 * ����� true
 * ���ͣ� "a"="dogdog",b=""����֮Ҳ���Ϲ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/23 4:10 ����
 */
public class PatternMatching {
    public boolean patternMatching(String pattern, String value) {
        String s[]=new String[2];
        return solve(s,pattern,0,value,0);
    }
    /**
     * ���ݱ�������a,b�Ķ�Ӧֵ������ÿһ�ֿ��ܡ�
     * @param s   s[0]=a��Ӧ���ַ��� s[1]=b��Ӧ���ַ���
     * @param pattern ģʽ��
     * @param index1 ģʽ��ƥ��λ��
     * @param value ƥ�䴮����ƥ����ַ�����
     * @param index2 ƥ�䴮ƥ��λ��
     * @return
     */
    public boolean solve(String []s,String pattern,int index1,String value,int index2){
        //ƥ�����
        if(index1==pattern.length()&&index2==value.length()) return true;
        //ע��ƥ�䴮ƥ��λ�õ��ڳ��ȵ�ʱ��Ҳ���Լ���ƥ�䣬��Ϊģʽ����a��b����ƥ��մ���
        if(index1>=pattern.length()||index2>value.length()) return false;
        int num=pattern.charAt(index1)-'a';
        if(s[num]==null){
            //�ӵ�ǰ����a��b��Ӧ���ַ�����ÿһ�ֿ���
            for(int i=index2;i<=value.length();i++){
                s[num]=value.substring(index2,i);
                //(!s[num].equals(s[num^1]))  [��ָa��b��Ӧ���ַ����������]
                if(!s[num].equals(s[num^1])&&solve(s,pattern,index1+1,value,i)) return true;
            }
            //ʧ��ʱӦ�����ù��Ķ�Ӧ�ַ���Ϊ��
            s[num]=null;
            return false;
        }else{
            //����ǰa��b���ж�Ӧ���ַ���ƥ���ˣ���鿴��ǰλ��ʱ���ܹ�ƥ���ϡ�
            int end=index2+s[num].length();
            if(end> value.length()||!value.substring(index2,end).equals(s[num])) return false;
            return solve(s,pattern,index1+1,value,end);
        }
    }
}
