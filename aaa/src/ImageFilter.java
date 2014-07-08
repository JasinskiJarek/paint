import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class ImageFilter extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.tiff) ||
                extension.equals(Utils.tif) ||
                extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg) ||
                extension.equals(Utils.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Pliki obrazów";
    }
}


class pngSaveFilter extends FileFilter
{ 
   public boolean accept(File file)
  {
       if (file.isDirectory())
         {
           return false;
         }

        String s = file.getName();

       return s.endsWith(".png")||s.endsWith(".PNG");
  }


  public String getDescription() 
 {
      return "*.png,*.PNG";
 }
}
  class jpgSaveFilter extends FileFilter
  { 
     public boolean accept(File file)
    {
         if (file.isDirectory())
           {
             return false;
           }

          String s = file.getName();

         return s.endsWith(".jpg")||s.endsWith(".JPG");
    }

    public String getDescription() 
   {
        return "*.jpg,*.JPG";
   }
  }
    class gifSaveFilter extends FileFilter
    { 
       public boolean accept(File file)
      {
           if (file.isDirectory())
             {
               return false;
             }

            String s = file.getName();

           return s.endsWith(".gif")||s.endsWith(".GIF");
      }

      public String getDescription() 
     {
          return "*.gif,*.GIF";
     }
    }
      class bmpSaveFilter extends FileFilter
      { 
         public boolean accept(File file)
        {
             if (file.isDirectory())
               {
                 return false;
               }

              String s = file.getName();

             return s.endsWith(".bmp")||s.endsWith(".BMP");
        }

        public String getDescription() 
       {
            return "*.bmp,*.BMP";
       }
      }
        class tifSaveFilter extends FileFilter
        { 
           public boolean accept(File file)
          {
               if (file.isDirectory())
                 {
                   return false;
                 }

                String s = file.getName();

               return s.endsWith(".tif")||s.endsWith(".TIF");
          }

          public String getDescription() 
         {
              return "*.tif,*.TIF";
         }
        }
          class tiffSaveFilter extends FileFilter
          { 
             public boolean accept(File file)
            {
                 if (file.isDirectory())
                   {
                     return false;
                   }

                  String s = file.getName();

                 return s.endsWith(".tiff")||s.endsWith(".TIFF");
            }

            public String getDescription() 
           {
                return "*.tiff,*.TIFF";
           }
          }
            class jpegSaveFilter extends FileFilter
            { 
               public boolean accept(File file)
              {
                   if (file.isDirectory())
                     {
                       return false;
                     }

                    String s = file.getName();

                   return s.endsWith(".jpeg")||s.endsWith(".JPEG");
              }

              public String getDescription() 
             {
                  return "*.jpeg,*.JPEG";
             }
            }
              class wbmpSaveFilter extends FileFilter
              { 
                 public boolean accept(File file)
                {
                     if (file.isDirectory())
                       {
                         return false;
                       }

                      String s = file.getName();

                     return s.endsWith(".wbmp")||s.endsWith(".WBMP");
                }

                public String getDescription() 
               {
                    return "*.wbmp,*.WBMP";
               }

}

         