package interview;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AiBee面试
 * 实现有10000个url，实现一个程序，并行（假设100个线程）的下载这些url到指定的目录下 有错误打印日志，不中断
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/14 3:40 下午
 */
public class DownloadUrls {

    public void downloadMulti(List<String> urls) throws InterruptedException {
        int size = urls.size();
        int sizePerThread = 100;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(size / sizePerThread);
        AtomicInteger remain = new AtomicInteger(size);
        for (int i = 0; i < size / sizePerThread; i++) {
            int begin = i * sizePerThread;
            Runnable runnable = () -> {
                for (int j = 0; j < sizePerThread; j++) {
                    int index = begin + j;
                    download(urls.get(index));
                }
                latch.countDown();
            };
            executorService.submit(runnable);
        }
        latch.await();
        System.out.println("finish");
    }

    private void download(String url) {
        try {
            // do download
        } catch (Exception e) {
            System.err.println("download fail, url is : " + url);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DownloadUrls down = new DownloadUrls();
        down.downloadMulti(Arrays.asList(new String[] {"www", "eewewew"}));
    }
}
