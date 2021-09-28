package middle_level;

/**
 * 468. ��֤IP��ַ
 * ��дһ����������֤������ַ����Ƿ�����Ч�� IPv4 ��IPv6 ��ַ��
 *
 * �������Ч�� IPv4 ��ַ������ "IPv4" ��
 * �������Ч�� IPv6 ��ַ������ "IPv6" ��
 * ��������������͵� IP ��ַ������ "Neither" ��
 * IPv4��ַ��ʮ�������͵�����ʾ��ÿ����ַ���� 4 ��ʮ���������䷶ΧΪ0 -255����(".")�ָ���磬172.16.254.1��
 *
 * ͬʱ��IPv4 ��ַ�ڵ��������� 0 ��ͷ�����磬��ַ172.16.254.01 �ǲ��Ϸ��ġ�
 *
 * IPv6��ַ�� 8 �� 16 ���Ƶ���������ʾ��ÿ���ʾ16 ���ء���Щ������ͨ�� (":")�ָ����,2001:0db8:85a3:0000:0000:8a2e:0370:7334 ��һ����Ч�ĵ�ַ�����ң����ǿ��Լ���һЩ�� 0 ��ͷ�����֣���ĸ����ʹ�ô�д��Ҳ������Сд�����ԣ�2001:db8:85a3:0:0:8A2E:0370:7334 Ҳ��һ����Ч�� IPv6 address��ַ (�������� 0 ��ͷ�����Դ�Сд)��
 *
 * Ȼ�������ǲ�����Ϊĳ�����ֵΪ 0����ʹ��һ���յ��飬�����ڳ��� (::) ����������磬2001:0db8:85a3::8A2E:0370:7334 ����Ч�� IPv6 ��ַ��
 *
 * ͬʱ���� IPv6 ��ַ�У������ 0 Ҳ�ǲ�������ġ����磬02001:0db8:85a3:0000:0000:8a2e:0370:7334 ����Ч�ġ�
 *
 * ʾ�� 1��
 *
 * ���룺IP = "172.16.254.1"
 * �����"IPv4"
 * ���ͣ���Ч�� IPv4 ��ַ������ "IPv4"
 * ʾ�� 2��
 *
 * ���룺IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * �����"IPv6"
 * ���ͣ���Ч�� IPv6 ��ַ������ "IPv6"
 * ʾ�� 3��
 *
 * ���룺IP = "256.256.256.256"
 * �����"Neither"
 * ���ͣ��Ȳ��� IPv4 ��ַ���ֲ��� IPv6 ��ַ
 * ʾ�� 4��
 *
 * ���룺IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * �����"Neither"
 * ʾ�� 5��
 *
 * ���룺IP = "1e1.4.5.6"
 * �����"Neither"
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/28 09:42
 */
public class ValidIPAddress {
    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }
}
