import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{

	public static JPanel panel;
	
    Point2D pt1, pt2;
    private ArrayList<ShapeInfo> ksztalty;
    private Shape shape = null;
    public Drawing(){
    	ksztalty = new ArrayList<ShapeInfo>();
    	panel = new JPanel(){
    		
    		public void paint(Graphics g){
    	        Graphics2D g2d = (Graphics2D) g;

    	        g2d.setColor(Color.RED);
    	        g2d.drawLine(20, 20, 100, 100);
    	        //Shape k = null;
    	        //k = new Shape();
    	        //g2d.setPaint(Color.BLACK );
    	        g2d.setColor(Color.GREEN);
    	        for ( ShapeInfo info : ksztalty )
    	        {
    	            g2d.draw(info.ksztalt);
    	        }
    	        g2d.setColor(Color.BLUE);
    	    }
    	};
        

        Point p1 = new Point();p1.x = 200;p1.y = 200;
        Point p2 = new Point();p2.x = 300;p2.y = 300;

        pt1 = (Point2D) p1;
        pt2 = (Point2D) p2;
        //Line k = new Line(p1,p2,Color.BLUE);
        shape = new Line2D.Double ( pt1, pt2 );
        ksztalty.add(new ShapeInfo(shape, Color.RED, 2));
        
        setPreferredSize(new Dimension (1024,576));
    	
    }

    

    public static void main(String[] args){
    	
        Frame f = new Frame("Rysuje");

        f.setResizable(false);
        f.setSize(400, 400);
        f.setVisible(true);
        Drawing myFrame = new Drawing();
        myFrame.add(panel);
        f.add(myFrame);
    }
}