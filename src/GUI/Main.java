package GUI;

import Box.Coords;
import Listener.KeyListener;
import Simulation.NextGeneration;
import Simulation.Simulation;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

public final class Main extends JFrame {

    public Main() {
        initComponents();

        Simulation simulation = new Simulation();
        Coords coords = new Coords();
        Score score = new Score();
        BoxGUI snake = new BoxGUI(coords, score, 20, 20, 15);
        NextGeneration next = new NextGeneration(snake.getApple(), coords);

        next.addObserver(snake);
        snake.getTick().addObserver(next);
        simulation.getSimulation().addObserver(next);
        snake.getTick().setChanged();
        snake.getTick().notifyObservers(snake.getApple());

        map.add(snake, BorderLayout.CENTER);
        result.add(score);
        addKeyListener(new KeyListener(snake, simulation));
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        setResizable(false);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        program = new javax.swing.JPanel();
        map = new javax.swing.JPanel();
        result = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake");

        program.setLayout(new java.awt.GridBagLayout());

        map.setLayout(new java.awt.BorderLayout());
        program.add(map, new java.awt.GridBagConstraints());

        result.setLayout(new java.awt.GridLayout(1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        program.add(result, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(program, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(program, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel map;
    private javax.swing.JPanel program;
    private javax.swing.JPanel result;
    // End of variables declaration//GEN-END:variables
}
