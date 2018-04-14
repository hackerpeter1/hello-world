import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class programme{
	public static void main(String[] args) {
		new easyVersion();
		//System.out.println("test");
	}
}

public class easyVersion extends JFrame {
	JPanel panel;
	JTextField inputField1;
	JTextField inputField2;
	JButton addButton;
	JButton subtractButton;
	JButton multiplyButton;
	JButton divideButton;
	JButton okButton;
	String currentoperator;
	Integer resultnum;
	public easyVersion() {
		panel = new JPanel(new GridLayout(2,5));
		inputField1 = new JTextField(4);
		inputField2 = new JTextField(4);
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		okButton = new JButton("OK");
		JLabel temp1 = new JLabel("",JLabel.CENTER);
		JLabel temp2 = new JLabel("=",JLabel.CENTER);
		JLabel resultLabel = new JLabel("",JLabel.CENTER);
		panel.add(inputField1);
		panel.add(temp1);
		panel.add(inputField2);
		panel.add(temp2);
		panel.add(resultLabel);
		panel.add(addButton);
		panel.add(subtractButton);
		panel.add(multiplyButton);
		panel.add(divideButton);
		panel.add(okButton);		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentoperator = "+";
				temp1.setText(currentoperator);
			}
		});
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentoperator = "-";
				temp1.setText(currentoperator);
			}
		});
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentoperator = "*";
				temp1.setText(currentoperator);
			}
		});
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentoperator = "/";
				temp1.setText(currentoperator);
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(currentoperator) {
					case "+":
						int a = Integer.parseInt(inputField1.getText());
						int b = Integer.parseInt(inputField2.getText());
						resultnum = a + b;
						resultLabel.setText(resultnum.toString());
						break;
					case "-":
						a = Integer.parseInt(inputField1.getText());
						b = Integer.parseInt(inputField2.getText());
						resultnum = a - b;
						resultLabel.setText(resultnum.toString());
						break;
					case "*":
						a = Integer.parseInt(inputField1.getText());
						b = Integer.parseInt(inputField2.getText());
						resultnum = a * b;
						resultLabel.setText(resultnum.toString());
						break;
					case "/":
						a = Integer.parseInt(inputField1.getText());
						b = Integer.parseInt(inputField2.getText());
						resultnum = a / b;
						resultLabel.setText(resultnum.toString());
						break;
				}
			}
		});
		//------------放置窗口，添加窗口信息-----------------------------
		this.add(panel);
		this.setTitle("Caculator");
		this.setSize(300, 100);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		
	}
}
