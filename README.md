 # Minesweeper

## Overview

Minesweeper is a Java Swing application that provides a simple and intuitive implementation of the classic Minesweeper game. The objective of the game is to uncover all the cells on the grid without triggering any mines. The game features an easy-to-use graphical interface with basic game functionality.

## Features

- User-friendly interface with Java Swing.

- Customizable grid size and number of mines.

- Right-click to flag suspected mines.

- Left-click to reveal cells.

- Automatically ends the game when a mine is triggered.

-Displays the number of mines remaining and the timer.

## How to play?

- Clone the repository:

```git clone https://github.com/yourusername/easy-minesweeper.git```

```cd easy-minesweeper```

- Open the project in your IDE or build tool.

- Compile and run the application:

```javac src/*.java```

```java src/MainFrame```

Alternatively, if using an IDE, run the Main class directly.

## Usage

Start the Game: Run the application to start the game.

Play the Game:

- Left-click on a cell to reveal it.

- Right-click on a cell to flag it as a mine.

- Game Over: The game ends if you click on a mine. The application will display the positions of all mines and the game status.

## How It Works

Game Components

- Grid: The game grid is a matrix of cells that can either be empty, contain a mine, or show a number indicating adjacent mines.

- Cells: Each cell can be revealed or flagged. Revealed cells display their contents, while flagged cells indicate suspected mines.

- Mine Counter: Shows the number of remaining mines to be flagged.

## Implementation Details

- Java Swing: The graphical user interface (GUI) is built using Java Swing components, such as JFrame, JPanel, and JButton.
  
- Game Logic: The game logic includes generating the grid, placing mines, counting adjacent mines, and handling user interactions.
- 
- Event Handling: Mouse events are used to handle user actions, such as revealing cells and flagging mines.
