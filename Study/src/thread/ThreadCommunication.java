package thread;

/**
 * 这个类测试传统线程通信，主要用到的方法有wait(),notify(),notifyAll()
 * @author YOU
 *
 */
public class ThreadCommunication {

	public static void main(String[] args){
		Account account = new Account("YOU",0);
		new DrawThread(account,500,"取钱甲").start();
		new DepositThread(account,500,"存钱甲").start();
		new DepositThread(account,500,"存钱乙").start();
	}
	
}

class DrawThread extends Thread{
	
	private Account account;
	
	private int balance;
	public DrawThread(Account a,int b,String name){
		super(name);
		this.balance = b;
		this.account = a;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			account.draw(balance);
		}
	}
}

class DepositThread extends Thread{
	
	private Account account;
	
	private int balance;
	public DepositThread(Account a,int b,String name){
		super(name);
		this.balance = b;
		this.account = a;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			account.deposit(balance);
		}
	}
}