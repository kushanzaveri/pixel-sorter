import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PixelSort {
    private Picture p;
    private int threshold;
    public PixelSort(Picture p, int threshold, boolean rotate){
        this.p = p;
        this.threshold = threshold;
        sortPixels(rotate);
    }

    public Picture getPicture(){return p;}

    public void sortPixels(boolean rotate){
        Pixel[][] pixelMatrix = p.getPixelMatrix();
        if(!rotate) {
            for (Pixel[] row : pixelMatrix) {
                sortRow(row);
            }
        }else{

        }
    }
    public void sortRow(Pixel[] row){
        boolean sort = false;
        List<Pixel> pixelList = new ArrayList<>();
        int start = 0, end = 0;
        for(int x = 0;x < row.length;x++){
            float lumin = row[x].getLumin();
            if(sort)
                pixelList.add(row[x]);

            if(lumin>threshold && !sort){
                sort = true;
                start = x;
            }

            if(lumin<threshold && sort){
                end = x;
                Collections.sort(pixelList, new Comparator<Pixel>() {
                    @Override
                    public int compare(Pixel p1, Pixel p2) {
                        return p1.getLumin()-p2.getLumin();
                    }
                });
                for(int i = start; i < end; i++)
                    row[i].setColor(pixelList.get(i - start).getColor());

                pixelList = new ArrayList<>();
                sort = false;
                start = 0;
                end = 0;
            }
        }
    }

    public int getThreshold(){
        return threshold;
    }

    public static void main(String[] args){
        Picture orig = new Picture ("img.jpg");
        Picture img = new Picture("img.jpg");
        PixelSort ps = new PixelSort(img, 150, false);
        ps.getPicture().write("sorted.jpg");
       // new Viewer(orig.getImage(), sort.getImage()).show();
    }

}
