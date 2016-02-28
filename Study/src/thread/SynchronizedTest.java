package thread;

/**
 * 这个类是用来测试线程同步的问题，在Account中分别定义了三个取钱的方法，
 * drawTest1是获取同步监视器
 * drawTest2是同步方法
 * drawTest3是同步锁
 * @author YOU
 *
 */
public class SynchronizedTest extends Thread {

	private Account account;
	private int balance;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 使用同步监视器方法
//		account.drawTest1(balance);
		// 使用同步方法
//		account.drawTest2(balance);
		// 使用锁
		account.drawTest3(balance);
	}

	public static void main(String[] args) {
		Account account = new Account("you", 1000);
		new SynchronizedTest("线程1", account, 600).start();
		new SynchronizedTest("线程2", account, 600).start();
	}

	public SynchronizedTest(String threadName, Account account, int balance) {
		super(threadName);
		this.account = account;
		this.balance = balance;
	}

}

