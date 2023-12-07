import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame(){
        this.setLayout(new BorderLayout(10, 10));
        this.add(new SidePanel(), BorderLayout.EAST);
        this.setSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
