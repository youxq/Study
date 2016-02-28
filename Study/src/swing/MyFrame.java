package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MyFrame extends JFrame {
	// 创建新类
	public static void main(String args[]) {
		new MyFrame();// 实例化MyJDialog类对象
	}

	public MyFrame() {
		Container container = getContentPane();// 创建一个容器
		container.setLayout(null);
		JLabel jl = new JLabel("这是一个JFrame窗体");// 在窗体中设置标签
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);
		JButton b1 = new JButton("弹出对话框");
		b1.setBounds(10, 10, 100, 21);
		b1.addActionListener(new ActionListener() {// 为按钮添加鼠标单击事件
			public void actionPerformed(ActionEvent e) {
				new MyJDialog(MyFrame.this).setVisible(true);// 使MyJDialog窗体可见
			}
		});
		container.add(b1);
		container.add(b1);
		setSize(200, 200);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}

class MyJDialog extends JDialog {
	public MyJDialog(MyFrame frame) {
		super(frame, "第一个JDialog窗体", true);// 实例化一个JDialog类对象，指定对话框的父窗体、标题、类型
		Container container = getContentPane();// 创建一个容器
		container.add(new JLabel("这是一个对话框"));
		setBounds(120, 120, 100, 100);
	}
}