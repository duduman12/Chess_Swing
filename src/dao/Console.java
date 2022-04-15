package dao;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Console extends JPanel{
	
	private JLabel lblConsola;
	private JScrollPane sp;
	private JTextArea textArea_1;
	
	public Console () {
		setLayout(null);
		setBounds(0,0,440,498);
		
		setBackground(java.awt.Color.black);
		
		lblConsola = new JLabel("CONSOLA");
		lblConsola.setBounds(38, 35, 70, 15);
		lblConsola.setForeground(Color.WHITE);
		add(lblConsola);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 60, 357, 406);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		add(scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		textArea_1.setBackground(java.awt.Color.black);
		textArea_1.setEditable(false);
	
	}

	public JTextArea getTextArea() {
		return textArea_1;
	}

	public JLabel getLblConsole() {
		return lblConsola;
	}

	public JScrollPane getSp() {
		return sp;
	}
}
