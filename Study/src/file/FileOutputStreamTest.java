package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutputStreamTest {

	public static void main(String[] args) throws Exception{
		fileOutputStream();
	}

	/**
	 * 文件输出流测试方法
	 * 不管是字节输入流还是字符输入流，都会将换行等特殊字符读入
	 * write方法是将文件清空后重新输入
	 * @throws Exception
	 */
	public static void fileOutputStream() throws Exception {

		// 获取要输入的文件和输出的文件
		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");

		if (!inputFile.exists()) {
			inputFile.createNewFile();
		}
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		FileInputStream fileInputStream = new FileInputStream(inputFile);
		FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

		byte[] buffer = new byte[1024];
		int hasRead = 0;
		while ((hasRead = fileInputStream.read(buffer)) > 0) {
			System.out.print(new String(buffer,0,hasRead));
			fileOutputStream.write(buffer, 0, hasRead);
		}
	}

	/**
	 * BufferReader和PrintWriter测试方法
	 * @throws Exception 
	 */
	public static void bufferReaderTest() throws Exception {
		// 获取输入和输出文件
		File input = new File("input.txt");
		File output = new File("output.txt");

		// 获取输出流
		FileWriter fw = new FileWriter(output);
		PrintWriter bw = new PrintWriter(fw);

		// 获取输入流
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);

		String buffer = br.readLine();
		while (buffer != null) {
			bw.println(buffer);
			buffer = br.readLine();
		}

		br.close();
		bw.close();
	}
}
