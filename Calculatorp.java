package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatorp implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myFont = new Font("Times New Roman", Font.BOLD, 30);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculatorp() {

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
        ImageIcon image = new ImageIcon("C://Users//garim//OneDrive//Desktop//java//Intermediate//hello-kitty-png-icon-16777.png");
        frame.setIconImage(image.getImage());

		JLabel background = new JLabel(new ImageIcon("C:\\Users\\garim\\OneDrive\\Desktop\\java\\calculator\\coquette.jpeg"));
		background.setBounds(0, 0, 420, 550);
		frame.setContentPane(background);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		frame.add(textfield);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");

		JButton[] functionButtonsArr = {addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton};
		for (JButton button : functionButtonsArr) {
			button.addActionListener(this);
			button.setFont(myFont);
			button.setFocusable(false);
			button.setBackground(Color.PINK);
			button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.PINK);
			numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}

		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setOpaque(false);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculatorp calc = new Calculatorp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			switch (operator) {
				case '+' -> result = num1 + num2;
				case '-' -> result = num1 - num2;
				case '*' -> result = num1 * num2;
				case '/' -> result = num1 / num2;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText(string.substring(0, string.length() - 1));
		}
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
	}
}
