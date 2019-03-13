import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimerTask;

public class MyWeb {
	
// Some global variables 
	JFrame frame = new JFrame();
	JLabel jlabel_lager = new JLabel("");
	JLabel jlabel_preis = new JLabel("");
	JLabel jlabel_verfügbarkeit = new JLabel("");
	JLabel jlabel_name = new JLabel("");
	String teilenummer;
	JTextField teil_nummer;
	String Teile_File;
	String teil_gefunden;
	String name;
	String preis;
	String lagerort;
	String verfügbarkeit;
    Button button = new Button();
	
// Constructor = Swing
	public MyWeb() throws IOException {

// Read Database-File
		readFile();
		
		//frame.setUndecorated(true);
		
// Create swing objects
	    JPanel mainPanel = new JPanel();
	    JPanel secondPanel = new JPanel();
	    JPanel rightPanel = new JPanel(new GridLayout(5, 1));
	    JPanel rechtsPanel1 = new JPanel(new GridLayout(3, 1));
	    JPanel rechtsPanel2 = new JPanel(new GridLayout(5, 2));
	    JPanel rechtsPanel3 = new JPanel(new GridLayout(5, 2));
	    JPanel rechtsPanel4 = new JPanel(new GridLayout(3, 2));
	    JPanel rechtsPanel5 = new JPanel(new GridLayout(5, 2));
	    Browser browser = new Browser();
	    BrowserView browserView = new BrowserView(browser);
	    teil_nummer = new JTextField("Ersatzteilnummer:", 20);
	    Button teil_suchen_button = new Button("Ersatzteil suchen");
	    JLabel Achtung = new JLabel("Achtung: Nach 5 Minuten wird aus Sicherheitsgründen das Programm automatisch neugestartet !");
	    JLabel ersteZeile = new JLabel("Verfügbarkeit und Preis von Ersatzteilen überprüfen");
	    JLabel Beschreibung = new JLabel("Beschreibung:");
	    JLabel Beachten = new JLabel("(Bindestriche sowie Groß-und Kleinschreibung beachten !)");
	    JLabel eins = new JLabel("1. Auf 'Ersatzteilkatalog' klicken");
	    JLabel zwei = new JLabel("2. Auf 'Ich stimme zu' klicken");
	    JLabel drei = new JLabel("3. Gewünschte Kategorie auswählen");
	    JLabel vier = new JLabel("4. Informationen zum Fahrzeug eingeben");
	    JLabel fünf = new JLabel("5. Auf 'Suchen' klicken");
	    JLabel sechs = new JLabel("6. Fahrzeug auswählen");
	    JLabel sieben = new JLabel("7. Gewünschtes Ersatzteil suchen");
	    JLabel acht = new JLabel("8. Ersatzteilnummer in das Suchfeld eingeben");
	    JLabel neun = new JLabel("9. Auf den Knop 'Ersatzteil suchen' klicken");
	    
// Fonts
	    Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
	    fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    Font font1 = new Font("SansSerif", Font.BOLD, 20);
	    Font font2 = new Font("SansSerif", Font.BOLD, 15);
	    Font font3 = new Font("SansSerif", Font.BOLD, 30).deriveFont(fontAttributes);;
	    Font font4 = new Font("SansSerif", Font.BOLD, 20).deriveFont(fontAttributes);
	    
// Please ignore all these dummies
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
		
// Default swing stuff
	    //frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setLocationRelativeTo(null);	    
	    mainPanel.setLayout(new BorderLayout());
	    
// Add JPanel to JFrame/JPanel
	    frame.add(mainPanel); 
	    mainPanel.add(browserView, BorderLayout.CENTER);
	    secondPanel.setLayout(new BorderLayout());  
	    mainPanel.add(secondPanel, BorderLayout.EAST);
	    secondPanel.add(rightPanel, BorderLayout.CENTER);
	    button.setPreferredSize(new Dimension(960, 1));
	    secondPanel.add(button, BorderLayout.NORTH);
	    
// Set font, color and alignment of JLabel
	    eins.setFont(font2);
	    zwei.setFont(font2);
	    drei.setFont(font2);
	    vier.setFont(font2);
	    fünf.setFont(font2);
	    sechs.setFont(font2);
	    sieben.setFont(font2);
	    acht.setFont(font2);
	    neun.setFont(font2);
	    teil_suchen_button.setFont(font1);
	    Achtung.setForeground(Color.RED);
	    ersteZeile.setForeground(Color.RED);
	    Achtung.setFont(font1);
	    ersteZeile.setFont(font3);
	    Achtung.setHorizontalAlignment(JLabel.CENTER);
	    ersteZeile.setHorizontalAlignment(JLabel.CENTER);
	    Beschreibung.setFont(font4);
	    Beachten.setFont(font2);
	    Beachten.setForeground(Color.RED);
	    
// Add objects to frame/panel
// Right Panel
	    rightPanel.add(rechtsPanel1);
	    rightPanel.add(rechtsPanel2);
	    rightPanel.add(rechtsPanel3);
	    rightPanel.add(rechtsPanel4);
	    rightPanel.add(rechtsPanel5);
	    
// Right Panel 1
	    rechtsPanel1.add(ersteZeile);
	    rechtsPanel1.add(Achtung);
	    rechtsPanel1.add(Beschreibung);
	    
// Right Panel 2
	    rechtsPanel2.add(eins);
	    rechtsPanel2.add(neun);
	    rechtsPanel2.add(zwei);
	    rechtsPanel2.add(dummy1);
	    rechtsPanel2.add(drei);
	    rechtsPanel2.add(dummy2);
	    rechtsPanel2.add(vier);
	    rechtsPanel2.add(dummy3);
	    rechtsPanel2.add(fünf);
	    rechtsPanel2.add(dummy4);
	    
// Right Panel 3
	    rechtsPanel3.add(sechs);
	    rechtsPanel3.add(dummy5);
	    rechtsPanel3.add(sieben);
	    rechtsPanel3.add(dummy6);
	    rechtsPanel3.add(acht);
	    rechtsPanel3.add(dummy7);
	    rechtsPanel3.add(Beachten);
		
// Right Panel 4
	    rechtsPanel4.add(dummy8);
	    rechtsPanel4.add(dummy9);
	    rechtsPanel4.add(teil_nummer);
	    rechtsPanel4.add(teil_suchen_button);
		
// Right Panel 5
	    rechtsPanel5.add(jlabel_verfügbarkeit);
	    rechtsPanel5.add(dummy10);
	    rechtsPanel5.add(jlabel_name);
	    rechtsPanel5.add(dummy11);
	    rechtsPanel5.add(jlabel_preis);
	    rechtsPanel5.add(dummy12);
	    rechtsPanel5.add(jlabel_lager);
		
// Search file if user presses the button
	    teil_suchen_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		teilenummer = teil_nummer.getText();
	    		teil_suchen();
	    		jlabel_lager.setFont(font1);
	    		jlabel_preis.setFont(font1);
	    		jlabel_verfügbarkeit.setFont(font1);
	    		jlabel_name.setFont(font1);
	        }
	    });
	    
// Load URL
	    browser.loadURL("https://www.yamaha-motor.eu/de/de/services/ersatzteilkatalog/#secondary-nav-check");
	    frame.setVisible(true);
	    
// Delete text of JTextField if user clicks on it
	    teil_nummer.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		teil_nummer.setText("");
	    		
	        }
	    });
	    
// Update Browser if clicked on link (used to open Pop-up)
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
		
// Restart program after 5 min (300000 ms = 5 min)
		new java.util.Timer().schedule(new TimerTask() {
			public void run() {
				frame.dispose();
				try {
					MyWeb test = new MyWeb();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 300000);
	}
	
// Get name
	public void getName() {
		String tokens[] = teil_gefunden.split(";");
		name = tokens[2];
		jlabel_name.setText("Bezeichnung: " + name);
	}
	
// Get price
	public void getPreis() {
		String tokens[] = teil_gefunden.split(";");
		preis = tokens[8];
		jlabel_preis.setText("Preis: " + preis + " €");
	}
	
// Get location
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
	
// Search spare parts
	public void teil_suchen() {
		if(Teile_File.contains(teilenummer)) {
			teil_gefunden = Teile_File.substring(Teile_File.indexOf(teilenummer));
			verfügbarkeit = "Auf Lager";
			jlabel_verfügbarkeit.setText("Verfügbarkeit: " + verfügbarkeit);
			jlabel_verfügbarkeit.setForeground(Color.GREEN);
    		getPreis();
    		getLagerort();
    		getName();
		}
		else {
			verfügbarkeit = "Nicht auf Lager";
			jlabel_verfügbarkeit.setText("Verfügbarkeit: " + verfügbarkeit);
			jlabel_verfügbarkeit.setForeground(Color.RED);
			jlabel_preis.setText("");
			jlabel_lager.setText("");
			jlabel_name.setText("");
		}
	}
	
// Read Database-File
	public void readFile() throws IOException {
		Scanner scanner = new Scanner(new File("Teile.txt"));
		Teile_File = scanner.useDelimiter("\\A").next();
		scanner.close();
	}
	
// Main
	public static void main(String[] args) throws IOException {
		MyWeb start = new MyWeb();
	}
}
