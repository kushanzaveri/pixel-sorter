import java.awt.*;

public class Pixel {

    private Picture picture;
    private int x, y, a, r, g, b;
    public Pixel(Picture picture, int x, int y){
        this.picture = picture;
        this.x = x;
        this.y = y;
        int rgbValue = picture.getRGBPixel(x, y);
        a = (rgbValue >> 24) & 0xff;
        r = (rgbValue >> 16) & 0xff;
        g = (rgbValue >>  8) & 0xff;
        b =  rgbValue        & 0xff;
    }

    public int getRow()     {return y;}
    public int getCol()     {return x;}
    public int getAlpha()   {return a;}
    public int getRed()     {return r;}
    public int getGreen()   {return g;}
    public int getBlue()    {return b;}
    public Color getColor() {return new Color(r, g, b);}
    public int getLumin()   {return (int)(r * 0.2126f + g * 0.7152f + b * 0.0722f);}

    public void setColor (Color newColor){
        picture.setRGBPixel(x, y, newColor.getRGB());
    }
}
