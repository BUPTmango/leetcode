package thread.simple_level;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. �����ӡ
 * �����ṩ��һ���ࣺ
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * ������ͬ���߳� A��B��C ���Ṳ��һ��Fooʵ����
 * <p>
 * һ��������� first() ����
 * һ���������second() ����
 * ����һ��������� third() ����
 * ������޸ĳ�����ȷ�� second() ������ first() ����֮��ִ�У�third() ������ second() ����֮��ִ�С�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3]
 * ���: "firstsecondthird"
 * ����:
 * �������̻߳ᱻ�첽������
 * ���� [1,2,3] ��ʾ�߳� A ������� first() �������߳� B ������� second() �������߳� C ������� third() ������
 * ��ȷ������� "firstsecondthird"��
 * ʾ�� 2:
 * <p>
 * ����: [1,3,2]
 * ���: "firstsecondthird"
 * ����:
 * ���� [1,3,2] ��ʾ�߳� A ������� first() �������߳� B ������� third() �������߳� C ������� second() ������
 * ��ȷ������� "firstsecondthird"��
 * <p>
 * ��ʾ��
 * <p>
 * ���������е������ƺ���ʾ��˳�򣬵������ǲ�����֤�߳��ڲ���ϵͳ�еĵ���˳��
 * �㿴���������ʽ��Ҫ��Ϊ��ȷ�����Ե�ȫ���ԡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/28 11:15
 */
public class Foo {

    private ReentrantLock lock = null;
    private Condition c1 = null;
    private Condition c2 = null;
    private Condition c3 = null;

    private int flag = 1;

    public Foo() {
        lock = new ReentrantLock();
        c1 = lock.newCondition();
        c2 = lock.newCondition();
        c3 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
