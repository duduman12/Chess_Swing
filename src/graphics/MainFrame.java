package graphics;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import dao.Console;
import dao.FileManager;
import dao.Menu;
import graphics.piezas.Piece.Color;

public class MainFrame extends JFrame {

	private JSplitPane splitPane;
	private JButton btnTestChess;
	private JButton btnCloseChess;
	private FileManager fm;
	private Console con;
	private Menu menu;
	
	public MainFrame() {
		setSize(900, 1200);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setFocusable(false);	
		splitPane = new JSplitPane(1);
		fm = new FileManager();		
		initLogin();	
	}
	
	public void initLogin () {
		setTitle("Login");	
		splitPane.setLeftComponent(fm);
		splitPane.setDividerLocation(1);
		splitPane.setDividerSize(1);
		validate();
		add(splitPane);
		fm.getLogginBtn();
	}
	
	public void correctLogin () {
		fm.setVisible(false);
		con = new Console();
		menu = new Menu();
		
		setTitle("Menu");		
		splitPane.setLeftComponent(menu);
		splitPane.setRightComponent(con);
		splitPane.setDividerLocation(0.7);
		splitPane.setDividerSize(1);
		validate();
		add(splitPane);
	}
	
	public JButton getBtnTestChess() {
		return this.btnTestChess;
	}
	
	public JButton getBtnCloseChess() {
		return this.btnCloseChess;
	}
	
	public FileManager getFileManager() {
		return this.fm;
	}
	
	public JSplitPane getSplitPane() {
		return splitPane;
	}
	
	public Menu getMenu() {
		return this.menu;
	}
	
	public Console getConsole() {
		return this.con;
	}
	

}
