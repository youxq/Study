package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private final ReentrantLock lock = new ReentrantLock();
	private String accountNum;
	private int money;
	private boolean flag = false;
	public Account(String accountNum, int money) {
		this.accountNum = accountNum;
		this.money = money;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public int getMoney() {
		return money;
	}
	
	public void drawTest1(int balance){
		synchronized(this){
			if (balance <= getMoney()) {
				System.out.println("���ڵ����Ϊ" + getMoney());
				money = getMoney() - balance;
				System.out.println("ȡ��" + balance + "��ʣ��" + getMoney());
			} else {
				System.out.println("����");
			}
		}
	}
	
	public synchronized void drawTest2(int balance){
		if (balance <= getMoney()) {
			System.out.println("���ڵ����Ϊ" + getMoney());
			money = getMoney() - balance;
			System.out.println("ȡ��" + balance + "��ʣ��" + getMoney());
		} else {
			System.out.println("����");
		}
	}
	
	public void drawTest3(int balance){
		lock.lock();
		try{
			if (balance <= getMoney()) {
				System.out.println("���ڵ����Ϊ" + getMoney());
				money = getMoney() - balance;
				System.out.println("ȡ��" + balance + "��ʣ��" + getMoney());
			} else {
				System.out.println("����");
			}
		}
		finally{
			lock.unlock();
		}
		
	}
	
	
	/**
	 * ȡǮ����
	 * @param drawAccount
	 */
	 public synchronized void draw(double drawAccount){
		 try{
			 if(!flag){
				 this.wait();
			 }
			 else{
				 System.out.println(Thread.currentThread().getName() +
						 "ȡǮ" + drawAccount);
				 money -= drawAccount;
				 System.out.println("���: " + money);
				 flag = false;
				 this.notifyAll();
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	 }
	 
	 public synchronized void deposit(double drawAccount){
		 try{
			 if(flag){
				 this.wait();
			 }
			 else{
				 System.out.println(Thread.currentThread().getName() +
						 "��Ǯ" + drawAccount);
				 money += drawAccount;
				 System.out.println("���: " + money);
				 flag = true;
				 this.notifyAll();
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	 }
	
}
