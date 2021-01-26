package interview.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * NIO �����
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/25 10:35 ����
 */
public class NoBlockServer {

    public static void main(String[] args) throws IOException {

        // 1.��ȡͨ��
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2.�л��ɷ�����ģʽ
        server.configureBlocking(false);

        // 3. ������
        server.bind(new InetSocketAddress(6666));

        // 4. ��ȡѡ����
        Selector selector = Selector.open();

        // 4.1��ͨ��ע�ᵽѡ�����ϣ�ָ�����ա�����ͨ�����¼�
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 5. ��ѵ�ػ�ȡѡ�������ѡ����������¼�--->ֻҪselect()>0��˵���Ѿ���
        while (selector.select() > 0) {
            // 6. ��ȡ��ǰѡ��������ע��ġ�ѡ�����(�Ѿ����ļ����¼�)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 7. ��ȡ�ѡ����������¼���(��ͬ���¼�����ͬ����)
            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();

                // �����¼�����
                if (selectionKey.isAcceptable()) {

                    // 8. ��ȡ�ͻ��˵�����
                    SocketChannel client = server.accept();

                    // 8.1 �л��ɷ�����״̬
                    client.configureBlocking(false);

                    // 8.2 ע�ᵽѡ������-->�õ��ͻ��˵�����Ϊ�˶�ȡͨ��������(�����������¼�)
                    client.register(selector, SelectionKey.OP_READ);

                } else if (selectionKey.isReadable()) { // ���¼�����

                    // 9. ��ȡ��ǰѡ����������״̬��ͨ��
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 9.1��ȡ����
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    // 9.2�õ��ļ�ͨ�������ͻ��˴��ݹ�����ͼƬд��������Ŀ��(дģʽ��û���򴴽�)
                    FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                    while (client.read(buffer) > 0) {
                        // �ڶ�֮ǰ��Ҫ�л��ɶ�ģʽ
                        buffer.flip();

                        outChannel.write(buffer);

                        // �����л���дģʽ�����ùܵ�������ȡ�ļ�������
                        buffer.clear();
                    }
                }
                // 10. ȡ��ѡ���(�Ѿ���������¼�����Ӧ��ȡ������)
                iterator.remove();
            }
        }

    }
}

