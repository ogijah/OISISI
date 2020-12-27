package gui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.TabelaProfesora;
import view.TabelaStudenata;

//import gui.GlavniProzor.TimerThread;


public class GlavniProzor extends JFrame{
	
	protected TimerThread timerThread;

	int indeks = 0;
	/**
	 * 
	 */
	public int getIndeks() {
		return indeks;
	}
	
	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7502172470744971352L;

	public GlavniProzor() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ekran = kit.getScreenSize();
		
		//dimenzije ektrana
		int visina = ekran.height;
		int sirina = ekran.width;
		
		//postavljanje dimenzija prozora
		setSize(sirina*3/4, visina*3/4);
		
		//naslov
		setTitle("Studentska sluzba");
		
		//zatvaranje prozora
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//centriranje
		setLocationRelativeTo(null);
		
		//dodajemo meni
		TrakaSaMenijima menu = new TrakaSaMenijima();
		this.setJMenuBar(menu);
		

		//STATUSNA TRAKA
		
		/* PREUZETO SA INTERNETA */
		
		/* https://stackoverflow.com/questions/13366780/how-to-add-real-time-date-and-time-into-a-jframe-component-e-g-status-bar */
		
		//Pravljenje panela
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel.setPreferredSize(new Dimension(sirina, 30));
		statusPanel.setLayout(new BorderLayout(50, 50)); //razmak izmedju komponenti na panelu
		
		//tekst: Studentska sluzba
		JLabel statusLabel1 = new JLabel();
		statusLabel1.setText("Studentska sluzba");
		statusPanel.add(statusLabel1,BorderLayout.WEST);
		
		JLabel DateTimeLabel = new JLabel();
		DateTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		statusPanel.add(DateTimeLabel, BorderLayout.EAST);
        
        timerThread = new TimerThread(DateTimeLabel);
        timerThread.start();
		
		add(statusPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		
		TrakaSaAlatkama traka = new TrakaSaAlatkama();
        traka.setBorder(new BevelBorder(BevelBorder.LOWERED));
        traka.setPreferredSize(new Dimension(sirina,40));;
		add(traka, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		JTabbedPane tabovi = new JTabbedPane();
		tabovi.add("Student",TabelaStudenata.getInstance());
		
		tabovi.add("Profesor",TabelaProfesora.getInstance());
		
		JLabel label3 = new JLabel();
		label3.setText("TODO:Prikaz entiteta sintema");
		tabovi.addTab("Predmeti", label3);
		
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        setIndeks(index);
		        
		      }
	   };

   
	    panel.add(tabovi);
	    tabovi.addChangeListener(changeListener);
		add(panel,BorderLayout.CENTER);
	}
	
	private static GlavniProzor instance = null;

	public static GlavniProzor getInstance() {
		if (instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
	}
	
	
	
	public void exitProcedure() {
        timerThread.setRunning(false);
        System.exit(0);
    }
	
	public class TimerThread extends Thread {

        protected boolean isRunning;

        protected JLabel DateTimeLabel;

        protected SimpleDateFormat DateTimeFormat = new SimpleDateFormat("HH:mm ' ' dd.MM.yyyy.");

        public TimerThread(JLabel DateTimeLabel) {
            this.DateTimeLabel = DateTimeLabel;
            this.isRunning = true;
        }

        @Override
        public void run() {
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Calendar currentCalendar = Calendar.getInstance();
                        java.util.Date currentTime = currentCalendar.getTime();
                        DateTimeLabel.setText(DateTimeFormat.format(currentTime));
                        
                    }
                });

                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                }
            }
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }
        

    }
}
