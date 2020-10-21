package thread001;
/**
 * 生产者消费者问题
 * @author 67557
 *
 * date 2020年10月21日下午9:17:54
 */
class Clerk{
	private int productCount = 0;
	
	//生产产品
	public synchronized void produceProduct() {
		if(productCount < 20){
			productCount++;
			System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品了。。。");
			
			notify();
		}else{
			//等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//消费产品
	public synchronized void consumeProduct() {
		if(productCount > 0){
			System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品了。。。");
			productCount--;

			notify();
		}else{
			//等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class Producer extends Thread{  //生产者
	private Clerk clerk;

	public Producer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}
	
	@Override
		public void run() {
			System.out.println(getName() + ":开始生产产品。。。");
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clerk.produceProduct();
			}
		}
}
class Consumer extends Thread{   //消费者
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}
	
	@Override
		public void run() {
		System.out.println(getName() + ":开始消费产品。。。");
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
		}
}
public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Producer producer = new Producer(clerk);
		producer.setName("生产者1");
		
		Consumer consumer = new Consumer(clerk);
		consumer.setName("消费者1");
		
		Consumer consumer2 = new Consumer(clerk);
		consumer2.setName("消费者2");
		
		producer.start();
		consumer.start();
		consumer2.start();
		
	}
}
