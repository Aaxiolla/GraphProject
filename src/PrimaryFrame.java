import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    JPanel mainPanel;
    public PrimaryFrame(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new BottomPanel(), BorderLayout.SOUTH);
        mainPanel.add(new GraphPanel());
        this.setLayout(new BorderLayout(10, 0));
        this.add(mainPanel);
        this.add(new SidePanel(), BorderLayout.EAST);
        this.setSize(new Dimension(1400, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
