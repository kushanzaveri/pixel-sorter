import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Picture {
    private String fileName;
    private BufferedImage image;
    private String extension;

    public Picture (Picture p){
        this.fileName = p.fileName;
        load(fileName);
    }
    public Picture(String fileName){
        this.fileName = fileName;
        load(fileName);
    }

    public Picture(File file){
        this.fileName = file.getName();
        load(file);
    }


    public BufferedImage getImage(){return image;}

    public int getWidth()  {return image.getWidth();}
    public int getHeight() {return image.getHeight();}

    public int  getRGBPixel (int x, int y)          {return image.getRGB(x,y);}
    public void setRGBPixel (int x, int y, int rgb) {image.setRGB(x,y, rgb);}


    public String getFileName(){
        return fileName;
    }
    public String getPureName(){
        int posDot = fileName.indexOf('.');
        return fileName.substring(0, posDot);
    }
    public String getExtension(){
        return extension;
    }
    public Pixel getPixel(int x, int y){
        return new Pixel(this, x, y);
    }

    public Pixel[][] getPixelMatrix(){
        int h = getHeight(), w = getWidth();
        Pixel[][] pixelMatrix = new Pixel[h][w];
        for(int row = 0; row < image.getHeight(); row++){
            for(int col = 0; col< image.getWidth(); col++){
                pixelMatrix[row][col] = getPixel(col, row);
            }
        }
        return pixelMatrix;
    }

    public void load(String fileName){
        try {
            image = ImageIO.read(new File(fileName));
            int posDot = fileName.indexOf('.');
            if (posDot >= 0)
                extension = fileName.substring(posDot + 1);
        }catch(Exception e){
            // Handle exception
        }
    }

    public void load(File file){
        try {
            image = ImageIO.read(file);
            int posDot = fileName.indexOf('.');
            if (posDot >= 0)
                extension = fileName.substring(posDot + 1);
        }catch(Exception e){
            // Handle exception
        }
    }

    public void write(String fileName){
        try {
            ImageIO.write(image, extension, new File(fileName));
        }catch (Exception e){
            // Handle exception
        }
    }
}
