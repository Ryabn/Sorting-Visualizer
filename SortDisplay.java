package tech.ryanqyang;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        jlSupportedSorts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                sortType = jlSupportedSorts.getSelectedIndex();
                initSort();
            }
        });
    }

    public void initSort(){
        randomizedArray = SortingAlgorithms.randomIntArrayGenerator(20, 100);
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
        if(randomizedArray != null) {
            int panelWidth = jpSortingVisualizer.getWidth();
            int panelHeight = jpSortingVisualizer.getHeight() - 20;
            barWidth = (panelWidth - 40) / randomizedArray.length;
            for (int i = 0; i < randomizedArray.length; i++) {
                int xPos = 20 + (i * barWidth) + 2; // 20 is border, 2 is margin between
                int yPos = panelHeight;
                int height = randomizedArray[i] * 2;
                int width = barWidth - 4;
                g.setColor(new Color(255, 119, 0));
                g.fillRect(xPos, 20, width, height);
            }

        }
    }

}
