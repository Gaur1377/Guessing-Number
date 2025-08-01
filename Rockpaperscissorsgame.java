import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Rockpaperscissorsgame {
    JFrame frame= new JFrame("Rock paper and Scissor");
    JPanel [] pa = new JPanel[5];
    JLabel label = new JLabel("Start game");
    JLabel label1 = new JLabel();
    JButton [] btn = new JButton[3];
    JButton Reset = new JButton("Reset");
    JButton Exit = new JButton("Exit");




    ImageIcon icon1 = new ImageIcon(getClass().getResource("Images/Rock.png"));
    ImageIcon icon2 = new ImageIcon(getClass().getResource("Images/Scissor.png"));
    ImageIcon icon3 = new ImageIcon(getClass().getResource("Images/Papar.png"));

    String[] choice = {"Rock","Scissor","Paper"};
    ImageIcon[] icons = {icon1,icon2,icon3};


    public Rockpaperscissorsgame(){
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paneladd();
        frame.setVisible(true);
    }
    private void paneladd(){
        for (int i=0;i<5;i++){
            pa[i] = new JPanel();
            //pa[i].setOpaque(false);
            frame.add(pa[i]);
        }
        pa[0].setOpaque(false);
        pa[3].setOpaque(false);
        pa[0].setBounds(45,25,400,40);
        pa[1].setBounds(45,80,200,200);
        pa[2].setBounds(245,80,200,200);
        pa[3].setBounds(45,290,400,200);
        pa[4].setBounds(45,500,400,30);
        pa[1].setBackground(Color.YELLOW);
        Labeladd();
    }

    private void Labeladd(){
        pa[0].add(label);
        label.setFont(new Font("Elephant",Font.PLAIN,25));
        label.setForeground(Color.white);
        label.setBackground(Color.yellow);
        Buttomadd();
    }

    private void Buttomadd(){
        pa[2].setLayout(new GridLayout(3,1));
        TicList listener = new TicList();
        for (int i=0;i<3;i++) {
            btn[i] = new JButton(choice[i]);
            btn[i].setHorizontalAlignment(SwingConstants.LEFT);
            btn[i].addActionListener(listener);
            btn[i].setBackground(Color.cyan);
            pa[2].add(btn[i]);

        }
        ResetandExitButton();
    }
    private  void ResetandExitButton(){
        pa[4].setLayout(new GridLayout(1,2));
        pa[4].add(Reset);
        pa[4].add(Exit);

        Reset.addActionListener(e -> ResetGame());
        Exit.addActionListener(e -> System.exit(0));
    }
    private void ResetGame(){
        for (JButton b: btn){
            b.setEnabled(true);
        }
        pa[1].removeAll();
        pa[3].removeAll();
        pa[1].revalidate();
        pa[1].repaint();
        pa[3].revalidate();
        pa[3].repaint();
        label.setText("Make Your Move!");
    }


    class TicList implements ActionListener {

        public void actionPerformed(ActionEvent evt){
            JButton bb = (JButton)evt.getSource();
            int userIndex = -1;
            for (int i=0;i<3;i++){
                if (bb==btn[i]){
                    userIndex = i;
                    break;
                }
            }
            pa[1].removeAll();
            pa[1].add(new JLabel(icons[userIndex]));
            pa[1].revalidate();
            pa[1].repaint();
            for (JButton b : btn){
                b.setEnabled(false);
            }
            int cpuIndex = new Random().nextInt(3);
            Cpu(cpuIndex);
            GetWinner(userIndex,cpuIndex);
        }
    }
    private void  Cpu(int cpuIndex){

        pa[3].removeAll();
        pa[3].add(new JLabel(icons[cpuIndex]));
        pa[1].revalidate();
        pa[1].repaint();


    }

    private void GetWinner(int user, int cpu){
        if (user == cpu)
            label.setText("Draw!");
        else if ((user == 0 && cpu == 1)||(user == 1 && cpu == 2)||(user == 2 && cpu == 0)) {
            label.setText("You Win!");
        }
        else{
            label.setText("CPU Wins!");
        }
    }



}



