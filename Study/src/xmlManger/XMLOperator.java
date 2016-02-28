package xmlManger;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLOperator {

	private static String xmlPath = "D:\\Mysql.ktr";
	private static String middleOutput = "Middle Output";

	public static void getFamilyMemebers() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlPath); // 使用dom解析xml文件

			NodeList fieldsList = doc.getElementsByTagName("fields");
			Element fields = (Element) fieldsList.item(0);
		    NodeList fieldList = fields.getChildNodes();
			System.out.println("length is " + fieldsList.getLength());
			System.out.println("l  " + fieldList.getLength());
			while (fieldList.getLength() != 0) {
				Node nd = fieldList.item(0);
//				Node parentNode = nd.getParentNode();
				fields.removeChild(nd);
			}

			Element field = doc.createElement("field");

			Element column_name = doc.createElement("column_name");
			column_name.setTextContent("12");
			field.appendChild(column_name);

			Element stream_name = doc.createElement("stream_name");
			stream_name.setTextContent("12");
			field.appendChild(stream_name);

			fields.appendChild(field);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(doc), new StreamResult(new File(
					xmlPath)));
			// for (int i = 0; i < sonlist.getLength(); i++) // 循环处理对象
			// {
			// Element son = (Element)sonlist.item(i);;
			//
			// for (Node node = son.getFirstChild(); node != null; node =
			// node.getNextSibling()){
			// if (node.getNodeType() == Node.ELEMENT_NODE){
			// String name = node.getNodeName();
			// // String value = node.getFirstChild().getNodeValue();
			// // System.out.println(name+" : "+value);
			// System.out.println(name);
			// }
			// }
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modifySon() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse(xmlPath);

			Element root = xmldoc.getDocumentElement();

			Element per = (Element) selectSingleNode("/father/son[@id='001']",
					root);
			per.getElementsByTagName("age").item(0).setTextContent("27");

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File(
					xmlPath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void discardSon() {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse(xmlPath);

			Element root = xmldoc.getDocumentElement();

			Element son = (Element) selectSingleNode("/father/son[@id='002']",
					root);
			root.removeChild(son);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File(
					xmlPath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createSon() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(false);

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse(xmlPath);

			Element root = xmldoc.getDocumentElement();

			// 删除指定节点

			Element son = xmldoc.createElement("son");
			son.setAttribute("id", "004");

			Element name = xmldoc.createElement("name");
			name.setTextContent("小儿子");
			son.appendChild(name);

			Element age = xmldoc.createElement("name");
			age.setTextContent("0");
			son.appendChild(age);

			root.appendChild(son);
			// 保存
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File(
					xmlPath)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Node selectSingleNode(String express, Element source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath
					.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		getFamilyMemebers();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// modifySon();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// getFamilyMemebers();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// discardSon();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// getFamilyMemebers();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// createSon();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// getFamilyMemebers();
	}
}