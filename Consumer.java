public class Consumer extends Thread {
    Buffer buffer;
    int rate; // Items per second

    public Consumer(Buffer buffer, int rate){
        this.buffer = buffer;
        this.rate = rate;
    }

    public void run(){
        while(true){
            int value = buffer.pop();
            System.out.println("Consumed: " + value);
            try{
                if (rate > 0) {
                    // Calculate sleep time to match the consumption rate
                    Thread.sleep(1000 / rate);
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}