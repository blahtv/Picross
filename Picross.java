import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Picross extends JFrame{
    private JTabbedPane Tabs;
    private JPanel Picross10;
    private JPanel Picross15;
    private JPanel Instructions;
    private Dimension screenSize;


    public Picross(){
        setTitle("Picross");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Tabs = new JTabbedPane();
        add(Tabs);

        Picross10 = new PuzzleTab(screenSize, new Dimension(10,10));
        Picross15 = new PuzzleTab(screenSize, new Dimension(15,15));
        Instructions = new JPanel();
        Tabs.addTab("10x10 Puzzles", Picross10);
        Tabs.addTab("15x15 Puzzles", Picross15);
        Tabs.addTab("How to Play", Instructions);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Picross();
    }
}

    