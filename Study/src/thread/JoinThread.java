package thread;

/**
 * 这个类测试join线程，当父线程新建子线程并启动时，如果调用了join()方法
 * 那么父线程则必须等待子线程运行完毕之后才开始运行
 * @author YOU
 *
 */
public class JoinThread extends Thread {

	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(this.getName() + ": " + i);
		}
	}
	
	public static void main(String[] args) throws Exception{
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName() + ": " + i);
			if(i==2){
				JoinThread jt = new  JoinThread();
				jt.start();
				jt.join();
			}
		}
	}
	
	
}
