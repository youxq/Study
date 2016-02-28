///����
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �������������ļ���������JAVA�ļ��������ֽ���InputStream���ַ���Reader
 * InputStream��Reader�ķ�����Ҫ��read(),reader(byte/char[]),reader(byte/char[],int
 * off,int length) ����ֵ�Ƕ�ȡ�����鳤��
 * ���е��ַ�������ֽ�����������Ҫ��ʽ���գ��������ջ����޷����գ�������finally��������
 * @author YOU
 *
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws Exception {

		// fileInputStream();

		fileReader();
	}

	/**
	 * �ֽ������Է���
	 * 
	 * @throws IOException
	 */
	public static void fileInputStream() throws IOException{
		
		File file = new File("src/file/FileInputStreamTest.java");
		if(!file.exists()){
			file.createNewFile();
		}
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int hasRead = 0;
		try{		
			while((hasRead=fis.read(buffer))>0){
				System.out.println(new String(buffer,0,hasRead));
			}
		}finally{
			fis.close();
		}
	}

	/**
	 * �ַ������Է���
	 * 
	 * @throws IOException
	 */
	public static void fileReader() throws IOException {
		File file = new File("src/file/FileInputStreamTest.java");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);

		char[] buffer = new char[2];
		int len = 0;
		while ((len = fr.read(buffer)) > 0) {
			System.out.println("the length of the reader String is: " + len);
			System.out.println(new String(buffer, 0, len));
		}
	}
}
