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
				System.out.println("现在的余额为" + getMoney());
				money = getMoney() - balance;
				System.out.println("取走" + balance + "后剩余" + getMoney());
			} else {
				System.out.println("余额不足");
			}
		}
	}
	
	public synchronized void drawTest2(int balance){
		if (balance <= getMoney()) {
			System.out.println("现在的余额为" + getMoney());
			money = getMoney() - balance;
			System.out.println("取走" + balance + "后剩余" + getMoney());
		} else {
			System.out.println("余额不足");
		}
	}
	
	public void drawTest3(int balance){
		lock.lock();
		try{
			if (balance <= getMoney()) {
				System.out.println("现在的余额为" + getMoney());
				money = getMoney() - balance;
				System.out.println("取走" + balance + "后剩余" + getMoney());
			} else {
				System.out.println("余额不足");
			}
		}
		finally{
			lock.unlock();
		}
		
	}
	
	
	/**
	 * 取钱方法
	 * @param drawAccount
	 */
	 public synchronized void draw(double drawAccount){
		 try{
			 if(!flag){
				 this.wait();
			 }
			 else{
				 System.out.println(Thread.currentThread().getName() +
						 "取钱" + drawAccount);
				 money -= drawAccount;
				 System.out.println("余额: " + money);
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
						 "存钱" + drawAccount);
				 money += drawAccount;
				 System.out.println("余额: " + money);
				 flag = true;
				 this.notifyAll();
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	 }
	
}
