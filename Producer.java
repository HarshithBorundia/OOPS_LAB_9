public class Producer extends Thread {
    Buffer buffer;
    int rate; // Items per second

    public Producer(Buffer buffer, int rate){
        this.buffer = buffer;
        this.rate = rate;
    }
    @Override
    public void run(){
        int value = 0;
        while(true){
            buffer.push(value);
            System.out.println("Produced: " + value);
            value++;
            try{
                if (rate > 0) {
                    // Calculate sleep time to match the production rate
                    Thread.sleep(1000 / rate);
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}