package GraphProjectInterface;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PrimaryFrame extends JFrame {

    MainPanel mainPanel;
    public PrimaryFrame(){
        mainPanel = new MainPanel();
        this.setLayout(new BorderLayout(10, 0));
        this.add(mainPanel);
        this.add(new SidePanel(this), BorderLayout.EAST);
        this.setSize(new Dimension(1400, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
