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
	// ��������
	public static void main(String args[]) {
		new MyFrame();// ʵ����MyJDialog�����
	}

	public MyFrame() {
		Container container = getContentPane();// ����һ������
		container.setLayout(null);
		JLabel jl = new JLabel("����һ��JFrame����");// �ڴ��������ñ�ǩ
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);
		JButton b1 = new JButton("�����Ի���");
		b1.setBounds(10, 10, 100, 21);
		b1.addActionListener(new ActionListener() {// Ϊ��ť�����굥���¼�
			public void actionPerformed(ActionEvent e) {
				new MyJDialog(MyFrame.this).setVisible(true);// ʹMyJDialog����ɼ�
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
		super(frame, "��һ��JDialog����", true);// ʵ����һ��JDialog�����ָ���Ի���ĸ����塢���⡢����
		Container container = getContentPane();// ����һ������
		container.add(new JLabel("����һ���Ի���"));
		setBounds(120, 120, 100, 100);
	}
}