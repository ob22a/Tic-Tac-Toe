import java.awt.*;
import javax.swing.*;

public class option extends JFrame {
    JLabel message = new JLabel("Choose one");
    JButton buttonX= new JButton("X");
    JButton buttonO= new JButton("O");
    public option() throws HeadlessException {
        add(message);
        add(buttonX);
        add(buttonO);

        buttonX.addActionListener(_ -> {
            ticTacToe.startPlayer='X';
            startGame();
        });

        buttonO.addActionListener(_ ->{
            ticTacToe.startPlayer='O';
            startGame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        pack();
    }
    public void startGame(){
        dispose();
        new ticTacToe();
    }
}
