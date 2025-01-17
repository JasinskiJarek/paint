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


public class ShapeInfo implements Shape,Cloneable
{         
	int index;
	Area area;
	Area area1;
	Shape ksztalt;
	Shape ksztalcik;
	Shape ksztaltek;
boolean filled;

   Color kolor;
   int grubosc;

   
   public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
   
   
   public ShapeInfo(Shape currentShape, Color kolor)
   {

	   this.ksztaltek = currentShape;

      this.kolor = kolor; 


   }
   
   
   public ShapeInfo(Area area,Area area1, Shape currentShape, Color kolor)
   {
this.area = area;
this.area1 = area1;
	   this.ksztalcik = currentShape;

      this.kolor = kolor; 


   }

   public ShapeInfo(Area area, Shape currentShape, boolean filled, Color kolor, int grubosc)
   {
this.area=area;
	   this.ksztalt = currentShape;
	   this.filled=filled;

      this.kolor = kolor; 
      this.grubosc = grubosc;


   }
   
   public ShapeInfo(Shape currentShape, Shape currentShape1, boolean filled, Color kolor, int grubosc)
   {
	   this.ksztalt = currentShape;
	   this.ksztalcik = currentShape1;
	   this.filled=filled;

      this.kolor = kolor; 
      this.grubosc = grubosc;
   }
      public ShapeInfo(Area area,Shape currentShape, Shape currentShape1, boolean filled, Color kolor, int grubosc)
      {
    	  this.area=area;
   	   this.ksztalt = currentShape;
   	   this.ksztalcik = currentShape1;
   	   this.filled=filled;

         this.kolor = kolor; 
         this.grubosc = grubosc;


   }
   
   public ShapeInfo(Shape currentShape, boolean filled, Color kolor, int grubosc)
   {

	   this.ksztalt = currentShape;
	   this.filled=filled;

      this.kolor = kolor; 
      this.grubosc = grubosc;


   }
   
   
   
   public ShapeInfo(Area area, Shape currentShape, boolean filled, int index, Color kolor, int grubosc)
   {
this.area=area;
this.index = index;
	   this.ksztalt = currentShape;
	   this.filled=filled;

      this.kolor = kolor; 
      this.grubosc = grubosc;


   }

   public Shape getShape() {
		return ksztalt;
	}
	public void setShape(Shape currentShape) {
		this.ksztalt = currentShape;
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