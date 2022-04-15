package manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dao.FileManager;
import dao.Reader;
import dao.Writter;
import graphics.MainFrame;
import graphics.piezas.Piece.Color;
import graphics.ui.PreferencesPanel;
import graphics.util.GameModel;
import graphics.util.Preferences;

public class WindowManager {
	private static WindowManager instance;
	private static MainFrame frame;
	private static PreferencesPanel chess;
    private static PreferencesPanel preferencesFrame;
    private static boolean inGame;
    private static GameModel gameModel;
    private static Preferences preferences;
    private String data[][];
    private Set <String> actions;
    private int row;
    private boolean gameStarted;
    private String action;
    private String user;
    private Writter w;
    private Reader r;
    
    //TODO: aqu� van las variables globales necesarias
	
	public static WindowManager getInstance() {
		if (instance == null) {
			instance = new WindowManager();
		}
		return instance;
	}
	//TODO HACER LO DEL HASH SET
	private WindowManager () {
		//TODO: Este file manager te permitir� manipular ficheros de usu/pass y de inicio de sesiones
		frame = new MainFrame();
		frame.setVisible(true);
		w = new Writter(new File("files/sessions.txt"));
		r = new Reader (new File("files/sessions.txt"));
		gameStarted = false;
		row = 0;
		actions = new HashSet<String>();
	}

	//M�todo necesario para el ajedrez
    public static void startGame() {
        inGame = true;
        gameModel = new GameModel();
    }
	
	//M�todo necesario para el ajedrez
    public static Preferences getPreferences() {
        return preferences;
    }

    //M�todo necesario para el ajedrez
    public static PreferencesPanel getPreferencesFrame() {
        return preferencesFrame;
    }
    
    //M�todo necesario para el ajedrez
    public static boolean isInGame() {
        return inGame;
    }
    
    public void inicialPanel() {
    	
    	frame.getFileManager().getLogginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (logginClicked()) {
					frame.correctLogin();
					addConsoleLine("\nUsuario Correcto");
					addConsoleLine("\nPanel: " + user);
					frame.getMenu().getLaunchChess().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							launchChess();
							addConsoleLine("\n<--- NUEVA PARTIDA --->");
							gameStarted = true;
							frame.getMenu().getCloseChess().addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									finalizarPartidaButton();
									registerNewAction();
									gameStarted = false;
								}
							});
						}
					});
					
					frame.getMenu().getLogout().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.getMenu().setVisible(false);
							frame.getConsole().setVisible(false);
							frame.initLogin();
							frame.getFileManager().setVisible(true);
							finalizarPartidaButton();
							action = "Cerrar Sesion";
							registerNewAction();
						}
					});
					
					frame.getMenu().getExit().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							addConsoleLine("\nSALIR");
							action = "Salir";
							registerNewAction();
							readActions();
							w.closeWriter();
							System.exit(0);
						}
					});
				}
 			}
		});
    	
    	frame.getFileManager().getCloseBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
    	
	}   
    
    //TODO: Aqu� van las funciones necesarias
    //Recuerda que se necesita aplicar funcinalidad a los botones en esta secci�n
	
    public boolean logginClicked () {
		Scanner br = null;
		try {
			br = new Scanner(new File("files/loggin.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (br.hasNext()) {
			String line = br.nextLine();
			String[] usus = line.split(" ");
			user = usus[0];
			System.out.println("usu: " + usus[0] + " con pasw: " + usus[1]);
			
			if (frame.getFileManager().getTextField().getText().equals(usus[0]) && frame.getFileManager().getPassword().equals(usus[1])) {
				System.out.println("Correcto");
				frame.getFileManager().setVisible(false);
				return true;
			}
		}
		System.out.println("Credenciales Incorrectas");
		return false;
	}
    
    private void launchMenu () {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }
    //TODO: este m�todo cierra el JDialog del ajedrez
	private void finalizarPartidaButton() {
		if (gameStarted) {
			chess.endChess();
			gameModel.getGameFrame().setVisible(false);
		}
		frame.getMenu().getLogout().setVisible(true);
		frame.getMenu().getExit().setVisible(true);
		frame.getMenu().getLaunchChess().setVisible(true);
		frame.getMenu().getLaunchChess().setBounds(80, 350, 220, 60);
		frame.getMenu().getLogout().setBounds(360, 450, 220, 60);
		frame.getMenu().getCloseChess().setVisible(false);
		addConsoleLine("\n<--- FIN DE LA PARTIDA --->");
		action = "Finalizar partida";
		readActions();
	}
	
	//TODO: este m�todo inicializa el JDialog del chess
	private void launchChess() {
		frame.getMenu().getLaunchChess().setVisible(false);
		frame.getMenu().getLogout().setBounds(80, 350, 220, 60);
		frame.getMenu().getExit().setVisible(false);
		frame.getMenu().getCloseChess().setVisible(true);
        inGame = false;
        preferences = new Preferences();
        chess = new PreferencesPanel();
        action = "Iniciar partida";
        registerNewAction();
		readActions();
    }
	
	private void addConsoleLine (String line) {
		frame.getConsole().getTextArea().append(line);
		frame.getConsole().getTextArea().setForeground(java.awt.Color.WHITE);
	}
	
	private void registerNewAction() {
		w.write(user + " " + action + " " + java.time.LocalDate.now() + "\n");
	}
	
	private void readActions () {
		String line = r.read();
		if (line != null) {
			String[] usus = line.split(" ");
			System.out.println("Userrrrr:" + usus[1]);
			frame.getMenu().getModelTable().insertRow(row, new Object[] {usus[0],usus[1],usus[2]});
		}
		row++;
	}
	
	private void addValueTable () {		
		frame.getMenu().getModelTable().addRow(data[data.length - 1]);
	}

}
