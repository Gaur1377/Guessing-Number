package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe {
    JFrame frame = new JFrame("Tic Tac Toe ");
    JPanel[] p = new JPanel[3];
    JLabel label = new JLabel(" First Player Turn...");
    JButton[] b = new JButton[9];
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");

    ImageIcon icon1 = new ImageIcon(getClass().getResource("x.png"));
    ImageIcon icon2 = new ImageIcon(getClass().getResource("o.png"));
    int pl = 1;

    public TicTacToe(){
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        panl();
        frame.setVisible(true);
    }
    private  void panl(){
        for (int i=0;i<3;i++){
            p[i]=new JPanel();
            frame.add(p[i]);
        }
        p[0].setBounds(45,25,400,40);
        p[1].setBounds(45,90,400,360);
        p[2].setBounds(45,490,400,40);
        aLabel();
    }
    private void aLabel(){
        p[0].add(label);
        label.setFont(new Font("Elephant",Font.PLAIN,25));
        label.setForeground(Color.blue);
        label.setBackground(Color.yellow);
        aButton();
    }
    private void aButton(){
        p[1].setLayout(new GridLayout(3,3));
        TicList listener = new TicList();
        for (int i=0;i< 9;i++){
            b[i] =new JButton();
            b[i].addActionListener(listener);
            b[i].setBackground(Color.cyan);
            p[1].add(b[i]);
        }
        ResetAndExitButton();
    }
    private void ResetAndExitButton(){
        p[2].add(reset);
        p[2].add(exit);
        p[2].setOpaque(false);
        Font f = new Font("arial",Font.PLAIN,25);
        reset.setFont(f);
        exit.setFont(f);
        exit.setForeground(Color.black);
        reset.addActionListener(e -> Reset());
        exit.addActionListener(e -> System.exit(0));
    }

    private void Reset(){
        for (int i = 0; i < 9; i++) {
            b[i].setIcon(null);
            b[i].setEnabled(true);
        }
        pl = 1;
        label.setText("First Player turn...");
        label.setForeground(Color.blue);
        p[0].setBackground(Color.YELLOW);
    }
    private void CheckWinner() {
        int[][] combos = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };

        for (int[] c : combos) {
            Icon i1 = b[c[0]].getIcon();
            Icon i2 = b[c[1]].getIcon();
            Icon i3 = b[c[2]].getIcon();

            if (i1 != null && i1.equals(i2) && i2.equals(i3)) {
                if (i1.equals(icon1)) {
                    declareWinner("Player Wins!", Color.green);
                } else {
                    declareWinner("Cpu Wins!", Color.red);
                    label.setForeground(Color.YELLOW);
                }
                return;
            }
        }

        boolean draw = true;
        for (JButton b : b) {
            if (b.getIcon() == null) {
                draw = false;
                break;
            }
        }

        if (draw) {
            declareWinner("Game Draw!", Color.orange);
            label.setForeground(Color.darkGray);
        }
    }
    private void declareWinner(String message, Color bgColor) {
        label.setText(message);
        label.setForeground(Color.darkGray);
        p[0].setBackground(bgColor);
        for (JButton b : b) {
            b.setEnabled(false);
        }
    }
    private boolean isGameOver() {
        return label.getText().contains("Wins") || label.getText().equals("Game Draw!");
    }

    class TicList implements ActionListener {

        public void actionPerformed(ActionEvent evt){
            JButton bb = (JButton)evt.getSource();
            bb.setIcon(icon1);
            bb.setEnabled(false);
            CheckWinner();
            if (isGameOver()) return;
            cpu();
            CheckWinner();
        }
    }
    private void cpu() {
        java.util.List<JButton> empt = new java.util.ArrayList<>();

        for (JButton btn : b) {
            if (btn.getIcon() == null) {
                empt.add(btn);
            }
        }

        if (empt.isEmpty()) return;

        int index = (int)(Math.random() * empt.size());
        JButton selected = empt.get(index);

        selected.setIcon(icon2);  // CPU move
        selected.setEnabled(false);

        label.setText("Your turn...");
        label.setForeground(Color.white);
        p[0].setBackground(Color.blue);
    }



}
