package basic;

import java.text.DecimalFormat;

/**
 * ������������byte��char�ڴ洢���ĺ�Ӣ���ַ�ʱ���������
 * ����char = 2*byte��Ҳ����char��16���أ���byte��8������
 * ��io���У���InputStream��Reader��OutputStream��Writer
 * ����Stream��Reader/Writer���������Stream�õ���byte����Reader�õ���char
 * �ڶ�ȡ��д���������ַ����ı�ʱ��һ���Ƽ���char����Ϊbyte���ܻ���������ַ�����
 * @author YOU
 *
 */
public class ByteAndChar {

	public static void main(String[] args){
		// �ֽ�������
//		byteTest();
//		// �ַ�������
//		charTest();
		Double d = 0.0001;
//		String result = new DecimalFormat("#.00").format(d);
		d = Double.parseDouble(String.format("%.2f",d));
//		Double r = Double.parseDouble(result);
		System.out.println(d);
		
	}
	
	/**
	 * �ֽ�������
	 */
	public static void byteTest(){
		// ������byte�洢Ӣ���ַ�����պô���
		byte b1 = 'a';
		System.out.println(b1);
		byte b2 = (byte) '��';
		System.out.println((char)b2);
	}
	
	/**
	 * �ַ�������
	 */
	public static void charTest(){
		char c = 'a';
		System.out.println(c);
	}
}
