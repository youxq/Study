package thread;

/**
 * ��������join�̣߳������߳��½����̲߳�����ʱ�����������join()����
 * ��ô���߳������ȴ����߳��������֮��ſ�ʼ����
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
