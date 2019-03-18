import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
	JPanel Bestellung;
	JPanel Bezeichnungen;
	JPanel Ende;
	JPanel Neustart;
	
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
	    JPanel NeustartButton = new JPanel(new GridLayout(1, 2));
	    Browser browser = new Browser();
	    BrowserView browserView = new BrowserView(browser);
	    teil_nummer = new JTextField("Ersatzteilnummer:", 20);
	    JTextField Name = new JTextField("Name:", 20);
	    JTextField Telefonnummer = new JTextField("Telefonnummer:", 20);
	    JTextField EMail = new JTextField("E-Mail:", 20);
	    Button teil_suchen_button = new Button("Ersatzteil suchen");
	    Button bestellung_abgeben = new Button("Artikel bestellen");
	    Button drucken = new Button("Bestellung abgeben");
	    Button Restart = new Button("Neustart");
	    JLabel NeustartBeschreibung = new JLabel("Hier klicken um zum Anfang zurückzukehren --> ");
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
	    JLabel zehn = new JLabel("10. Falls sie den Artikel kaufen wollen, auf 'Artikel bestellen' klicken");
	    JLabel elf = new JLabel("11. Name, Telefonnummer und E-Mail angeben");
	    JLabel zwoelf = new JLabel("12. Auf 'Bestellung abgeben' klicken");
	    JLabel dreizehn = new JLabel("Falls Artikel verfügbar:");
	    JLabel vierzehn = new JLabel("13. Einem Freien Kollegen sagen, dass sie etwas bestellt haben");
	    JLabel fuenfzehn = new JLabel("Falls Artikel nicht verfügbar:");
	    JLabel sechszehn = new JLabel("13. Sie werden benachrichtigt, wenn der Artikel eingetroffen ist");
	    
// Fonts
	    Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
	    fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    Font font1 = new Font("SansSerif", Font.BOLD, 20);
	    Font font2 = new Font("SansSerif", Font.BOLD, 15);
	    Font font3 = new Font("SansSerif", Font.BOLD, 30).deriveFont(fontAttributes);;
	    Font font4 = new Font("SansSerif", Font.BOLD, 20).deriveFont(fontAttributes);
	    Font font5 = new Font("SansSerif", Font.BOLD, 15).deriveFont(fontAttributes);
	    
// Please ignore all these dummies
		JLabel dummy1 = new JLabel("");
		JLabel dummy2 = new JLabel("");
		JLabel dummy3 = new JLabel("");
		JLabel dummy4 = new JLabel("");
		JLabel dummy5 = new JLabel("");
		JLabel dummy6 = new JLabel("");
		
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
	    zehn.setFont(font2);
	    elf.setFont(font2);
	    zwoelf.setFont(font2);
	    dreizehn.setFont(font5);
	    vierzehn.setFont(font2);
	    fuenfzehn.setFont(font5);
	    sechszehn.setFont(font2);
	    dreizehn.setForeground(Color.GREEN);
	    fuenfzehn.setForeground(Color.RED);
	    teil_suchen_button.setFont(font1);
	    NeustartBeschreibung.setForeground(Color.RED);
	    ersteZeile.setForeground(Color.RED);
	    NeustartBeschreibung.setFont(font1);
	    ersteZeile.setFont(font3);
	    NeustartBeschreibung.setHorizontalAlignment(JLabel.CENTER);
	    ersteZeile.setHorizontalAlignment(JLabel.CENTER);
	    Beschreibung.setFont(font4);
	    Beachten.setFont(font2);
	    bestellung_abgeben.setFont(font1);
	    drucken.setFont(font1);
	    Restart.setFont(font1);
	    
// Add objects to frame/panel
// Right Panel
	    rightPanel.add(rechtsPanel1);
	    rightPanel.add(rechtsPanel2);
	    rightPanel.add(rechtsPanel3);
	    rightPanel.add(rechtsPanel4);
	    rightPanel.add(rechtsPanel5);
	    
// Right Panel 1
	    rechtsPanel1.add(ersteZeile);
	    rechtsPanel1.add(NeustartButton);
	    rechtsPanel1.add(Beschreibung);
	    
// Right Panel 2
	    rechtsPanel2.add(eins);
	    rechtsPanel2.add(neun);
	    rechtsPanel2.add(zwei);
	    rechtsPanel2.add(zehn);
	    rechtsPanel2.add(drei);
	    rechtsPanel2.add(elf);
	    rechtsPanel2.add(vier);
	    rechtsPanel2.add(zwoelf);
	    rechtsPanel2.add(fünf);
	    rechtsPanel2.add(dreizehn);
	    
// Right Panel 3
	    rechtsPanel3.add(sechs);
	    rechtsPanel3.add(vierzehn);
	    rechtsPanel3.add(sieben);
	    rechtsPanel3.add(fuenfzehn);
	    rechtsPanel3.add(acht);
	    rechtsPanel3.add(sechszehn);
	    rechtsPanel3.add(Beachten);
		
// Right Panel 4
	    rechtsPanel4.add(dummy1);
	    rechtsPanel4.add(dummy2);
	    rechtsPanel4.add(teil_nummer);
	    rechtsPanel4.add(teil_suchen_button);
		
// Right Panel 5
	    rechtsPanel5.add(jlabel_verfügbarkeit);
	    rechtsPanel5.add(dummy3);
	    rechtsPanel5.add(jlabel_name);
	    rechtsPanel5.add(dummy4);
	    rechtsPanel5.add(jlabel_preis);
	    rechtsPanel5.add(dummy5);
	    rechtsPanel5.add(jlabel_lager);
	    rechtsPanel5.add(dummy6);
		
	    NeustartButton.add(NeustartBeschreibung);
	    NeustartButton.add(Restart);
	    
// Search file if user presses the button
	    teil_suchen_button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		teilenummer = teil_nummer.getText();
	    		teil_suchen();
	    		jlabel_lager.setFont(font1);
	    		jlabel_preis.setFont(font1);
	    		jlabel_verfügbarkeit.setFont(font1);
	    		jlabel_name.setFont(font1);
	    		rechtsPanel5.add(bestellung_abgeben);
	        }
	    });

// Switch to order menu
	    bestellung_abgeben.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		rightPanel.remove(rechtsPanel4);
	    		rightPanel.remove(rechtsPanel5);
	    		rightPanel.revalidate();
	    		rightPanel.repaint();
	    		Bezeichnungen = new JPanel(new GridLayout(5, 1));
	    		Bestellung = new JPanel(new GridLayout(5, 1));
	    		rightPanel.add(Bezeichnungen);
	    		rightPanel.add(Bestellung);
	    		Bezeichnungen.add(jlabel_verfügbarkeit);
	    		Bezeichnungen.add(jlabel_name);
	    		Bezeichnungen.add(jlabel_preis);
	    		Bezeichnungen.add(jlabel_lager);
	    		Bestellung.add(Name);
	    		Bestellung.add(Telefonnummer);
	    		Bestellung.add(EMail);
	    		Bestellung.add(drucken);
	    	}
	    });
	    
// print
	    drucken.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JLabel name = new JLabel("Name: " + Name.getText());
	    		JLabel telefonnummer = new JLabel("Telefonnummer: " + Telefonnummer.getText());
	    		JLabel email = new JLabel("E-Mail: " + EMail.getText());
	    	    name.setFont(font1);
	    	    telefonnummer.setFont(font1);
	    	    email.setFont(font1);
	    		rightPanel.remove(Bestellung);
	    		rightPanel.remove(Bezeichnungen);
	    		rightPanel.revalidate();
	    		rightPanel.repaint();
	    		Ende = new JPanel(new GridLayout(8, 1));
	    		rightPanel.add(Ende);
	    		Ende.add(jlabel_verfügbarkeit);
	    		Ende.add(jlabel_name);
	    		Ende.add(jlabel_preis);
	    		Ende.add(jlabel_lager);
	    		Ende.add(name);
	    		Ende.add(telefonnummer);
	    		Ende.add(email);
	    		
// Print automatic (you dont have to press "ok")
	    		Thread thread = new Thread() {
	    			public void run() {
	    	    		printComponenet(Ende);
	    			}
	    		};
	    		thread.start();
	    		try {
					Robot r = new Robot();
		    		r.delay(2000);
		    		r.keyPress(KeyEvent.VK_ENTER);
		    		r.keyRelease(KeyEvent.VK_ENTER);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
	    	}
	    });
	    
// Restart
	    Restart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frame.dispose();
	    		try {
					@SuppressWarnings("unused")
					MyWeb neustart = new MyWeb();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	}
	    });
	    
// Load URL (insert here your spare part catalogue) 
	    browser.loadURL("");
	    frame.setVisible(true);
	    
// Delete text of JTextField if user clicks on it
	    teil_nummer.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		teil_nummer.setText("");
	        }
	    });
	    Name.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		Name.setText("");
	        }
	    });
	    Telefonnummer.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		Telefonnummer.setText("");
	        }
	    });
	    EMail.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		EMail.setText("");
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
					@SuppressWarnings("unused")
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
		String Ersatzteilnummer = teil_nummer.getText();
		jlabel_name.setText("Bezeichnung: " + name + "  -  " + Ersatzteilnummer);
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
	
// Print
	public void printComponenet(Component component){
		  PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName(" Print Component ");

		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum){
		      if (pageNum > 0){
		      return Printable.NO_SUCH_PAGE;
		      }

		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      component.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }
		  });
		  if (pj.printDialog() == false)
		  return;

		  try {
		        pj.print();
		  } catch (PrinterException ex) {
		  }
		}
	
// Read Database-File
	public void readFile() throws IOException {
		Scanner scanner = new Scanner(new File("C:\\Teile.txt"));
		Teile_File = scanner.useDelimiter("\\A").next();
		scanner.close();
	}
	
// Main
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		MyWeb start = new MyWeb();
	}
}