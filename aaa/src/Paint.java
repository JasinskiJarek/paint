import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Paint extends JFrame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Paint paint = new Paint();
				paint.setSize(1043, 672);
				paint.setVisible(true);
			}
		});
	}
	double r;
	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	Point2D punkt;
	Point2D punkt1;
	Point2D punkt2;
	boolean zwolniony = false;
	boolean ciagniety = false;
	ArrayList<Point> punktyKsztaltdowolny = new ArrayList<Point>();
	ArrayList<Point> punktyKwadrat = new ArrayList<Point>();
	ArrayList<Point> punktyWielokat = new ArrayList<Point>();
	ArrayList<Point> punktyOkrag = new ArrayList<Point>();
	ArrayList<Shape> ksztaltydowolne = new ArrayList<Shape>();
	public GeneralPath path;
	public GeneralPath wielokat;
	Area areaToFill = null;
	Area a2 = null;
	Area a3 = null;
	JMenuBar belkamenu;
	Area obszar;
	JMenuItem belkaNowy;
	JMenuItem belkaOtworz;
	JMenuItem belkaZapisz;
	public BufferedImage bImage;
	public BufferedImage bImg;
	private JPanel boxContainer;
	JMenuItem cofnij;
	public Color currentColor = null;
	public int currentGrubosc;
	public JPanel currentPanel;
	public Shape currentShape;
	JButton dalej;
	JMenu edycja;
	Point end = new Point();
	public String ext;
	public String extension;
	private JFileChooser fc;
	protected boolean fill = false;
	boolean wylewaj = false;
	boolean wcisnietyElipsa = false;
	boolean filled = false;
	private int grubosc = 2;
	public BufferedImage img;
	boolean klikniety = false;
	Color kolor = Color.BLACK;
	private JPanel kontrolki;
	ArrayList<ShapeInfo> ksztalty = new ArrayList<ShapeInfo>();
	ArrayList<ShapeInfo> ksztaltyWyp = new ArrayList<ShapeInfo>();
	//public boolean wcisnietyPedzel = false;
	public boolean wcisnietyProstokat = false;
	public boolean wcisnietyLinia = false;
	public boolean wcisnietyKolo = false;
	public boolean wcisnietyKwadrat = false;
	JButton linia;
	JButton brush;
	JButton wielok;
	private JPanel menu;
	JButton nowy;
	ImageIcon pedzel = new ImageIcon(getClass().getResource("pedzel.jpg"));
	ImageIcon wielo = new ImageIcon(getClass().getResource("wielokat.jpg"));
	ImageIcon obrazekDalej = new ImageIcon(getClass().getResource("dalej.png"));
	ImageIcon obrazekLinia = new ImageIcon(getClass().getResource("linia.jpg"));
	ImageIcon obrazekNowy = new ImageIcon(getClass().getResource("nowy.jpg"));
	ImageIcon obrazekElipsa = new ImageIcon(getClass().getResource("elipsa.jpg"));
	ImageIcon obrazekOkrag = new ImageIcon(getClass().getResource("okrag.jpg"));
	ImageIcon obrazekKwadrat = new ImageIcon(getClass().getResource("kwadrat.jpg"));
	ImageIcon obrazekOtworz = new ImageIcon(getClass()
			.getResource("otworz.jpg"));
	ImageIcon obrazekProstokat = new ImageIcon(getClass().getResource(
			"prostokat.jpg"));
	ImageIcon obrazekPytajnik = new ImageIcon(getClass().getResource(
			"pytajnik.gif"));
	ImageIcon obrazekWstecz = new ImageIcon(getClass()
			.getResource("wstecz.png"));
	ImageIcon obrazekWybKol = new ImageIcon(getClass()
			.getResource("wybKol.jpg"));
	ImageIcon obrazekWylejFarbe = new ImageIcon(getClass().getResource(
			"wylejFarbe.jpg"));
	ImageIcon obrazekZapisz = new ImageIcon(getClass()
			.getResource("zapisz.jpg"));
	JButton elipsa;
	JButton okrag;
	JButton otworz;
	ArrayList<JPanel> panele = new ArrayList<JPanel>();
	private JPanel panelGlowny;
	JMenu plik;
	JMenuItem powtorz;
	JButton prostokat;
	Point punkcik;
	private JPanel roboczy;
	JScrollPane scroller;
	public Color shapeColor = null;
	ArrayList<Color> shapeFill = new ArrayList<Color>();
	JSlider slider;
	Point start;
	public int sz;
	public JTextField szerokosc;
	public Shape theShape;
	String wcisnietyPrzycisk = "";
	JButton wstecz;
	public int wy;
	JButton wybierzKolor;
	JMenuItem wyjscie;
	JButton wylejFarbe;
	public JTextField wysokosc;
	int x = 0;
	JButton zapisz;
	JButton kwadrat;
	JButton zatwierdzRozmiar;
	public Paint() {
		szerokosc = new JTextField("1024");
		wysokosc = new JTextField("576");
		bImage = new BufferedImage(getSz(), getWy(), BufferedImage.TYPE_INT_ARGB);
		img = new BufferedImage(getSz(), getWy(), BufferedImage.TYPE_INT_ARGB);
		belkamenu = new JMenuBar();
		setJMenuBar(belkamenu);
		plik = new JMenu("Plik");
		edycja = new JMenu("Edycja");
		belkamenu.add(plik);
		belkamenu.add(edycja);
		wyjscie = new JMenuItem("Wyj�cie");
		belkaNowy = new JMenuItem("Nowy");
		belkaOtworz = new JMenuItem("Otw�rz");
		belkaZapisz = new JMenuItem("Zapisz");
		cofnij = new JMenuItem("Cofnij");
		powtorz = new JMenuItem("Powt�rz");
		plik.add(belkaOtworz);
		plik.add(belkaZapisz);
		plik.add(wyjscie);
		plik.add(belkaOtworz);
		plik.add(belkaNowy);
		edycja.add(cofnij);
		edycja.add(powtorz);

		belkaNowy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!ksztalty.isEmpty()) {
					infoZapisz();
				}
			}
		});

		belkaZapisz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				zapiszObraz();
			}
		});

		belkaOtworz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				otworzObraz();
			}
		});

		cofnij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				ksztalty.remove(ksztalty.get(ksztalty.size() - 1));
				repaint();
			}
		});

		wyjscie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				System.exit(0);

			}
		});

		boxContainer = new JPanel();
		boxContainer.setLayout(new BorderLayout());

		kontrolki = new JPanel();

		kontrolki.setLayout(new GridLayout(1, 5));
		kontrolki.setPreferredSize(new Dimension(1024, 30));
		wstecz = new JButton("", obrazekWstecz);
		wstecz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				ksztalty.remove(ksztalty.get(ksztalty.size() - 1));
				repaint();
			}
		});

		dalej = new JButton("", obrazekDalej);
		zatwierdzRozmiar = new JButton("Zatwierd�");
		kontrolki.add(zatwierdzRozmiar);
		kontrolki.add(szerokosc);
		kontrolki.add(wysokosc);
		kontrolki.add(wstecz);
		kontrolki.add(dalej);
		panelGlowny = new JPanel();
		panelGlowny.setLayout(new BorderLayout());
		menu = new JPanel();
		slider = new JSlider(SwingConstants.HORIZONTAL, 1, 50, 2);
		slider.setPreferredSize(new Dimension(120, 40));
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ustawGrubosc(slider.getValue());
			}
		});

		nowy = new JButton("", obrazekNowy);
		nowy.setPreferredSize(new Dimension(40, 40));
		nowy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ksztalty.isEmpty()) {
					infoZapisz();
				}
			}
		});

		zapisz = new JButton("", obrazekZapisz);
		zapisz.setPreferredSize(new Dimension(40, 40));
		zapisz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zapiszObraz();
			}
		});

		otworz = new JButton("", obrazekOtworz);
		otworz.setPreferredSize(new Dimension(40, 40));
		otworz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				otworzObraz();
			}
		});
		
		
		wielok = new JButton("", wielo);
		wielok.setPreferredSize(new Dimension(40, 40));
		wielok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wcisnietyPrzycisk = "wielokat";
			}
		});
		
		
		brush = new JButton("", pedzel);
		brush.setPreferredSize(new Dimension(40, 40));
		brush.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wcisnietyPrzycisk = "pedzel";
			}
		});

		wybierzKolor = new JButton("", obrazekWybKol);
		wybierzKolor.setPreferredSize(new Dimension(40, 40));
		wybierzKolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				kolor = JColorChooser.showDialog(null, "Wybierz kolor", kolor);
				if (kolor == null) {
					kolor = (Color.BLUE);
				}
			}
		});

		wylejFarbe = new JButton("", obrazekWylejFarbe);
		wylejFarbe.setPreferredSize(new Dimension(40, 40));
		wylejFarbe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				wylewaj = true;
				wcisnietyElipsa = false;
				wcisnietyProstokat = false;
				wcisnietyLinia = false;
				wcisnietyKolo = false;
				wcisnietyKwadrat = false;
				wcisnietyPrzycisk = "wylejFarbe";
				punktyWielokat.clear();
			}
		});

		linia = new JButton("", obrazekLinia);
		linia.setPreferredSize(new Dimension(40, 40));
		linia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				wcisnietyPrzycisk = "linia";
				wylewaj = false;

			}
		});
		elipsa = new JButton("", obrazekElipsa);
		elipsa.setPreferredSize(new Dimension(40, 40));
		elipsa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				wcisnietyPrzycisk = "elipsa";
				wylewaj = false;
			}
		});
		
		kwadrat = new JButton("", obrazekKwadrat);
		kwadrat.setPreferredSize(new Dimension(40, 40));
		kwadrat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				wcisnietyPrzycisk = "kwadrat";
				wylewaj = false;
			}
	});
		
			okrag = new JButton("", obrazekOkrag);
			okrag.setPreferredSize(new Dimension(40, 40));
			okrag.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					wcisnietyPrzycisk = "okrag";
					wylewaj = false;
				}
			
		});
		prostokat = new JButton("", obrazekProstokat);
		prostokat.setPreferredSize(new Dimension(40, 40));
		prostokat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				wcisnietyPrzycisk = "prostokat";
				wylewaj = false;
			}
		});
		roboczy = new JPanel() {
		
			private static final long serialVersionUID = 1L;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ArrayList<BufferedImage> imagesy = new ArrayList<BufferedImage>();
				Graphics2D g3d = bImage.createGraphics();		
				imagesy.add(bImage);	
				g3d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g3d.setStroke(new BasicStroke(grubosc));
				Graphics2D g2d = (Graphics2D) g;
				g3d.setBackground(Color.WHITE);
				g2d.drawImage(imagesy.get(0), null, 0, 0);
				g3d.clearRect(0, 0, getSz(), getWy());
				g2d.dispose();				
				repaint();
				for (ShapeInfo info : ksztalty) {
					g3d.setStroke(new BasicStroke(info.grubosc));
					g3d.setColor(info.kolor);
				    Area obszar1 = new Area(info.ksztalt);
					if ((boolean)info.filled != false){
					g3d.setColor(info.kolor);
					
					if (wcisnietyPrzycisk == "linia"|| wcisnietyPrzycisk == "pedzel")
					{
						g3d.fill(info.ksztalt);
						
						//g3d.fill(obszar1);
					}
					
					if (wcisnietyPrzycisk == "wielokat")
					{
						//g3d.fill(info.ksztalcik);
						//g3d.fill(obszar1);
					}
					
					else{
					//g3d.fill(obszar1);
					g3d.fill(info.ksztalt);
					}
					}
					else{
						if (wcisnietyPrzycisk == "linia"|| wcisnietyPrzycisk == "pedzel")
						{
							g3d.draw(info.ksztalt);
							//g3d.draw(obszar1);
							
						}
						
						if (wcisnietyPrzycisk == "wielokat")
						{
							//g3d.draw(info.ksztalt);
							g3d.draw(info.ksztalcik);
							
						}
						
						else{
							
					//g3d.draw(obszar1);
					g3d.draw(info.ksztalt);
					
						}
					}
						
				}
				
						}
			};
			
		roboczy.setLayout(new CardLayout());
		roboczy.setBackground(Color.WHITE);
		menu.add(nowy);
		menu.add(otworz);
		menu.add(zapisz);
		menu.add(wybierzKolor);
		menu.add(wylejFarbe);
		menu.add(brush);
		menu.add(linia);
		menu.add(elipsa);
		menu.add(okrag);
		menu.add(prostokat);
		menu.add(kwadrat);
		menu.add(wielok);
		menu.add(slider);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGlowny.setPreferredSize(new Dimension(getSz(), getWy()));
		roboczy.setPreferredSize(new Dimension(getSz(), getWy()));

		zatwierdzRozmiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				roboczy.revalidate();
				bImage = new BufferedImage(getSz(), getWy(),
						BufferedImage.TYPE_INT_RGB);
				roboczy.setPreferredSize(new Dimension(getSz(), getWy()));
				panelGlowny.setPreferredSize(new Dimension(getSz(), getWy()));
			}
		});

		belkamenu.setPreferredSize(new Dimension(1024, 20));
		menu.setPreferredSize(new Dimension(1024, 50));

		panelGlowny.add(roboczy, BorderLayout.NORTH);
		boxContainer.add(panelGlowny, BorderLayout.WEST);
		boxContainer.add(menu, BorderLayout.NORTH);
		getContentPane().add(kontrolki, BorderLayout.SOUTH);
		getContentPane().add(boxContainer, BorderLayout.NORTH);
		scroller = new JScrollPane(boxContainer);
		scroller.setViewportView(boxContainer);

		roboczy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				
				punkt = me.getPoint();
				
				if (wcisnietyPrzycisk == "wielokat") {
		        	Graphics2D g3d = bImage.createGraphics();
		        	g3d.setBackground(Color.WHITE);
					punktyWielokat.add(me.getPoint());  
					    System.out.println(punktyWielokat);
					GeneralPath wielokat = new GeneralPath(GeneralPath.WIND_EVEN_ODD, punktyWielokat.size());
					wielokat.moveTo(punktyWielokat.get(0).getX(), punktyWielokat.get(0).getY());
					for (int k = 0; k < punktyWielokat.size(); k++){
						wielokat.lineTo(punktyWielokat.get(k).getX(), punktyWielokat.get(k).getY());
						}
					if (me.getModifiers() == MouseEvent.BUTTON3_MASK) 
					{
					wielokat.closePath();
					System.out.println("zamykanie");
					punktyWielokat.clear();
					}
			        Shape wielokatKsztalt = wielokat;
			       ksztalty.add (new ShapeInfo(wielokatKsztalt,wielokatKsztalt, false, kolor, grubosc));
			       
			}				
			}
			
			
			public void mouseReleased(MouseEvent me) {
				punktyKsztaltdowolny.clear();
				punktyOkrag.clear();
				punktyKwadrat.clear();
				ciagniety = false;
				
				//punktyWielokat.clear();
				
			}

			@Override
			public void mousePressed(MouseEvent me) {
				//mouse = me.getPoint();
				start = me.getPoint();
				end = me.getPoint();
				
				if (wylewaj != false) {
					ksztaltyNakladanie();
						}
				

				if (wcisnietyPrzycisk == "linia") {
					//punktyWielokat.clear();
					currentShape = new Line2D.Double(me.getPoint(), me.getPoint());
					ustawieniaKsztaltu();

					}
				
				if (wcisnietyPrzycisk == "elipsa") {
				currentShape = new Ellipse2D.Double();
				
					ustawieniaKsztaltu();
					
				}
				
				if (wcisnietyPrzycisk == "okrag") {
					
					currentShape = new Ellipse2D.Double();
					ustawieniaKsztaltu();
						
						
					}

				if (wcisnietyPrzycisk == "prostokat") {

					currentShape = new Rectangle2D.Double();
					ustawieniaKsztaltu();

				}
				
				if (wcisnietyPrzycisk == "kwadrat") {

					currentShape = new Rectangle2D.Double();
					ustawieniaKsztaltu();

				}
			}


		});

		roboczy.addMouseMotionListener(new MouseMotionAdapter() {

			
			@Override
			public void mouseDragged(MouseEvent me) {
				punkt1 = me.getPoint();
				ciagniety = true;
				zwolniony = false;
				if (wcisnietyPrzycisk == "linia") {
					Line2D shape = (Line2D) currentShape;
					shape.setLine(shape.getP1(), me.getPoint());	
				}
				
				if (wcisnietyPrzycisk == "pedzel") {
					punktyKsztaltdowolny.add(me.getPoint());
					    System.out.println(punktyKsztaltdowolny);
					GeneralPath dowolny = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
					for (int k = 1; k < punktyKsztaltdowolny.size(); k++){
						dowolny.moveTo(punktyKsztaltdowolny.get(k-1).getX(), punktyKsztaltdowolny.get(k-1).getY());
						dowolny.lineTo(punktyKsztaltdowolny.get(k).getX(), punktyKsztaltdowolny.get(k).getY());
						}
					Area pedzelArea = new Area(dowolny);
			        Shape pedzelKsztalt = dowolny;
			        ksztalty.add (new ShapeInfo(pedzelKsztalt, pedzelKsztalt, false, kolor, grubosc));
				}
			        
			        
				if (wcisnietyPrzycisk == "elipsa") {
					Ellipse2D shape = (Ellipse2D) currentShape;
					shape.setFrameFromDiagonal(end, start);		
				}
				
				
				//me.getX()-b, me.getY()-b
				if (wcisnietyPrzycisk == "kwadrat") {
					punktyKwadrat.add(me.getPoint());
					double b = Math.sqrt((Math.abs(me.getX()-punktyKwadrat.get(0).getX())*Math.abs(me.getX()-punktyKwadrat.get(0).getX()) + Math.abs(me.getY()-punktyKwadrat.get(0).getY())*Math.abs(me.getY()-punktyKwadrat.get(0).getY())));
					Rectangle2D shape = (Rectangle2D) currentShape;
					punkt = new Point2D.Double(punktyKwadrat.get(0).getX(), punktyKwadrat.get(0).getY());
					if (me.getY()<punktyKwadrat.get(0).getY()&&me.getX()>punktyKwadrat.get(0).getX())
					{
					punkt1=new Point ((int)punktyKwadrat.get(0).getX()+(int)b, (int)punktyKwadrat.get(0).getY()-(int)b);
					}
					else if (me.getY()<punktyKwadrat.get(0).getY()&&me.getX()<punktyKwadrat.get(0).getX())
					{
					punkt1=new Point ((int)punktyKwadrat.get(0).getX()-(int)b, (int)punktyKwadrat.get(0).getY()-(int)b);
					}
					else if (me.getY()>punktyKwadrat.get(0).getY()&&me.getX()>punktyKwadrat.get(0).getX())
					{
					punkt1=new Point ((int)punktyKwadrat.get(0).getX()+(int)b, (int)punktyKwadrat.get(0).getY()+(int)b);
					}
					else if (me.getY()>punktyKwadrat.get(0).getY()&&me.getX()<punktyKwadrat.get(0).getX())
					{
						punkt1=new Point ((int)punktyKwadrat.get(0).getX()-(int)b, (int)punktyKwadrat.get(0).getY()+(int)b);
					
					}
					shape.setFrameFromDiagonal(punkt, punkt1);
				}
				if (wcisnietyPrzycisk == "okrag") {
					punktyOkrag.add(me.getPoint());
					r = Math.sqrt((Math.abs(me.getX()-punktyOkrag.get(0).getX())*Math.abs(me.getX()-punktyOkrag.get(0).getX()) + Math.abs(me.getY()-punktyOkrag.get(0).getY())*Math.abs(me.getY()-punktyOkrag.get(0).getY())));
					Ellipse2D shape = (Ellipse2D) currentShape;
					punkt = new Point2D.Double(punktyOkrag.get(0).getX(), punktyOkrag.get(0).getY());
					if (me.getY()<punktyOkrag.get(0).getY()&&me.getX()>punktyOkrag.get(0).getX())
					{
					punkt1=new Point ((int)punktyOkrag.get(0).getX()+(int)r, (int)punktyOkrag.get(0).getY()-(int)r);
					}
					else if (me.getY()<punktyOkrag.get(0).getY()&&me.getX()<punktyOkrag.get(0).getX())
					{
					punkt1=new Point ((int)punktyOkrag.get(0).getX()-(int)r, (int)punktyOkrag.get(0).getY()-(int)r);
					}
					else if (me.getY()>punktyOkrag.get(0).getY()&&me.getX()>punktyOkrag.get(0).getX())
					{
					punkt1=new Point ((int)punktyOkrag.get(0).getX()+(int)r, (int)punktyOkrag.get(0).getY()+(int)r);
					}
					else if (me.getY()>punktyOkrag.get(0).getY()&&me.getX()<punktyOkrag.get(0).getX())
					{
						punkt1=new Point ((int)punktyOkrag.get(0).getX()-(int)r, (int)punktyOkrag.get(0).getY()+(int)r);
					
					}
					shape.setFrameFromDiagonal(punkt, punkt1);
					
					 

					
					
				}

				if (wcisnietyPrzycisk == "prostokat") {
					Rectangle2D shape = (Rectangle2D) currentShape;
					shape.setFrameFromDiagonal(end, start);
				}
				end = me.getPoint();
			}	
		});
		this.add(scroller, BorderLayout.CENTER);

	}

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		return false;
	}


	public Color getColor() {
		return kolor;
	}

	public int getSz() {
		return Integer.parseInt(szerokosc.getText());
	}

	public int getWy() {
		return Integer.parseInt(wysokosc.getText());
	}

	public void infoZapisz() {
		Object[] options = { "Tak", "Nie", "Anuluj" };

		int pytanie = JOptionPane.showOptionDialog(scroller,
				"Czy chcesz zapisa� aktualny obraz?", "Zapisa�?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[2]);
		if (pytanie == JOptionPane.YES_OPTION) {
			zapiszObraz();
			ksztalty.removeAll(ksztalty);
			roboczy.setPreferredSize(new Dimension(getSz(), getWy()));
			panelGlowny.setPreferredSize(new Dimension(getSz(), getWy()));
		}
		if (pytanie == JOptionPane.NO_OPTION) {
			ksztalty.removeAll(ksztalty);

			roboczy.setPreferredSize(new Dimension(getSz(), getWy()));
			panelGlowny.setPreferredSize(new Dimension(getSz(), getWy()));

		} else {

		}
		;
	}

	public boolean isFill() {

		return fill;

	}

	private void otworzObraz() {
		// Set up the file chooser.
		if (fc == null) {
			fc = new JFileChooser(".");

			// Add a custom file filter and disable the default
			// (Accept All) file filter.
			fc.addChoosableFileFilter(new ImageFilter());
			fc.setAcceptAllFileFilterUsed(true);

		}

		// Show it.
		int returnVal = fc.showDialog(Paint.this, "Otw�rz");

		// Process the results.
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				img = ImageIO.read(file);

				int height = img.getHeight();
				int width = img.getWidth();

				roboczy.setPreferredSize(new Dimension(width, height));
				panelGlowny.setPreferredSize(new Dimension(width, height));
				szerokosc.setText(Integer.toString(width));
				wysokosc.setText(Integer.toString(height));

				roboczy.revalidate();
				panelGlowny.revalidate();
				ksztalty.removeAll(ksztalty);
				roboczy.repaint();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fc.setSelectedFile(null);

	}

	public void setColor(Color color) {
		this.kolor = color;
	}

	public void setFill(boolean fill) {

		this.fill = fill;

	}
	
	public void ustawieniaKsztaltu(){
		shapeColor = kolor;
		currentColor = kolor;
		currentGrubosc = slider.getValue();
		// currentShape = new Ellipse2D.Double();
		filled = true;
		obszar = new Area(currentShape);

		ksztalty.add(new ShapeInfo(obszar,currentShape, currentShape, false,
				currentColor, currentGrubosc));
		
		
	}
	
	public void ksztaltyNakladanie(){
//		ArrayList<ShapeInfo> klon = (ArrayList<ShapeInfo>)ksztalty.clone();

		for (ShapeInfo info : ksztalty) {
		
			if ((boolean) wylewaj != false)
		if (info.ksztalt.contains(start))	
		{
			//Area a1 = new Area(info3.ksztalt);
			ksztaltyWyp.add(new ShapeInfo(new Area(info.ksztalt), info.ksztalt, true,
					kolor, grubosc));
		System.out.println("dodanedsadsa");

		if (ksztaltyWyp.size() > 1) {
			areaToFill = new Area(ksztaltyWyp.get(0).ksztalt);
			for (ShapeInfo szejpy : ksztaltyWyp) {
				if (areaToFill.equals(szejpy.ksztalt))
					continue;	
				areaToFill.intersect(new Area(szejpy.ksztalt)); 
				System.out.println("intersekcja");
			}
		} else if (ksztaltyWyp.size() == 1) {
			areaToFill = new Area(ksztaltyWyp.get(0).ksztalt);
		}
		// roznica
		for (ShapeInfo shapeIntersect : ksztaltyWyp) {
			for (ShapeInfo info2 : ksztalty) {
				//if (shape.getShape().equals(shapeIntersect))
				if (ksztaltyWyp.contains(info2.ksztalt))
					continue;	
				//System.out.println(((Ellipse2D)info2.ksztalt).getX() + ":" + ((Ellipse2D)info2.ksztalt).getY());
				a3 = new Area(info2.ksztalt);
				a2 = new Area(shapeIntersect.ksztalt);
				if(doAreasCollide(a3, a2))
					areaToFill.subtract(a3);
				System.out.println("koliduja");
			}
		}
		
		if (areaToFill != null)
			ksztaltyWyp.add(new ShapeInfo(areaToFill, info.ksztalt, true,
					kolor, grubosc));
		
		}}
		ksztalty.addAll(ksztaltyWyp);
	}
	

	public void ustawGrubosc(int nowaGrubosc) {
		if (nowaGrubosc >= 0) {
			grubosc = nowaGrubosc;
		} else {
			grubosc = 2;
		}
	}
	

	
	
	public boolean doAreasCollide(Area area1, Area area2) {
        boolean collide = false;

        Area collide1 = new Area(area1);
        collide1.subtract(area2);
        if (!collide1.equals(area1)) {
            collide = true;
        }

        Area collide2 = new Area(area2);
        collide2.subtract(area1);
        if (!collide2.equals(area2)) {
            collide = true;
        }

        return collide;
    }
	
	
	public void PencilTool() {
        path = new GeneralPath();
        setShape(path);
        
    }
	
	public void action(int eventID, double x, double y,
	         Graphics2D g) {
	     if (eventID == MouseEvent.MOUSE_PRESSED)
	         path.moveTo(x, y);
	     else if (eventID == MouseEvent.MOUSE_DRAGGED) {
	         Point2D startPoint = path.getCurrentPoint();
	         Point2D endPoint = new Point2D.Double(x, y);
	         Line2D l = new Line2D.Float(startPoint, endPoint);

	         g.draw(l);
	         path.lineTo(x, y);
	     }}
	
	
	


	private void zapiszObraz() {
		if (fc == null) {
			fc = new JFileChooser(".");

			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.addChoosableFileFilter(new jpgSaveFilter());
			fc.addChoosableFileFilter(new pngSaveFilter());
			fc.addChoosableFileFilter(new gifSaveFilter());
			fc.addChoosableFileFilter(new tifSaveFilter());
			fc.addChoosableFileFilter(new tiffSaveFilter());
			fc.addChoosableFileFilter(new jpegSaveFilter());
			fc.addChoosableFileFilter(new bmpSaveFilter());
			fc.addChoosableFileFilter(new wbmpSaveFilter());

			fc.setAcceptAllFileFilterUsed(true);
		}
		int result = fc.showDialog(Paint.this, "Zapisz");
		if (result == JFileChooser.APPROVE_OPTION) {

			extension = fc.getFileFilter().getDescription();

			if (extension == "*.jpg,*.JPG") {
				ext = "jpg";
			}

			else if (extension == "*.tif,*.TIF") {
				ext = "tif";
			}

			else if (extension == "*.tiff,*.TIFF") {
				ext = "tiff";
			}

			else if (extension == "*.png,*.PNG") {
				ext = "png";
			} else if (extension == "*.gif,*.GIF") {
				ext = "gif";
			} else if (extension == "*.wbmp,*.WBMP") {
				ext = "wbmp";
			} else if (extension == "*.jpeg,*.JPEG") {
				ext = "jpeg";
			} else if (extension == "*.bmp,*.BMP") {
				ext = "bmp";
			}
			File file = null;
			try {
				file = new File(fc.getSelectedFile().getCanonicalPath() + "."
						+ ext);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ImageIO.write(bImage, ext, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		fc.setSelectedFile(null);

	}

}
