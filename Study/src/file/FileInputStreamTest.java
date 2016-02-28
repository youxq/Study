///测试
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 这是用来测试文件输入流的JAVA文件，包括字节流InputStream和字符流Reader
 * InputStream和Reader的方法主要是read(),reader(byte/char[]),reader(byte/char[],int
 * off,int length) 返回值是读取的数组长度
 * 所有的字符输入和字节输入流都需要显式回收，垃圾回收机制无法回收，建议在finally语句块里面
 * @author YOU
 *
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws Exception {

		// fileInputStream();

		fileReader();
	}

	/**
	 * 字节流测试方法
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
	 * 字符流测试方法
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
