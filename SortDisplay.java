package tech.ryanqyang;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SortDisplay extends JPanel {

    private JList<String> jlSupportedSorts;

    private JPanel jpControlButtons;
    private JPanel jpSideBar;
    private JSlider jsAnimationSpeed;

    private JButton jbStart;
    private JButton jbStop;
    private JButton jbNext;
    private JButton jbPrevious;

    private JPanel jpSortingVisualizer;

    private int barWidth;

    private int[] randomizedArray;
    private ArrayList<Integer> randomizedArrayList;
    private int sortType;
    private int animationTime;

    public SortDisplay(){
        createComponents();
        wireComponents();
    }
    public void createComponents(){
        BorderLayout mainLayout = new BorderLayout();
        BorderLayout sideBarLayout = new BorderLayout(10, 30);
        GridLayout visualizerControls = new GridLayout(2, 2, 5, 10);

        setLayout(mainLayout);

        jpSortingVisualizer = new JPanel();
        jpSortingVisualizer.setBackground(new Color(25, 31, 43));
        jpSortingVisualizer.setForeground(Color.white);
        add(jpSortingVisualizer, mainLayout.CENTER);

        jpSideBar = new JPanel();
        jpSideBar.setBorder(new EmptyBorder(20,0, 40, 0));
        jpSideBar.setBackground(new Color(25, 31, 43));
        jpSideBar.setLayout(sideBarLayout);

        jpControlButtons = new JPanel();
        jpControlButtons.setBackground(new Color(25, 31, 43));
        jpControlButtons.setLayout(visualizerControls);

        jbStart = new JButton("Start");
        jbStop = new JButton("Stop");
        jbPrevious = new JButton("Next");
        jbNext = new JButton("Prev");

        jbStart.setOpaque(true);
        jbStart.setBackground(new Color(84, 216, 99));

        jbStop.setOpaque(true);
        jbStop.setBackground(new Color(196, 0, 0));

        jpControlButtons.add(jbStart);
        jpControlButtons.add(jbStop);
        jpControlButtons.add(jbPrevious);
        jpControlButtons.add(jbNext);

        jpSideBar.add(jpControlButtons, sideBarLayout.CENTER);

        jlSupportedSorts = new JList<String>(SortingAlgorithms.getSupportedSorts());
        jlSupportedSorts.setBorder(new EmptyBorder(10,30, 10, 30));
        jlSupportedSorts.setBackground(new Color(77, 92, 122));
        jlSupportedSorts.setForeground(new Color(255, 255, 255));
        jlSupportedSorts.setLayoutOrientation(JList.VERTICAL);

        jlSupportedSorts.setFixedCellHeight(30);
        jpSideBar.add(jlSupportedSorts, sideBarLayout.NORTH);

        jsAnimationSpeed = new JSlider();
        jsAnimationSpeed.setForeground(new Color(255, 255, 255));
        jsAnimationSpeed.setPaintTicks(true);

        jpSideBar.add(jsAnimationSpeed, sideBarLayout.SOUTH);

        add(jpSideBar, mainLayout.EAST);
        setBackground(new Color(25, 31, 43));
        setBorder(new EmptyBorder(0,20, 0, 20));
    }

    public void wireComponents(){
        animationTime = jsAnimationSpeed.getValue();
        jsAnimationSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                animationTime = jsAnimationSpeed.getValue();
            }
        });
        jlSupportedSorts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    sortType = jlSupportedSorts.getSelectedIndex();
                    initSort();
                }
            }
        });
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingAlgorithms.selectionSort(randomizedArray);
                repaint();
            }
        });
    }

    public void initSort(){
        randomizedArray = SortingAlgorithms.randomIntArrayGenerator(40, 100);
        displayArray(randomizedArray);
    }

    /**
     * displays array onto JPanel and their respective lengths
     * @param randArr
     */
    public void displayArray(int[] randArr){
        randomizedArray = randArr;
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(randomizedArray != null){
            displayArrayGeneral(g);
        }
        //drawSelection(g);
    }

    public void displayArrayGeneral(Graphics g){
        int panelWidth = jpSortingVisualizer.getWidth();
        int panelHeight = jpSortingVisualizer.getHeight() - 20;
        barWidth = (panelWidth - 40) / randomizedArray.length;
        int width = barWidth - 4;

        for (int i = 0; i < randomizedArray.length; i++) {
            int height = (int)((randomizedArray[i] / 100.0) * (panelHeight * 0.8));
            int xPos = 20 + (i * barWidth) + 2;
            int yPos = panelHeight - height - 30;
            g.setColor(new Color(11, 142, 229));
            g.fillRect(xPos, yPos, width, height);
        }
    }

    public void drawSelection(Graphics g){
        int panelWidth = jpSortingVisualizer.getWidth();
        int panelHeight = jpSortingVisualizer.getHeight() - 20;
        barWidth = (panelWidth - 40) / (randomizedArray.length - 3);
        int width = barWidth - 4;

        for (int i = 0; i < randomizedArray.length; i++) {
            int height = (int)((randomizedArray[i] / 100.0) * (panelHeight * 0.8));
            int xPos = 20 + (i * barWidth) + 2;
            int yPos = panelHeight - height - 30;
            if(i > randomizedArray[randomizedArray.length - 3]){
                g.setColor(new Color(255, 119, 0));
            }else if(i == randomizedArray[randomizedArray.length - 3]){
                g.setColor(new Color(11, 142, 229));
                g.fillOval(xPos, yPos, width, width);
            }else{
                g.setColor(new Color(11, 142, 229));
            }
            g.fillRect(xPos, yPos, width, height);
        }
    }

}
