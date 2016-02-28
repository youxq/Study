package file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws Exception {
		File dirTest = directoryTest();
		fileTest(dirTest.getAbsolutePath());
		String[] childrenFileArray = dirTest.list();
		for(String fileTemp:childrenFileArray){
			System.out.println(fileTemp);
		}
	}

	/**
	 * ���������ļ��ķ���
	 * @throws Exception 
	 */
	public static void fileTest(String parentPath) throws Exception {
		// �ڵ�ǰ����ĿĿ¼���½��ļ����ļ���ΪfileTest
		File file = new File(parentPath + "/fileTest");
		
		// �Ȼ�ȡ����ļ�����Ӧ�ľ���·�����ļ����󣬶����ڻ�ȡ��·��
		// ��Ϊ���½��ļ���ʱ��ʹ�����·�������Ա����Ȼ�ȡ����·���ļ����󣬲��ܹ�ʹ��getParent()�õ���ȷ�Ľ��
		System.out.println(file.getAbsoluteFile().getParent());
		System.out.println(file.getAbsolutePath());
		
		// ��֤����ļ��Ƿ��Ǿ���·���ļ�
		if (file.isAbsolute())
			System.out.println("It is an absolute directory");
		else
			System.out.println("It is not an absolute directory");
		
		// �ж�����ļ��Ƿ���ڣ�����������򴴽�һ���µ��ļ�����ʱ��Ҫ��ʾ��׽�쳣
		if (file.exists()) {
			System.out.println("file or directory exists");
		} else {
			System.out
					.println("file or directory doesn't exist,now create a new directory");
			file.createNewFile();
		}
		
		// �ж����File���ļ�������Ŀ¼������ļ���������isFile()��isDirectory()�������᷵��false
		if (file.isFile()) {
			System.out.println("It is file");
		} else if (file.isDirectory()) {
			System.out.println("It is directory");
		} else {
			System.out.println("It is null");
		}
		
		// ɾ���ļ��ķ���
		//file.delete();
	}

	/**
	 * ��������Ŀ¼�ķ���,�����½���Ŀ¼����Ӧ�Ķ���
	 * @return
	 */
	public static File directoryTest() {
		File dirTest = new File("dirTest");
		if(!dirTest.exists()){
			dirTest.mkdir();
		}
		return dirTest;
	}
}
