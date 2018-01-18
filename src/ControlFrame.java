import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFrame extends JFrame {

    MainFrame parent;
    JLabel label;
    JSlider slider;
    JSpinner spinner;
    JButton genBut;
    PixelSort ps;
    public ControlFrame(MainFrame parent){
        super("Control Frame");
        this.parent=parent;
        setupFrame();
        setupSlider();
        setupButton();
        this.setVisible(true);
        parent.assignControlFrame(this);
    }

    public void setupFrame(){
        this.setLocation(parent.getX(), parent.getY()+parent.getHeight());
        this.setSize(Constants.WIDTH,Constants.C_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);
    }

    public void setupSlider(){
        label = new JLabel("Threshold: ");
        Dimension label_pref = label.getPreferredSize();
        slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));

        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(75);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(15));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spinner.setValue(slider.getValue());
            }
        });
        spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    slider.setValue((int)spinner.getValue());
                }
        });

        label.setBounds(500-label_pref.width/2, 10, label_pref.width,label_pref.height);
        slider.setBounds(25, 30, 750, 40);
        spinner.setBounds (800, 30, 50,20);

        this.add(label);
        this.add(slider);
        this.add(spinner);
    }

    public void setupButton(){
        genBut = new JButton("Generate");
        Dimension but_pref = genBut.getPreferredSize();
        genBut.setBounds(500-but_pref.width/2, 125, but_pref.width, but_pref.height);
        genBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        this.add(genBut);
    }

    public void generate(){
        if(parent.mainPicture!=null) {
            Picture sortThis = new Picture(parent.mainPicture);
            ps = new PixelSort(sortThis, slider.getValue(), false);
            parent.showPicture(ps.getPicture());
        }
    }

    public PixelSort getPs(){
        return ps;
    }
    public static void main(String [] args){
        MainFrame m = new MainFrame("Main");
        new ControlFrame(m);
    }

}


/*
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("NoLayout Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    JLabel label = new JLabel("First Name:");
    label.setBounds(20, 20, 100, 20);
    JTextField textField = new JTextField();
    textField.setBounds(124, 25, 100, 20);
    frame.add(label);
    frame.add(textField);
    frame.setSize(300, 100);
    frame.setVisible(true);
 */