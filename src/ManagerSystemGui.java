
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

public class ManagerSystemGui extends JFrame {
	static Map<Integer, String> timeMap = new HashMap<Integer, String>();

	JPanel controlPan = new JPanel();
	JPanel Pan1 = new JPanel();
	JPanel Pan2 = new JPanel();
	JLabel label1 = new JLabel("111");
	JLabel label2 = new JLabel("222");
	JButton scheduleBtn = new JButton("排賽程");
	JButton changeBtn = new JButton("更改賽程");
	JButton searchBtn = new JButton("查詢賽程");
	JButton cleanBtn = new JButton("清除");
	JButton addBtn = new JButton("新增");
	JButton deleteBtn = new JButton("刪除");
	JTextField curseTF = new JTextField(10);
	ButtonGroup controlGroup;
	DefaultListModel<String> menuModel = new DefaultListModel<String>();


	JTable list = new JTable();
	private final JList<String> menuJList = new JList<String>(menuModel);

	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel scrollPanel = new JPanel();

	private JButton okButton;

	private JButton cancelBotton;

	/**
	 * @throws IOException
	 * 
	 */
	ManagerSystemGui() throws IOException {
		label1.setForeground(Color.WHITE);
		label2.setForeground(Color.WHITE);
		Pan1.add(label1);
		Pan2.add(label2);
		menuJList.setForeground(Color.WHITE);
		menuJList.setBackground(new Color(51, 51, 51));
		menuJList.setSelectionBackground(new Color(51, 153, 255));
		menuJList.setSelectionForeground(Color.WHITE);
		menuJList.addMouseListener(new click());
		controlPan.add(menuJList);
		menuModel.addElement("   1111111   ");
		menuModel.addElement("   2222222   ");
		//controlPan.setBorder(BorderFactory.createTitledBorder("分組框")); //設置面板邊框，實現分組框的效果，此句代碼為關鍵代碼
		//controlPan.setBorder(BorderFactory.createLineBorder(Color.WHITE));//設置面板邊框顏色
		getContentPane().add(controlPan, BorderLayout.WEST);
		getContentPane().add(Pan1,BorderLayout.CENTER);
	}

	public static void main(String[] args) throws IOException {
		UIManager.put("OptionPane.background",new Color(51, 51, 51));
		UIManager.put("Panel.background",new Color(51, 51, 51));
		UIManager.put("OptionPane.okButtonbackground",Color.BLUE);
		UIManager.put("Panel.Text",Color.WHITE);
		setUIFont(new javax.swing.plaf.FontUIResource("Microsoft JhengHei UI", 4, 18));
		ManagerSystemGui s = new ManagerSystemGui();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(1024, 768);
		s.setTitle("VOD Sales Management System");
		s.setVisible(true);
	}

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	class click implements MouseListener {
		public void mouseClicked(MouseEvent evt) {
			JList list = (JList) evt.getSource();
			switch (evt.getClickCount()) {
			case 1:
				int index = list.locationToIndex(evt.getPoint());
				switch (index){
				case 0:
					Pan1.removeAll();
					Pan1.add(label1);
					Pan1.updateUI();
					break;
				case 1:
					Pan1.removeAll();
					Pan1.add(label2);
					Pan1.updateUI();
					break;
				}
				
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "<html><font color=white>Hello</font><p></html>", "Message", JFrame.EXIT_ON_CLOSE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "World", "Message", JFrame.EXIT_ON_CLOSE);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
