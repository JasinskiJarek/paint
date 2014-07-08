import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class graphCanvas extends JPanel
{
 public graphCanvas(int wide, int high)
 {
	 this.setPreferredSize(new Dimension(1300, 800));
  this.setLayout(null);
  this.setSize(wide,high);
  this.setLocation(0,0);
 }

 public void paintComponent(Graphics g)
 {
	 super.paintComponent(g);
	 Graphics2D g2d = (Graphics2D) g;
		
		
	
			g2d.drawRect(200, 200, 200, 200);
		
 }

}