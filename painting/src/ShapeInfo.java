import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.JPanel;


public class ShapeInfo
{                   // Don't use static here unless you want all of your Person 
                    // objects to have the same data
 
   Shape ksztalt;
   Color kolor;
   int grubosc;


   public ShapeInfo(Shape ksztalt, Color kolor, int currentGrubosc)
   {

      this.ksztalt = ksztalt;         // the same name as constructor parameters
      this.kolor = kolor;    // with the "this" keyword. Can't use 
      this.grubosc = currentGrubosc;


   }

}