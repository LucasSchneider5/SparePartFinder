import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyWeb {
	
	JFrame frame = new JFrame();
	JLabel jlabel_lager = new JLabel("");
	JLabel jlabel_preis = new JLabel("");
	JLabel jlabel_verf�gbarkeit = new JLabel("");
	String teilenummer;
	JTextField teil_nummer;
	String Teile_File;
	String teil_gefunden;
	String preis;
	String lagerort;
	String verf�gbarkeit;
    Button button = new Button();
	
	public MyWeb() throws IOException {
		
		readFile();
		
		//frame.setUndecorated(true);
		
	    JPanel mainPanel = new JPanel();
	    JPanel secondPanel = new JPanel();
	    JPanel rightPanel = new JPanel(new GridLayout(5, 1));
	    JPanel lowerPanel = new JPanel(new GridLayout(3, 2));
	    JPanel lowerPanel2 = new JPanel(new GridLayout(5, 2));
	    JPanel lowerPanel3 = new JPanel(new GridLayout(5, 2));
	    JPanel lowerPanel4 = new JPanel(new GridLayout(5, 2));
	    Browser browser = new Browser();
	    BrowserView browserView = new BrowserView(browser);
	    teil_nummer = new JTextField("Ersatzteilnummer:", 20);
	    Button teil_suchen_button = new Button("Ersatzteil suchen");
	    JLabel info_text = new JLabel("Bitte geben Sie die Ersatzteilnummer ein");
	    Font font1 = new Font("SansSerif", Font.BOLD, 20);
	    Font font2 = new Font("SansSerif", Font.BOLD, 40);
		JLabel dummy1 = new JLabel("");
		JLabel dummy2 = new JLabel("");
		JLabel dummy3 = new JLabel("");
		JLabel dummy4 = new JLabel("");
		JLabel dummy5 = new JLabel("");
		JLabel dummy6 = new JLabel("");
		JLabel dummy7 = new JLabel("");
		JLabel dummy8 = new JLabel("");
		JLabel dummy9 = new JLabel("");
		JLabel dummy10 = new JLabel("");
		JLabel dummy11 = new JLabel("");
		JLabel dummy12 = new JLabel("");
		JLabel dummy13 = new JLabel("");
		JLabel dummy14 = new JLabel("");
		JLabel dummy15 = new JLabel("");
		JLabel dummy16 = new JLabel("");
		JLabel dummy17 = new JLabel("");
		JLabel dummy18 = new JLabel("");
		JLabel dummy19 = new JLabel("");
		JLabel dummy20 = new JLabel("");
		
	    //frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setLocationRelativeTo(null);	    
	    mainPanel.setLayout(new BorderLayout());
	    frame.add(mainPanel); 
	    mainPanel.add(browserView, BorderLayout.CENTER);
	    secondPanel.setLayout(new BorderLayout());  
	    mainPanel.add(secondPanel, BorderLayout.EAST);
	    secondPanel.add(rightPanel, BorderLayout.CENTER);
	    button.setPreferredSize(new Dimension(960, 1));
	    secondPanel.add(button, BorderLayout.NORTH);
	    rightPanel.add(info_text);
	    info_text.setHorizontalAlignment(SwingConstants.CENTER);
	    info_text.setFont(font2);
	    teil_suchen_button.setFont(font1);
	    rightPanel.add(lowerPanel);
	    rightPanel.add(lowerPanel2);
	    rightPanel.add(lowerPanel3);
	    rightPanel.add(lowerPanel4);
	    lowerPanel.add(teil_nummer);
	    lowerPanel.add(teil_suchen_button);
	    lowerPanel.add(dummy19);
	    lowerPanel.add(dummy20);
	    lowerPanel2.add(jlabel_verf�gbarkeit);
	    lowerPanel2.add(dummy2);
		lowerPanel2.add(dummy1);
		lowerPanel2.add(dummy5);
		lowerPanel2.add(dummy3);
		lowerPanel2.add(dummy6);
		lowerPanel2.add(jlabel_preis);
		lowerPanel3.add(dummy4);
	    lowerPanel3.add(dummy8);
		lowerPanel3.add(jlabel_lager);
		lowerPanel3.add(dummy10);
		lowerPanel3.add(dummy9);
		lowerPanel3.add(dummy11);
		lowerPanel3.add(dummy7);
		lowerPanel4.add(dummy12);
	    lowerPanel4.add(dummy14);
		lowerPanel4.add(dummy13);
		lowerPanel4.add(dummy16);
		lowerPanel4.add(dummy17);
		lowerPanel4.add(dummy18);
		lowerPanel4.add(dummy15);
	    teil_suchen_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		teilenummer = teil_nummer.getText();
	    		teil_suchen();
	    		jlabel_lager.setFont(font1);
	    		jlabel_preis.setFont(font1);
	    		jlabel_verf�gbarkeit.setFont(font1);
	        }
	    });
	    browser.loadURL("https://www.yamaha-motor.eu/de/de/services/ersatzteilkatalog/#secondary-nav-check");
	    frame.setVisible(true);
	    teil_nummer.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		teil_nummer.setText("");
	    		
	        }
	    });
		browser.setPopupHandler(new com.teamdev.jxbrowser.chromium.PopupHandler() {
			public com.teamdev.jxbrowser.chromium.PopupContainer handlePopup(com.teamdev.jxbrowser.chromium.PopupParams params) {
		        return new com.teamdev.jxbrowser.chromium.PopupContainer() {
		            public void insertBrowser(com.teamdev.jxbrowser.chromium.Browser popupBrowser, Rectangle initialBounds) {
		                com.teamdev.jxbrowser.chromium.swing.BrowserView popupBrowserView = new com.teamdev.jxbrowser.chromium.swing.BrowserView(popupBrowser);
		                frame.getContentPane().removeAll();
		                frame.setLayout(new BorderLayout());
		                frame.getContentPane().add(popupBrowserView, BorderLayout.CENTER);
		                frame.add(secondPanel, BorderLayout.EAST);
		                frame.getContentPane().validate();
		                frame.getContentPane().repaint();
		            }
		        };
			}
		});
	}
	
	public void setBeschreibung() {
		
	}
	
	public void BestellungVerf�gbar() {
		
	}
	
	public void BestellungNichtVerf�gbar() {
		
	}
	
	public void getPreis() {
		String tokens[] = teil_gefunden.split(";");
		preis = tokens[8];
		jlabel_preis.setText("Preis: " + preis + " �");
	}
	
	public void getLagerort() {
		String tokens[] = teil_gefunden.split(";");
		lagerort = tokens[35];
		if(lagerort.length() == 4) {
			lagerort = lagerort.substring(0, 2) + " - " + lagerort.substring(2, 3) + " - " + lagerort.substring(3, lagerort.length());
			jlabel_lager.setText("Lagerort: " + lagerort);
		}
		else if(lagerort.length() == 3) {
			lagerort = lagerort.substring(0, 1) + " - " + lagerort.substring(1, 2) + " - " + lagerort.substring(2, lagerort.length());
			jlabel_lager.setText("Lagerort: " + lagerort);
		}
		else {
			jlabel_lager.setText("Lagerort: " + lagerort);
		}
	}
	
	public void teil_suchen() {
		if(Teile_File.contains(teilenummer)) {
			teil_gefunden = Teile_File.substring(Teile_File.indexOf(teilenummer));
			verf�gbarkeit = "Auf Lager";
			jlabel_verf�gbarkeit.setText("Verf�gbarkeit: " + verf�gbarkeit);
			jlabel_verf�gbarkeit.setForeground(Color.GREEN);
    		getPreis();
    		getLagerort();
		}
		else {
			verf�gbarkeit = "Nicht auf Lager";
			jlabel_verf�gbarkeit.setText("Verf�gbarkeit: " + verf�gbarkeit);
			jlabel_verf�gbarkeit.setForeground(Color.RED);
			jlabel_preis.setText("");
			jlabel_lager.setText("");
		}
	}
	
	public void readFile() throws IOException {
		Scanner scanner = new Scanner(new File("Teile.txt"));
		Teile_File = scanner.useDelimiter("\\A").next();
		scanner.close();
	}
	
	public static void main(String[] args) throws IOException {
		MyWeb start = new MyWeb();
	}
}

/*
 * Beschreibung
 * Neustarten nach bestimmter Zeit
 * Ausdrucken (Formular bei nicht verf�gbar)
 */