package dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import graphics.piezas.Piece.Color;

public class FileManager extends JPanel{

	private JTextField textField;
	private JLabel textLoggin;
	private JPasswordField password;
	private JButton closeBtn;
	private JButton logginBtn;
	
	public FileManager() {
		setLayout(null);
		setBounds(0,0,700,300);
		
		closeBtn = new JButton("SALIR");
		closeBtn.setBounds(320, 260, 300, 39);
		add(closeBtn);
		
		logginBtn = new JButton("LOGIN");
		logginBtn.setBounds(320, 200, 300, 39);
		add(logginBtn);
		
		textField = new JTextField();
		textField.setBounds(320, 60, 300, 45);
		add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(320, 115, 300, 45);
		add(password);
		
		textLoggin = new JLabel();
		textLoggin.setBounds(320, 189, 250, 33);
		add(textLoggin);
		setVisible(true);
	}
		
		
	public JTextField getTextField() {
		return textField;
	}

	public JLabel getTextLoggin() {
		return textLoggin;
	}

	public String getPassword () {
		return String.valueOf(password.getPassword());
	}

	private void printText(String text) {
		textLoggin.setText(text);
	}
		
	public JButton getCloseBtn () {
		return closeBtn;
	}
		
	public JButton getLogginBtn () {
		return logginBtn;
	}
		
}
