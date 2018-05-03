package tech.ryanqyang;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SortDisplay sortVisualizer = new SortDisplay();
        frame.setTitle("Sorting Visualizer");
        frame.setPreferredSize(new Dimension(850, 450));
        frame.setMinimumSize(new Dimension(700, 380));
        frame.add(sortVisualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
