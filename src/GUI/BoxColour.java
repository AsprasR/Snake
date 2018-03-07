package GUI;

import java.awt.Color;
import javax.swing.JLabel;

public final class BoxColour extends JLabel {
    
    public BoxColour(Color colour) {
        setState(colour);
    }
    
    public void setState(Color colour) {
        if (colour.equals(Color.YELLOW)) {
            setBackground(colour);            
        } else if (colour.equals(Color.RED)) {
            setBackground(colour);
        } else {
            setBackground(colour);
        }
    }
}
