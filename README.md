# 🕹️ Tic Tac Toe in Java

A simple **Tic Tac Toe (X/O) game** implemented using Java and Swing. Two players can take turns to play on the same machine. The game features a graphical interface with clickable buttons for easy interaction.

## ✨ Features

- Two-player game (X vs O)
- GUI using `JFrame`, `JButton`, and layout managers
- Win detection for rows, columns, and diagonals
- Draw detection
- Reset and replay functionality (optional extension)

## 🧰 Technologies Used

- Java SE
- Swing (JFrame, JPanel, JButton, JLabel)
- Java AWT for basic layout and event handling

## 📸 Screenshot

![image](https://github.com/user-attachments/assets/d7b2182c-d30b-4116-bd53-87ec4a2e6a31)


## 🚀 Getting Started

### Prerequisites

Make sure you have **Java JDK 8 or higher** installed.

### Run the Game

1. Clone this repository:
   ```bash
   git clone https://github.com/ob22a/Tic-Tac-Toe.git
   cd tic-tac-toe

2. Compile the code:
```bash
javac main.java
```

3. Run the game:
```bash
java main
```
🧠 How It Works
The game board is a 3x3 grid of buttons.

Players click on an empty button to place their symbol (X or O).

The game checks for:

3 in a row (horizontal, vertical, or diagonal)

Full board with no winner (draw)

A dialog announces the result, and the board can be reset.

🛠️ Optional Enhancements
Add a Reset button

Track score history

Implement single-player mode with basic AI

Add keyboard shortcuts or sounds

📁 File Structure
```arduino
Tic-Tac-Toe/
├── ticTacToe.java       
├── option.java
├── main.java # Main game class
└── README.md
