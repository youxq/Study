package db;

import java.io.IOException;
import java.util.Properties;

/**
 * 这是一个属性获取类，可以从目录下的配置文件读取属性，属性的格式是key=value
 * @author YOU
 *
 */
public class PropertiesUtil {

	private static Properties prop = new Properties();
	
	/**
	 * 根据fileName加载文件，文件放在src根目录下即可
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
	 * 根据key取出value值
	 * @param key
	 * @return
	 */
	public static String getProperityValue(String key){
		return prop.getProperty(key);
	}
	
}
