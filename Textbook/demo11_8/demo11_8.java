package demo11_8;

//票类
class Tickets {
    protected int size;        //总票数
    int number = 0;            //票号
    boolean available = false;

    public Tickets(int size)    //传入总票数参数
    {
        this.size = size;
    }

    public synchronized void put()    //同步方法 ，实现存票功能
    {
        if (available)
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        System.out.println("存入第" + (++number) + "号票");
        available = true;
        notify();                //存票后唤醒售票线程开始售票
    }

    public synchronized void sell() {
        if (!available)
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        System.out.println("售出第" + number + "号票");
        available = false;
        notify();
        if (number == size)    //售完最后一票  设置结束标志
            number = size + 1;
    }
}

class Producer extends Thread {
    Tickets t;

    public Producer(Tickets t) {
        this.t = t;
    }

    public void run() {
        while (t.number < t.size)
            t.put();
    }
}

class Consumer extends Thread {
    Tickets t;

    public Consumer(Tickets t) {
        this.t = t;
    }

    public void run() {
        while (t.number < t.size)
            t.sell();
    }
}

public class demo11_8 {
    public static void main(String argsp[]) {
        Tickets t = new Tickets(10);
        new Producer(t).start();
        new Consumer(t).start();
    }

}
