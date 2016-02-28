package basic;

import java.text.DecimalFormat;

/**
 * 这是用来测试byte和char在存储中文和英文字符时所起的作用
 * 首先char = 2*byte，也就是char是16比特，而byte是8个比特
 * 在io流中，有InputStream，Reader，OutputStream，Writer
 * 其中Stream和Reader/Writer的区别就是Stream用的是byte，而Reader用的是char
 * 在读取或写入有中文字符的文本时，一般推荐用char，因为byte可能会出现中文字符乱码
 * @author YOU
 *
 */
public class ByteAndChar {

	public static void main(String[] args){
		// 字节流测试
//		byteTest();
//		// 字符流测试
//		charTest();
		Double d = 0.0001;
//		String result = new DecimalFormat("#.00").format(d);
		d = Double.parseDouble(String.format("%.2f",d));
//		Double r = Double.parseDouble(result);
		System.out.println(d);
		
	}
	
	/**
	 * 字节流测试
	 */
	public static void byteTest(){
		// 首先用byte存储英文字符，则刚好存满
		byte b1 = 'a';
		System.out.println(b1);
		byte b2 = (byte) '中';
		System.out.println((char)b2);
	}
	
	/**
	 * 字符流测试
	 */
	public static void charTest(){
		char c = 'a';
		System.out.println(c);
	}
}
