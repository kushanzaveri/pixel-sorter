import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JScrollPane {

    Picture p;
    ImageIcon img;
    public ImagePanel(Picture p){
        super(new JLabel(new ImageIcon(p.getImage())));
        this.p = p;
        img = new ImageIcon(p.getImage());
        setLocation(0,22);
        setSize(Constants.WIDTH, Constants.M_HEIGHT-20);
        setVisible(true);
    }

}


/*
    ImageIcon ii = new ImageIcon("largeJava2sLogo.jpg");
    JScrollPane jsp = new JScrollPane(new JLabel(ii));
    getContentPane().add(jsp);
    setSize(300, 250);
    setVisible(true);
 */