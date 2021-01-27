package interview.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/27 4:36 ÏÂÎç
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 18888));
        channel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            buffer.put((new Date().toString() + "\n" + str).getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        channel.close();
    }
}
