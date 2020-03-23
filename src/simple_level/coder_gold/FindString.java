package simple_level.coder_gold;

/**
 * ������ 10.05. ϡ����������
 * ϡ�������������и��ź�����ַ������飬����ɢ����һЩ���ַ�������дһ�ַ������ҳ������ַ�����λ�á�
 *
 * ʾ��1:
 *
 *  ����: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  �����-1
 *  ˵��: �����ڷ���-1��
 * ʾ��2:
 *
 *  ���룺words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  �����4
 * ��ʾ:
 *
 * words�ĳ�����[1, 1000000]֮��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/23 10:33 ����
 */
public class FindString {
    public int findString(String[] words, String s) {
        return findString_sub(words,s,0,words.length-1);
    }

    public static int findString_sub(String[] words, String s, int left, int right) {
        while(left<right){
            int middle=(left+right)/2;

            if(words[middle].equals("")){
                int leftIndex=findString_sub(words, s, left, middle - 1);
                return leftIndex!=-1?leftIndex:findString_sub(words, s, middle+1, right);
            }

            if(words[middle].equals(s)){
                return middle;
            }else if(words[middle].compareTo(s)>0){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return words[left].equals(s)?left:-1;

    }
}
