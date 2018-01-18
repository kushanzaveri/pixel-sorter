import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainFrame extends JFrame {

    JMenuItem menuItemOpen;
    JMenuItem menuItemQuit;
    JMenuItem menuItemSave;
    JMenuBar menuBar;
    JMenu menuFile;
    Picture mainPicture;
    ImagePanel panel;
    ControlFrame cf;
    PixelSort ps;
    public MainFrame(){
        super();
    }

    public MainFrame(String title){
        super(title);
        this.setLayout(null);
        this.setSize(Constants.WIDTH,Constants.M_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addMenuBar();
        this.setVisible(true);
    }

    public void addMenuBar(){
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        initItems();
        addMenuActions();

        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);
    }
    public void initItems(){
        menuItemOpen = new JMenuItem("Open");
        menuItemSave = new JMenuItem("Save");
        menuItemQuit = new JMenuItem("Quit");
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemQuit);
    }
    public void addMenuActions(){
        menuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

    }

    public void open(){
        JFileChooser fileChooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);

        int result = fileChooser.showOpenDialog(new JFrame());

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            mainPicture = new Picture(selectedFile);
            showPicture();
        }
    }
    public void save(){

        if(cf.getPs()!=null) {
            ps = cf.getPs();
            String newName = mainPicture.getPureName()+"-sorted-"+ps.getThreshold()+"."+mainPicture.getExtension();
            ps.getPicture().write(newName);
            JOptionPane.showMessageDialog(this,"Saved as: " + newName);
            return;
        }
        JOptionPane.showMessageDialog(this,"Couldn't Save.");

    }
    public void showPicture(){
        panel = new ImagePanel(mainPicture);
        panel.setPreferredSize(new Dimension(100,100));
        setContentPane(panel);

        repaint();
    }
    public void showPicture(Picture toShow){
        panel = new ImagePanel(toShow);
        setContentPane(panel);
        repaint();
    }

    public void assignControlFrame(ControlFrame cf){
        this.cf = cf;
    }
    public static void main(String [] args){
        new MainFrame("Wew");
    }

}


