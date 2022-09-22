import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PuzzleTab extends JPanel implements MouseListener, ActionListener, ItemListener {
    private JComboBox<String> PuzzleList;
    private JCheckBox ShowErrors;
    private JPanel Board;
    private JPanel[][] Squares;
    private Dimension screenSize;
    private int puzzleHeight;
    private int puzzleWidth;
    private boolean allowInputs;

    public PuzzleTab(Dimension screenSize, Dimension puzzleSize) {
        this.screenSize = screenSize;
        this.setLayout(new GridBagLayout());
        this.Board = new JPanel();
        this.Board.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.puzzleHeight = (int)puzzleSize.getHeight();
        this.puzzleWidth = (int)puzzleSize.getWidth();
        this.setUpBoard();
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=3;
        c.gridheight=3;
        c.insets = new Insets(0,10,10,0);
        this.add(this.Board, c);

        String[] puzzles = {"Puzzle 1", "Puzzle 2", "Puzzle 3", "Puzzle 4", "Puzzle 5"};
        this.PuzzleList = new JComboBox<String>(puzzles);
        this.PuzzleList.addActionListener(this);
        c.gridx=4;
        c.gridy=2;
        c.gridwidth=1;
        c.gridheight=1;
        this.add(PuzzleList, c);
        this.loadPuzzle(getPuzzleData());

        this.ShowErrors = new JCheckBox("Show Mistakes");
        this.ShowErrors.addItemListener(this);
        c.gridx=5;
        this.add(ShowErrors, c);
        this.allowInputs = true;
    }

    private void setUpBoard(){
        GridBagConstraints c = new GridBagConstraints();
        Squares = new JPanel[this.puzzleHeight+1][this.puzzleWidth+1];
        c.ipadx = 80;
        c.ipady = 80;
        for (int i = 0; i < this.puzzleHeight+1; i++) {
            for (int j = 0; j < this.puzzleWidth+1; j++) {
                JPanel square = new JPanel();
                square.setLayout(new BorderLayout());
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(15,15));
                label.setHorizontalAlignment(JLabel.CENTER);
                square.add(label);
                Squares[i][j] = square;
                c.gridx = j;
                c.gridy = i;
                c.fill = 1;
                if(i!=0 && j!=0) {
                    square.setBackground(Color.white);
                    square.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                    square.addMouseListener(this);
                    int fontSize = 72 - ((puzzleHeight-10)*4);
                    label.setFont(new Font("Dialog", Font.PLAIN, fontSize));
                }
                else {
                    label.setFont(new Font("Dialog", Font.PLAIN, 18));
                }
                this.Board.add(square, c);
                switch(this.puzzleHeight) {
                    case 10: c.ipady = (int) (screenSize.getHeight()/20.0);
                        break;
                    case 15: c.ipady = (int) (screenSize.getHeight()/40.0);
                        break;
                }
                c.ipady = (int) ( (screenSize.getHeight()) / (-20 + 4*puzzleHeight) );
                c.ipadx = c.ipady;
            }
        }
    }

    private JLabel getLabel(JPanel square)
    {
        return (JLabel)square.getComponent(0);
    }

    private void loadPuzzle(boolean[][] puzzleData) {
        for(int i = 0 ; i < this.puzzleHeight; i++) {
            for(int j = 0; j < this.puzzleWidth; j++) {
                Squares[i+1][j+1].setBackground(Color.white);
                JLabel label =  getLabel(Squares[i+1][j+1]);
                label.setText("");
            }
        }
        
        //Get row's count
        for(int i = 0; i < this.puzzleHeight; i++) {
            String clue = "";
            JPanel square = Squares[i+1][0];
            JLabel label = getLabel(square);
            int count = 0;
            for(int j = 0; j < this.puzzleWidth; j++) {
                if(puzzleData[i][j]) {
                    count++;
                    if(j < this.puzzleWidth-1 && !puzzleData[i][j+1])
                    {
                        clue += count+" ";
                        count = 0;
                    }
                }
            }
        if(clue.equals("") && count == 0)
            clue = "0";
        if(count != 0)
            clue += count;
        label.setText(clue);
        }

        //Get col's count
        for(int j = 0; j < this.puzzleWidth; j++) {
            String clue = "<html>";
            JPanel square = Squares[0][j+1];
            JLabel label = getLabel(square);
            int count = 0;
            for(int i = 0; i < this.puzzleHeight; i++) {
                if(puzzleData[i][j]) {
                    count++;
                    if(i < this.puzzleHeight-1 && !puzzleData[i+1][j])
                    {
                        clue += count+"<br>";
                        count = 0;
                    }
                }
            }
        if(clue.equals("<html>") && count == 0)
            clue += "0</html>";
        if(count != 0)
            clue += count+"</html>";
        label.setText(clue);
        }   
    }

    private void toggleColor(JPanel s)
    {
        JLabel label = getLabel(s);
        if(!label.getText().equals("X")) {
            if(s.getBackground().equals(Color.gray) || s.getBackground().equals(Color.red))
                s.setBackground(Color.white);
            else {
                s.setBackground(Color.gray);
            }
        }
        if(ShowErrors.isSelected())
            displayErrors(1);
        checkCorrect();
    }

    private void checkCorrect()
    {
        boolean[][]data = getPuzzleData();
        for(int i = 0; i < this.puzzleHeight; i++)
        {
            for(int j = 0; j < this.puzzleWidth; j++)
            {
                Color squareColor = Squares[i+1][j+1].getBackground();
                boolean colorFilled = (squareColor.equals(Color.gray) || squareColor.equals(Color.red));
                if((data[i][j] && !colorFilled) || 
                  (!data[i][j] && colorFilled))
                {
                    return;
                }
            }
        }
        allowInputs = false;
        revealPuzzle();
    }

    private void revealPuzzle()
    {
        Color blankspace = new Color(0);
        Color filledspace = new Color(0);
        switch(PuzzleList.getSelectedIndex()+1) {
            case 1: blankspace = Color.yellow;
                    filledspace = Color.black;
                break;
            case 2: blankspace = Color.black;
                    filledspace = Color.red;
                break;
            case 3: blankspace = Color.black;
                    filledspace = Color.white;
                break;
            case 4: blankspace = Color.yellow;
                    filledspace = Color.black;
                break;
            case 5: blankspace = new Color(250, 214, 165);
                    filledspace = Color.black;
                break;
        }
        boolean[][]data = getPuzzleData();
        for(int i = 1; i < this.puzzleHeight+1; i++)
            for(int j = 1; j < this.puzzleWidth+1; j++)
            {
                getLabel(Squares[i][j]).setText("");
                if(data[i-1][j-1])
                    Squares[i][j].setBackground(filledspace);
                if(!data[i-1][j-1])
                    Squares[i][j].setBackground(blankspace);
            }
    }

    private void toggleX(JPanel s)
    {
        if(s.getBackground().equals(Color.white))
        {
        JLabel label = getLabel(s);
        if(label.getText().equals("X"))
            label.setText("");
        else
            label.setText("X");
        }
        if(ShowErrors.isSelected())
            displayErrors(1);
    }

    private void displayErrors(int show)
    {
        boolean[][] data = getPuzzleData();
        if(show==1)
            for(int i = 1; i < this.puzzleHeight+1; i++)
                for(int j = 1; j < this.puzzleWidth+1; j++) {
                    JLabel label = getLabel(Squares[i][j]);
                    if(data[i-1][j-1] && label.getText().equals("X"))
                        label.setForeground(Color.red);
                    if(!data[i-1][j-1] && Squares[i][j].getBackground().equals(Color.gray))
                        Squares[i][j].setBackground(Color.red);
                }
        else
            for(int i = 1; i < this.puzzleHeight+1; i++)
                for(int j = 1; j < this.puzzleWidth+1; j++) {
                    JLabel label = getLabel(Squares[i][j]);
                    if(label.getForeground().equals(Color.red))
                        label.setForeground(Color.black);
                    if(Squares[i][j].getBackground().equals(Color.red))
                        Squares[i][j].setBackground(Color.gray);
                }
    }

    private boolean[][] getPuzzleData() {
        boolean[][] data = new boolean[this.puzzleHeight][this.puzzleWidth];
        switch(this.puzzleHeight) {
            case 10:
                switch(this.PuzzleList.getSelectedIndex()+1) {
                    case 1: data = PuzzleData.puzzle1();
                        break;
                    case 2: data = PuzzleData.puzzle2();
                        break;
                    case 3: data = PuzzleData.puzzle3();
                        break;
                    case 4: data = PuzzleData.puzzle4();
                        break;
                    case 5: data = PuzzleData.puzzle5();
                        break;
                }
                break;
            case 15:
                switch(this.PuzzleList.getSelectedIndex()+1) {
                    case 1: data = PuzzleData.puzzle6();
                        break;
                    case 2: data = PuzzleData.puzzle7();
                        break;
                }
                break;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==PuzzleList) {
            boolean[][] data = getPuzzleData();
            loadPuzzle(data);
            allowInputs = true;
        } 
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub  
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(allowInputs) {
            JPanel square = (JPanel) e.getSource();
            if(e.getModifiersEx()== MouseEvent.BUTTON1_DOWN_MASK)
                toggleColor(square);
            if(e.getModifiersEx()== MouseEvent.BUTTON3_DOWN_MASK)
                toggleX(square);
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(allowInputs) {
            int mouseButton = e.getButton();
            JPanel sqaure = (JPanel) e.getSource();
            switch(mouseButton) {
                case 1: toggleColor(sqaure);
                    break;
                case 3: toggleX(sqaure);
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub    
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==ShowErrors)
            displayErrors(e.getStateChange());
    }
}
