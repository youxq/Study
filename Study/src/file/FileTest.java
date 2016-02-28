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
	 * 用来测试文件的方法
	 * @throws Exception 
	 */
	public static void fileTest(String parentPath) throws Exception {
		// 在当前的项目目录下新建文件，文件名为fileTest
		File file = new File(parentPath + "/fileTest");
		
		// 先获取这个文件所对应的绝对路径的文件对象，而后在获取父路径
		// 因为在新建文件的时候使用相对路径，所以必须先获取绝对路径文件对象，才能够使用getParent()得到正确的结果
		System.out.println(file.getAbsoluteFile().getParent());
		System.out.println(file.getAbsolutePath());
		
		// 验证这个文件是否是绝对路径文件
		if (file.isAbsolute())
			System.out.println("It is an absolute directory");
		else
			System.out.println("It is not an absolute directory");
		
		// 判断这个文件是否存在，如果不存在则创建一个新的文件，此时需要显示捕捉异常
		if (file.exists()) {
			System.out.println("file or directory exists");
		} else {
			System.out
					.println("file or directory doesn't exist,now create a new directory");
			file.createNewFile();
		}
		
		// 判断这个File是文件，还是目录，如果文件不存在则isFile()和isDirectory()方法都会返回false
		if (file.isFile()) {
			System.out.println("It is file");
		} else if (file.isDirectory()) {
			System.out.println("It is directory");
		} else {
			System.out.println("It is null");
		}
		
		// 删除文件的方法
		//file.delete();
	}

	/**
	 * 用来测试目录的方法,返回新建的目录所对应的对象
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
