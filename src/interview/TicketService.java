package interview;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * �����һ��
 *
 * ������ģ��һ�¸����˳�����Ϊ���������˸���ֻ��һ�����ᣬ��Ʊ50�š�
 *  ���� 1. ������һ���ļ�A������Ѿ���Ʊ�˵ĳ˿ͣ��ļ���ĸ�ʽ�ǣ�
 * ���� 3100001990****0011
 * ���� 3200001988****2222
 * �ļ������У���һ���ǳ˿����֣��ڶ��������֤�š�
 *
 * 2. ������һ���ļ�B����Ѿ���Ʊ�ĳ˿ͣ��ļ���ʽ���ļ�Aһ�£���������Ʊ��¼��
 *
 * 3. ������һ����Ʊ������ֱ��ˢ���֤�� ���룺checkin <���֤��> �磺checkin 3100001990****0011
 * ������ɹ�����ʧ��ԭ�� ���ͬʱ����Ҫ���ļ�B������һ����Ʊ��¼
 * PS���Լ����ǺͶ�����ܵ�ʧ��ԭ��
 *
 * 4. ��Ʊ���� ���룺buy <����> <���֤��> �磺buy ���� 3100001990****0011
 * ������ɹ�����ʧ��ԭ��
 *
 * 5. ��Ʊ���� ���룺refund <���֤��> �磺refund 3100001990****0011
 * ������ɹ�����ʧ��ԭ��
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/26 5:09 ����
 */
public class TicketService {
    /**
     * key Ϊ���֤��    valueΪ����
     */
    private static Map<String, String> buyMap = new ConcurrentHashMap<>();
    private static Map<String, String> checkInMap = new ConcurrentHashMap<>();

    public static void checkIn(String id) {
        if (buyMap.containsKey(id)) {
            // ��Ʊ�ɹ�
            checkInMap.put(id, buyMap.get(id));
            System.out.println("��Ʊ�ɹ�");
        } else {
            System.out.println("��δ����Ʊ���޷���Ʊ");
        }
    }

    public static void buy(String name, String id) {
        if (!buyMap.containsKey(id)) {
            buyMap.put(id, name);
            System.out.println("��Ʊ�ɹ�");
        } else {
            System.out.println("���Ѿ��������Ʊ�������ظ�����");
        }
    }

    public static void refund(String id) {
        if (checkInMap.containsKey(id)) {
            System.out.println("���Ѿ���Ʊ���޷���Ʊ������ϵ������Ա����");
            return;
        }
        if (buyMap.containsKey(id)) {
            // ��Ʊ
            buyMap.remove(id);
            System.out.println("��Ʊ�ɹ�");
        } else {
            System.out.println("����δ��Ʊ���޷�������Ʊҵ��");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            switch (strs[0]) {
                case "buy":
                    if (strs.length != 3) {
                        System.out.println("�����������룺buy <����> <���֤��>");
                    } else {
                        buy(strs[1], strs[2]);
                    }
                    break;
                case "checkin":
                    if (strs.length != 2) {
                        System.out.println("��������, ���룺checkin <���֤��> ");
                    } else {
                        checkIn(strs[1]);
                    }
                    break;
                case "refund":
                    if (strs.length != 2) {
                        System.out.println("��������, ���룺refund <���֤��> ");
                    } else {
                        refund(strs[1]);
                    }
                    break;
                default:
                    System.out.println("��������������buy��checkin��refund�Ȳ���");
            }
        }
    }
}
