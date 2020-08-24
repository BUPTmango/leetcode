package simple_level;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 299. ��������Ϸ
 * ���ں�����һ���� �����֣�Bulls and Cows����Ϸ������Ϸ�������£�
 *
 * ��д��һ���������֣��������Ѳ���������Ƕ��١�
 * ����ÿ�²�һ�Σ���ͻ����һ����ʾ���������Ĳ²��������ж���λ�������ֺ�ȷ��λ�ö��¶��ˣ���Ϊ��Bulls��, ��ţ�����ж���λ�������ֲ¶��˵���λ�ò��ԣ���Ϊ��Cows��, ��ţ����
 * ���Ѹ�����ʾ�����£�ֱ���³��������֡�
 * ��д��һ�������������ֺ����ѵĲ²���������ʾ�ĺ����������ַ����ĸ�ʽΪ xAyB ��x �� y �������֣�A ��ʾ��ţ����?B?��ʾ��ţ��
 *
 * xA ��ʾ�� x λ���ֳ��������������У���λ�ö�����������һ�¡�
 * yB ��ʾ�� y λ���ֳ��������������У���λ�����������ֲ�һ�¡�
 * ��ע���������ֺ����ѵĲ²��������ܺ����ظ����֣�ÿλ����ֻ��ͳ��һ�Ρ�
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: secret = "1807", guess = "7810"
 * ���: "1A3B"
 * ����: 1?��ţ��?3?��ţ����ţ�� 8����ţ�� 0, 1?�� 7��
 * ʾ�� 2:
 *
 * ����: secret = "1123", guess = "0111"
 * ���: "1A1B"
 * ����: ���Ѳ²����еĵ�һ�� 1?�ǹ�ţ���ڶ���������� 1?�ɱ���Ϊ��ţ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/24 9:34 ����
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // �ȱ���һ���ַ�������������ַ�����ǰ�����ַ���ͬ����"��ţ��"��һ�����򣬽������ַ������ַ�����HashMap�У����д���ͳ�ƣ����µ��ַ�����һ��Array�С�
        for (int i = 0; i < secret.length(); i++) {
            char temp = secret.charAt(i);
            if (temp == guess.charAt(i)) {
                aCount++;
            } else {
                list.add(guess.charAt(i));
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        // ��һ�α�����Ϻ���еڶ��α�������ʱ��array���ǲµ��ַ�����û�ж��Ϻŵ��ַ������λ�ȡarray�е��ַ�����HashMap���Ƿ��и��ַ���
        // ����У�����"ĸţ��"��һ��Ȼ�󽫸��ַ��Ĵ�����һ��������ַ���Map�еĴ���Ϊ���������
        for (Character c : list) {
            if (map.containsKey(c)) {
                bCount++;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return aCount + "A" + bCount + "B";
    }
}
