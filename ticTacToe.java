import java.awt.*;
import javax.swing.*;

public class ticTacToe extends JFrame{
    static char startPlayer;
    private char[][] board;
    private JButton[][] buttons;
    private JLabel status;
    private char currentPlayer;

    public ticTacToe(){
        currentPlayer=startPlayer;
        if(currentPlayer!='X' || currentPlayer!='O') System.out.println("Error");
        board = new char[3][3];
        buttons = new JButton[3][3];
        setLayout(new BorderLayout());
        setResizable(false);
        initializeBoard();
        initializeGUI();
    }

    private void initializeGUI(){
        
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.setPreferredSize(new Dimension(300,300));
        gamePanel.setBackground(new Color(0x123456));
        
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial",Font.BOLD,60));
                buttons[i][j].setFocusable(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                final int row=i,col=j;

                buttons[i][j].addActionListener(_ ->{
                    makeMove(row, col);
                    buttons[row][col].setEnabled(false);
                });
                gamePanel.add(buttons[i][j]);
            }
        }
        status = new JLabel("Player " + currentPlayer + "'s turn");
        status.setFont(new Font("Arial", Font.PLAIN, 20));

        add(status,BorderLayout.SOUTH);
        add(gamePanel);
        
        setTitle("Tic Tac Toe");
        try {
            ImageIcon icon = new ImageIcon("TicTacToe.jfif");
            if(icon.getImageLoadStatus()==MediaTracker.COMPLETE) setIconImage(icon.getImage());
            else System.out.println("Warning: TicTacToe.jfif not found or invalid.");
        } catch (Exception e) {
            System.out.println("Error Loading icon: "+e.getMessage());
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    private void initializeBoard(){
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                board[i][j]=' ';
            }
        }
    }

    private boolean isFull(){
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board[i][j]==' ') return false;
            }
        }
        return true;
    }

    private boolean checkWinner(){
        for(int i=0;i<3;++i){
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer) return true;
            if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer) return true;
        }
        if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) return true;
        else if(board[2][0]==currentPlayer && board[1][1]==currentPlayer && board[0][2]==currentPlayer) return true;
        
        return false;
    }

    private void switchPlayer(){
        currentPlayer = (currentPlayer=='O')?'X':'O';
    }

    private void makeMove(int row,int col){
        board[row][col]=currentPlayer;
        buttons[row][col].setText(String.valueOf(currentPlayer));
        setColor(row, col);
        buttons[row][col].setEnabled(false);

        if (checkWinner()){
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!","Game Over",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } 
        else if (isFull()){
            JOptionPane.showMessageDialog(this, "It's a draw!","Game Over",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } 
        else{
            switchPlayer();
            status.setText("Player " + currentPlayer + "'s turn");
        }
    }
    private void setColor(int row,int col){
        if(currentPlayer=='X'){
            buttons[row][col].setBackground(Color.RED);
            
        }
        else{
            buttons[row][col].setBackground(Color.GREEN);
        }
    }
}
