import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel menu_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(Color.darkGray);
        text_field.setForeground(new Color(25, 255, 0));
        text_field.setFont(new Font("MV Boli", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic Tac Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 700, 100);

        menu_panel.setLayout(new GridLayout(0,2));
        menu_panel.setBounds(0,0,700,100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(230,255,255));
        }

        JButton reset = new JButton("New game");

        reset.setForeground(Color.lightGray);
        reset.setBackground(Color.DARK_GRAY);
        reset.setFont(new Font("sans-serif",Font.BOLD,30));

        reset.addActionListener(e -> {
            for(int i=0; i<9; i++) {
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(new Color(230,255,255));
            }
            firstTurn();
        });

        JButton exit = new JButton("Exit");

        exit.setForeground(Color.lightGray);
        exit.setBackground(Color.DARK_GRAY);
        exit.setFont(new Font("sans-serif",Font.BOLD,30));

        exit.addActionListener(e -> System.exit(0));

        menu_panel.add(reset);
        menu_panel.add(exit);
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.add(menu_panel, BorderLayout.SOUTH);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 9; i++) {
            if (actionEvent.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(225));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X turn");
        } else {
            player1_turn = false;
            text_field.setText("O turn");
        }
    }

    public void check() {
        //check X win conditions
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))
        ) {
            xWins(0,1,2);
        }
        else if(
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3,4,5);
        }
        else if(
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6,7,8);
        }
        else if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0,3,6);
        }
        else if(
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1,4,7);
        }
        else if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2,5,8);
        }
        else if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(0,4,8);
        }
        else if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        else if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0,1,2);
        }
        else if(
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3,4,5);
        }
        else if(
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6,7,8);
        }
        else if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0,3,6);
        }
        else if(
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1,4,7);
        }
        else if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2,5,8);
        }
        else if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0,4,8);
        }
        else if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2,4,6);
        }
        // check if Tie
        else {
            int checkTie = 0;
            for(JButton i : buttons){
                if(i.getText().equals("O") || i.getText().equals("X")) {
                    checkTie++;
                }
                if(checkTie==9){
                    Tie();
                }
            }
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X won");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("O won");
    }

    public void Tie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("It's a tie");
    }
}

