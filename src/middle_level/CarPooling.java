package middle_level;

/**
 * �������
 * 1094. ƴ��
 * ��������һλ˳�糵˾�������������capacity������λ���������ؿ͡����ڵ�·�����ƣ���ֻ����һ��������ʻ��Ҳ����˵���������ͷ��ı䷽������Խ�������Ϊһ����������
 *
 * �����һ�ݳ˿��г̼ƻ���trips[][]������trips[i] = [num_passengers, start_location, end_location]�����˵� i ��˿͵��г���Ϣ��
 *
 * ������͵ĳ˿�������
 * �˿͵��ϳ��ص㣻
 * �Լ��˿͵��³��ص㡣
 * ��Щ�����ĵص�λ���Ǵ���ĳ�ʼ����λ����ǰ��ʻ����Щ�ص�����ľ��루����һ���������ʻ�����ϣ���
 *
 * ������ݸ������г̼ƻ���ͳ��ӵ���λ�������ж���ĳ��Ƿ����˳����ɽ������г˿͵����񣨵��ҽ�������������и������г��н������г˿�ʱ������true�������뷵�� false����
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺trips = [[2,1,5],[3,3,7]], capacity = 4
 * �����false
 * ʾ�� 2��
 *
 * ���룺trips = [[2,1,5],[3,3,7]], capacity = 5
 * �����true
 * ʾ�� 3��
 *
 * ���룺trips = [[2,1,5],[3,5,7]], capacity = 3
 * �����true
 * ʾ�� 4��
 *
 * ���룺trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * �����true
 * 
 *
 * ��ʾ��
 *
 * ����Լ���˿ͻ��Ծ����� �����º��ϡ� ����������
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <=capacity <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/27 8:14 ����
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] answer = new int[1001];
        for (int[] trip : trips) {
            answer[trip[1] - 1] += trip[0];
            answer[trip[2] - 1] -= trip[0];
        }

        for (int i = 1; i < 1001; i++) {
            answer[i] += answer[i - 1];
            if (answer[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
