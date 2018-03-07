package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class Score extends JPanel {

    private final JLabel score, result, bestScore, bestResult;
    private int points, bestPoints;

    public Score() {
        score = new JLabel("Score:", SwingConstants.RIGHT);
        result = new JLabel("0");
        bestScore = new JLabel("Best Score:", SwingConstants.RIGHT);
        bestResult = new JLabel("0", SwingConstants.LEFT);
        points = 0;
        bestPoints = 0;
        setBackground(Color.white);
        setLayout(new GridLayout(1, 0));
        add(score);
        add(result);
        add(bestScore);
        add(bestResult);
    }

    public void setPoints() {
        points += 3;
        result.setText(Integer.toString(points));
        if (points > bestPoints) {
            bestResult.setText(Integer.toString(points));
            bestPoints = points;
        }
    }

    public void resetPoints() {
        points = 0;
        result.setText("0");
    }

}
