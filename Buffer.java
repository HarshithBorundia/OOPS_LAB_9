public class Buffer{
    int[] buffer;
    int size=0;
    int top = 0;
    int numElements=0;
    public Buffer(int size){
        this.size = size;
        buffer = new int[size];
    }
    public  synchronized void push(int element){
        if(numElements==size){
            try{
                System.out.println("Buffer is full. Waiting for consumer to consume");
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();}
        }
        buffer[top] = element;
        top = (top+1)%size;
        numElements++;
        notify();
    }
    public synchronized int pop(){
        if(numElements==0){
            try{
                System.out.println("Buffer is empty. Waiting for producer to produce");
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();}
        }
        int element = buffer[(top+size-1)%size];
        top = (top+size-1)%size;
        numElements--;
        notify();
        return element;
    }
}