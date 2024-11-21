# TicTacToeGame

A Java-based Tic-Tac-Toe game with multiple difficulty levels, allowing players to compete against an AI opponent. The game includes features such as user input validation, dynamic difficulty adjustment, and a clean, functional user interface.

## Features

- **Multiple Difficulty Levels**: Easy, Medium, and Hard.
- **Dynamic Difficulty Adjustment**: The game becomes more challenging as the player wins.
- **User Input Validation**: Ensures valid moves are made.
- **AI Opponent**: The computer makes moves based on the selected difficulty level.
- **Clean and Functional UI**: Simple text-based interface for easy interaction.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Eclipse IDE or any other Java IDE
- Git (for version control)

### Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/codewithmak/TicTacToeGame.git
**Open the project in Eclipse:**

2. **Open Eclipse.**
- Go to File > Open Projects from File System....
- Select the cloned repository directory.
- Click Finish.

3. **Build the project**:

- Right-click on the project in the Project Explorer.
- Select Build Project.


## Usage
1. **Run the game**:
- Right-click on the TicTacToe class in the src/tictactoe package.
- Select Run As > Java Application.

2. **Play the game**:
- Follow the on-screen instructions to make your moves.
- Enter the column number first, followed by the row number, when prompted.


## Code Structure
- **TicTacToe.java**: Main class containing the game logic.
- **module-info.java**: Module descriptor (if using Java modules).
  
### Main Methods and Functionality
- initializeBoard(): Initializes the game board with empty spaces.
- printBoard(): Prints the current state of the board.
- isBoardFull(): Checks if the board is full.
- checkForWin(): Checks if there is a winner.
- checkRows(), checkColumns(), checkDiagonals(): Helper methods to check for a win.
- checkRowCol(): Checks if three values are the same (indicating a win).
- changePlayer(): Switches the current player.
- placeMark(): Places a mark on the board.
- computerMove(): Makes a move for the computer based on the difficulty level.
- easyMove(), mediumMove(), hardMove(): Different strategies for the computer's moves.
- blockPlayer(): Blocks the player if they are about to win.
- takeCenter(), takeCorner(): Strategies for the computer to take the center or a corner.
  
## Contributing
1. Fork the repository.
2. Create a new branch:
  ``git checkout -b feature/YourFeatureName
  ``
3. Make your changes.
4. Commit your changes:
  ``git commit -m "Add some feature"
  ``
5. Push to the branch:
  ``git push origin feature/YourFeatureName
  ``
6. Open a pull request.


### Acknowledgments
- Inspired by classic Tic-Tac-Toe games.
- Developed as a learning project for Java programming.
