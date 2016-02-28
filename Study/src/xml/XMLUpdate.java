package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLUpdate {

	private final String XMLPath = "D:\\Kettle.xml";

	// private Job job; 这是整个任务的对象，包含需要传入的信息



	private boolean updateElement(String name, String value) {

		// 获取DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		try {

			// 获取XML文件对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse(XMLPath);
			// 获取节点对象
			NodeList sonlist = xmldoc.getElementsByTagName(name);
			sonlist.item(0).setTextContent(value);

			// 更新整个文档
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File(
					XMLPath)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("更新" + name + "节点为" + value + "成功");
		return true;
	}

	private String getSourceType(int i) {
		switch (i) {
		case 0:
			return "Excel";
		case 1:
			return "Mysql";
		case 2:
			return "SQLServer";
		case 3:
			return "Oracle";
		default:
			return null;
		}

	}

	public static void main(String[] args) {
	}
}
