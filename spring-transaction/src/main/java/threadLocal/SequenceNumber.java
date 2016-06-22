package threadLocal;

/**
 * ThreadLocal示例<br>
 * ThreadLocal为线程的一个本地对象，当工作与多线程中的对象使用ThreadLocal维护对象时，ThreadLocal会为每个线程分配一个独立的变量副本。
 * 所以每个变量都可以独立地改变自己的变量而不会影响到其他线程所对应的副本。<br>
 * 其实现原理很简单：ThreadLocal内部维护这一个Map对象，用于存储每一个线程的变量副本，其中key为线程对象，value为对应线程的变量副本
 *
 * @author: chenssy
 * @date: 2016/6/15 22:06
 *
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return  0;
        }
    };

    public int getNextNumber(){
        seqNum.set(seqNum.get() + 1);

        return seqNum.get();
    }

    public static void main(String[] args){
        SequenceNumber sn = new SequenceNumber();
        TestClient ts1 = new TestClient(sn);
        TestClient ts2 = new TestClient(sn);
        TestClient ts3 = new TestClient(sn);

        ts1.start();
        ts2.start();
        ts3.start();
    }


    private static class TestClient extends Thread{
        private SequenceNumber sn ;
        public TestClient(SequenceNumber sn){
            this.sn = sn;
        }

        public  void run(){
            for(int i = 0 ; i < 3 ; i++){
                System.out.println("tread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNumber() + "]" );
            }
        }

    }
}
