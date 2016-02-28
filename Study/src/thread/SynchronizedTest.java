package thread;

/**
 * ����������������߳�ͬ�������⣬��Account�зֱ���������ȡǮ�ķ�����
 * drawTest1�ǻ�ȡͬ��������
 * drawTest2��ͬ������
 * drawTest3��ͬ����
 * @author YOU
 *
 */
public class SynchronizedTest extends Thread {

	private Account account;
	private int balance;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ʹ��ͬ������������
//		account.drawTest1(balance);
		// ʹ��ͬ������
//		account.drawTest2(balance);
		// ʹ����
		account.drawTest3(balance);
	}

	public static void main(String[] args) {
		Account account = new Account("you", 1000);
		new SynchronizedTest("�߳�1", account, 600).start();
		new SynchronizedTest("�߳�2", account, 600).start();
	}

	public SynchronizedTest(String threadName, Account account, int balance) {
		super(threadName);
		this.account = account;
		this.balance = balance;
	}

}

