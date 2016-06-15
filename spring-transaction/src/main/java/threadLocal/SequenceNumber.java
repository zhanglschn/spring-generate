package threadLocal;

/**
 * ThreadLocal示例
 *
 * @Author: chenssy
 * @Date: 2016/6/15 22:06
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
