package GraphProjectInterface;



import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    BottomPanel bottomP;
    GraphPanel graphP;
    MainPanel(){
        graphP = new GraphPanel();
        bottomP = new BottomPanel(this);
        this.setLayout(new BorderLayout());
        this.add(new BottomPanel(this), BorderLayout.SOUTH);
        this.add(graphP);
    }
}
