package db;

import java.io.IOException;
import java.util.Properties;

/**
 * ����һ�����Ի�ȡ�࣬���Դ�Ŀ¼�µ������ļ���ȡ���ԣ����Եĸ�ʽ��key=value
 * @author YOU
 *
 */
public class PropertiesUtil {

	private static Properties prop = new Properties();
	
	/**
	 * ����fileName�����ļ����ļ�����src��Ŀ¼�¼���
	 * @param fileName
	 * @return
	 */
	public static boolean loadFile(String fileName){
		try {
			prop.load(PropertiesUtil.class.getClassLoader()
					.getResourceAsStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * ����keyȡ��valueֵ
	 * @param key
	 * @return
	 */
	public static String getProperityValue(String key){
		return prop.getProperty(key);
	}
	
}
