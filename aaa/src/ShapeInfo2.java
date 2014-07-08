import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class ShapeInfo2 implements Shape
{              
Area area;
Area area1;
	Shape ksztalt;


   Color kolor;



   public ShapeInfo2(Area area,Area area1, Shape currentShape, Color kolor)
   {
this.area = area;
this.area1 = area1;
	   this.ksztalt = currentShape;

      this.kolor = kolor; 


   }


public void paint(Graphics g) {
	// TODO Auto-generated method stub
	
}





@Override
public boolean contains(Point2D p) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean contains(Rectangle2D r) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean contains(double x, double y) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean contains(double x, double y, double w, double h) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public Rectangle getBounds() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Rectangle2D getBounds2D() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public PathIterator getPathIterator(AffineTransform at) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public PathIterator getPathIterator(AffineTransform at, double flatness) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean intersects(Rectangle2D r) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean intersects(double x, double y, double w, double h) {
	// TODO Auto-generated method stub
	return false;
}




   
   
   
}