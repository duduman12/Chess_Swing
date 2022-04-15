package dao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.SwingConstants;

public class Menu extends JPanel{
	
	private JTextField text1, text2, text3;
	private DefaultTableModel model;
	private JScrollPane sp;
	private JButton launchChess;
	private JButton closeChess;
	private JButton exit;
	private JButton logout;
	private JTable table;
	private JScrollPane scrollPane;
	
	public Menu () {
		setLayout(null);
		final Object[] columns = {"User", "Action", "Date"};
		String [][] data = null;
		model = new DefaultTableModel(columns, 0);
		JTable table = new JTable(model);
		//JTable table = new JTable(rows,3);
		
		closeChess = new JButton("CLOSE CHESS");
        closeChess.setBounds(360, 345, 220, 60);
		add(closeChess);
		closeChess.setVisible(false);
		
		exit = new JButton("EXIT");
		exit.setBounds(360, 350, 220, 60);
		add(exit);
		
		launchChess = new JButton("LAUNCH CHESS");
		launchChess.setBounds(80, 350, 220, 60);
		add(launchChess);

		logout = new JButton("LOGGOUT");
		logout.setBounds(360, 450, 220, 60);
		add(logout);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 30, 550, 300);
		add(scrollPane);
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	public DefaultTableModel getModelTable () {
		return this.model;
	}

	public JButton getLaunchChess() {
		return launchChess;
	}

	public JButton getExit() {
		return exit;
	}

	public JButton getLogout() {
		return logout;
	}

	public JButton getCloseChess() {
		return closeChess;
	}
	
	

	
	
}
