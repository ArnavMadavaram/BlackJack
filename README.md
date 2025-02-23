Blackjack Game - JavaFX

Overview

This project is a feature-rich Blackjack game developed in Java using JavaFX. The game follows traditional Blackjack rules while incorporating dynamic UI elements, currency management, and persistent win tracking. Designed with object-oriented principles, it ensures smooth gameplay with real-time updates, making it an excellent demonstration of event-driven programming and software design patterns.

# Features
Interactive Gameplay – Play against an AI dealer with fully functional game mechanics.
Dynamic UI with JavaFX – Cards are displayed visually, and the game state updates in real time.
Deck Management & Shuffling – A full deck of 52 cards is shuffled randomly for each game.
Hit, Stand, and Bust Mechanics – Implements standard Blackjack rules, including ace value adjustments.
Currency System – Players start with a balance and place bets before each round.
Win Tracking & Persistence – Win/loss records are stored and loaded from a file for continuity.
Push (Tie) Handling – If both player and dealer have the same hand value, the bet is refunded.

# Technologies Used
Java – Core game logic and backend processing.
JavaFX – Graphical user interface (GUI) and event-driven interactions.
File I/O – Saving and loading game statistics for persistent player history.
Object-Oriented Programming (OOP) – Implementing encapsulation, inheritance, and polymorphism.
Model-View-Controller (MVC) – Separating game logic from UI for scalability and maintainability.
How to Run the Game

# Prerequisites
Install JDK 21+
Install JavaFX (if not bundled with your JDK)
Clone this repository using:
git clone https://github.com/yourusername/blackjack-game.git
Navigate to the project directory:
cd blackjack-game
Compile and run the game:
mvn javafx:run

# Game Rules
The player and dealer start with two cards each.
The player can hit (draw a card) or stand (end their turn).
Aces can count as 1 or 11 depending on the best possible hand.
If the total value exceeds 21, the player or dealer busts and loses.
The dealer must hit until reaching at least 17.
A push (tie) results in a refund of the player's bet.
The player wins by having a higher hand value than the dealer without busting.

# Project Structure
blackjack-game/
│── src/main/java/project/
│   ├── App.java           # Main JavaFX application entry point
│   ├── Controller.java    # Game controller handling UI interactions
│   ├── Card.java          # Card class representing individual playing cards
│   ├── Deck.java          # Deck class managing deck operations
│   ├── Player.java        # Player class managing player actions and stats
│── src/main/resources/
│   ├── main.fxml          # JavaFX UI layout
│   ├── cards/             # Directory containing card images
│── wins.txt               # Persistent storage for win records
│── README.md              # Project documentation
│── pom.xml                # Maven configuration

# Future Enhancements
Multiplayer Mode – Allow multiple players to compete against the dealer.
Advanced AI Dealer – Introduce different AI playing strategies.
Bet Customization – Let players adjust bet amounts dynamically.
Leaderboard – Track player statistics across multiple sessions.
Sound Effects & Animations – Improve the game’s visual appeal.

# Why This Project Matters
This project is more than just a simple game—it’s a testament to problem-solving, logic-building, and clean software architecture. It demonstrates the power of event-driven programming, UI development, and data persistence, making it a great portfolio piece for anyone passionate about software engineering.

# Contributing
Contributions are welcome! If you have suggestions or find issues, feel free to open a pull request or report a bug.

# License
This project is licensed under the MIT License – feel free to modify and distribute it.
