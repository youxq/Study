package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferClassTest {

	public static void main(String[] args) throws Exception{

		//bufferedOutputStreamTest();
		
		bufferedWriterTest();
	}

	/**
	 * 这个方法是输入缓存类的测试方法
	 * 从表面上看运用BufferedInputStream这个类进行输入和直接用FileInputStream进行输入是没有区别的
	 * 但是实际上这个有缓存会减少对文件的直接访问从而提高效率
	 * 
	 * @throws Exception
	 */
	public static void bufferedInputStreamTest() throws Exception {
		File file = new File("src/file/BufferClassTest.java");
		if (!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buffer = new byte[1024];
		int hasRead = 0;
		while ((hasRead = bis.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, hasRead));
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void bufferedOutputStreamTest() throws Exception {
		// 获取要输入的文件和输出的文件
		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");

		if (!inputFile.exists()) {
			System.out.println("create new input.txt");
			inputFile.createNewFile();
		}
		if (!outputFile.exists()) {
			System.out.println("create new output.txt");
			outputFile.createNewFile();
		}

		FileInputStream fileInputStream = new FileInputStream(inputFile);
		FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

		byte[] buffer = new byte[1024];
		int hasRead = 0;
		while ((hasRead = bis.read(buffer)) > 0) {
			System.out.print(new String(buffer, 0, hasRead));
			bos.write(buffer,0,hasRead);
		}
		bos.close();
		System.out.println("the end!");
	}

	public static void bufferedReaderTest() {

	}

	public static void bufferedWriterTest() throws Exception {
		// 获取要输入的文件和输出的文件
		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");

		if (!inputFile.exists()) {
			System.out.println("create new input.txt");
			inputFile.createNewFile();
		}
		if (!outputFile.exists()) {
			System.out.println("create new output.txt");
			outputFile.createNewFile();
		}

		FileReader fr = new FileReader(inputFile);
		FileWriter fw = new FileWriter(outputFile);

		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		String readLine = "";
		while((readLine=br.readLine()) != null){
			System.out.println(readLine);
			bw.write(readLine);
			bw.newLine();
		}
		bw.close();
		System.out.println("the end!");
	}
}
