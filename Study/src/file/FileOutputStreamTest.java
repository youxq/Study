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
	 * �ļ���������Է���
	 * �������ֽ������������ַ������������Ὣ���е������ַ�����
	 * write�����ǽ��ļ���պ���������
	 * @throws Exception
	 */
	public static void fileOutputStream() throws Exception {

		// ��ȡҪ������ļ���������ļ�
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
	 * BufferReader��PrintWriter���Է���
	 * @throws Exception 
	 */
	public static void bufferReaderTest() throws Exception {
		// ��ȡ���������ļ�
		File input = new File("input.txt");
		File output = new File("output.txt");

		// ��ȡ�����
		FileWriter fw = new FileWriter(output);
		PrintWriter bw = new PrintWriter(fw);

		// ��ȡ������
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
