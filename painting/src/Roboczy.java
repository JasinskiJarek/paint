/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Roboczy extends JPanel implements MouseListener,
		MouseMotionListener {
	ArrayList<JPanel> panele = new ArrayList<JPanel>();
	private int grubosc = 2;
	Point start = new Point();
	Point end = new Point();
	ArrayList<ShapeInfo> ksztalty = new ArrayList<ShapeInfo>();
	public Shape currentShape;
	public JPanel currentPanel;
	public int currentGrubosc;
	public Color currentColor = null;
	

	public Roboczy() {
		

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	{
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(1024, 470));

		Painting.slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				ustawGrubosc(Painting.slider.getValue());
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setStroke(new BasicStroke(grubosc));

		// kod do rysowania

	
{
		for (ShapeInfo info : ksztalty) {
			g2d.setStroke(new BasicStroke(info.grubosc));
			 g2d.setColor( info.kolor );
			g2d.draw(info.ksztalt);
			
		}
		}
		g2d.dispose();
	}

	public void ustawGrubosc(int nowaGrubosc) {
		if (nowaGrubosc >= 0) {
			grubosc = nowaGrubosc;
		} else {
			grubosc = 2;
		}

	

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent me) {
		
		start = me.getPoint();
		if (Painting.wcisnietyPrzycisk == "linia") {
			currentColor = Painting.kolor;
			currentGrubosc = Painting.slider.getValue();
			currentShape = new Line2D.Double(me.getPoint(), me.getPoint());
			ksztalty.add(new ShapeInfo(currentShape, currentColor, currentGrubosc, currentPanel));

		}

		if (Painting.wcisnietyPrzycisk == "okrag") {
			currentColor = Painting.kolor;
			currentGrubosc = Painting.slider.getValue();
			currentShape = new Ellipse2D.Double();
			ksztalty.add(new ShapeInfo(currentShape, currentColor, currentGrubosc,currentPanel));

		}

		if (Painting.wcisnietyPrzycisk == "prostokat") {
			currentColor = Painting.kolor;
			currentGrubosc = Painting.slider.getValue();
			currentShape = new Rectangle2D.Double();
			ksztalty.add(new ShapeInfo(currentShape, currentColor, currentGrubosc, currentPanel));

		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent me) {

	}

	@Override
	public void mouseDragged(MouseEvent me) {

		if (Painting.wcisnietyPrzycisk == "linia") {

			Line2D shape = (Line2D) currentShape;
			shape.setLine(shape.getP1(), me.getPoint());

		}

		if (Painting.wcisnietyPrzycisk == "okrag") {

			Ellipse2D shape = (Ellipse2D) currentShape;

			shape.setFrameFromDiagonal(end, start);

		}

		if (Painting.wcisnietyPrzycisk == "prostokat") {

			Rectangle2D shape = (Rectangle2D) currentShape;

			shape.setFrameFromDiagonal(end, start);

		}

		end = me.getPoint();

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}*/
