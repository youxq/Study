package file;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * ������������Ի�ȡϵͳ����������ķ���
 * �����ַ�ʽһ����ʹ��Scanner�࣬һ����ʹ��io���Լ���װ
 * @author YOU
 *
 */
public class SystemInTest {

	public static void main(String[] args) throws Exception{
		//scannerTest();
		ioSystemInTest();
	}
	
	public static void scannerTest(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String readLine = sc.nextLine();
			if(readLine.equals("exit")){
				break;
			}
			System.out.println(">>>" + readLine);
		}
	}
	
	public static void ioSystemInTest() throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String readLine = br.readLine(); 
		
		while(readLine != null){
			if(readLine.equals("exit")){
				System.out.println("program exit!");
				break;
			}
			System.out.println(">>>" + readLine);
			readLine = br.readLine();
		}
	}
}
