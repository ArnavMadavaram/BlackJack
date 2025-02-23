package project;

/**
 * Name: Arnav Madavaram
 * Username: madaa01
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Controller {

    @FXML
    private ImageView dealerImg1;

    @FXML
    private ImageView playerImg1;

    @FXML
    private ImageView dealerImg3;

    @FXML
    private ImageView dealerImg2;

    @FXML
    private ImageView dealerImg5;

    @FXML
    private Label playerWinCountLbl;

    @FXML
    private ImageView dealerImg4;

    @FXML
    private Label winResultLbl;

    @FXML
    private ImageView playerImg5;

    @FXML
    private ImageView playerImg4;

    @FXML
    private ImageView playerImg3;

    @FXML
    private ImageView playerImg2;

    @FXML
    private Button standBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Label dealerWinCountLbl;

    @FXML
    private Button hitBtn;

    @FXML
    private Label currencyLbl;

    @FXML
    private Label dealerHandValueLbl;

    @FXML
    private Label playerHandValueLbl;

    private Player player, dealer;
    private Deck deck;
    private final int betAmount = 10;

    @FXML
    public void initialize() {
        player = new Player();
        dealer = new Player();
        deck = new Deck();
        hitBtn.setDisable(true);
        standBtn.setDisable(true);
        hitBtn.setVisible(false);
        standBtn.setVisible(false);
        playBtn.setOnAction(e -> startGame());
        hitBtn.setOnAction(e -> playerHit());
        standBtn.setOnAction(e -> playerStand());
        loadWins();
        updateCurrencyLabel();
    }

    private void startGame() {
        if (player.getCurrency() < betAmount) {
            winResultLbl.setText("Not enough currency to play!");
            return;
        }
        player.adjustCurrency(-betAmount);
        updateCurrencyLabel();
        resetGame();
        dealer.hit();
        updateCardImages(dealer, dealerImg1);
        playBtn.setVisible(false);
        hitBtn.setDisable(false);
        standBtn.setDisable(false);
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        winResultLbl.setText("");
        updateHandValues();
    }

    private void playerHit() {
        player.hit();
        updateCardImages(player, getNextAvailableImageView(player));

        updateHandValues();

        if (player.busted()) {
            endGame("Bust! Dealer Wins!");
        }
    }

    private void playerStand() {
        while (dealer.valueOfHand() < 17) {
            dealer.hit();
            updateCardImages(dealer, getNextAvailableImageView(dealer));
            updateHandValues();
        }
        int playerValue = player.valueOfHand();
        int dealerValue = dealer.valueOfHand();

        if (dealerValue > 21) {
            endGame("Dealer Busts! Player Wins!");
        } else if (playerValue > dealerValue) {
            endGame("Player Wins!");
        } else if (playerValue == dealerValue) {
            endGame("Push! It's a tie!");
        } else {
            endGame("Dealer Wins!");
        }
    }


    private void endGame(String result) {
        winResultLbl.setText(result);
        if (result.contains("Player Wins")) {
            player.adjustCurrency(betAmount * 2);
            playerWinCountLbl.setText("Player Wins: " + player.win());
        } else if (result.contains("Dealer Wins")) {
            dealerWinCountLbl.setText("Dealer Wins: " + dealer.win());
        }
        updateCurrencyLabel();
        saveWins();
        hitBtn.setDisable(true);
        standBtn.setDisable(true);
        hitBtn.setVisible(false);
        standBtn.setVisible(false);
        playBtn.setVisible(true);
    }

    private void resetGame() {
        deck.reset();
        player.clearHand();
        dealer.clearHand();
        resetCardImages(dealerImg1, dealerImg2, dealerImg3, dealerImg4, dealerImg5);
        resetCardImages(playerImg1, playerImg2, playerImg3, playerImg4, playerImg5);
        dealerHandValueLbl.setText("Value: 0");
        playerHandValueLbl.setText("Value: 0");
    }

    private void resetCardImages(ImageView... images) {
        for (ImageView img : images) {
            img.setImage(null);
        }
    }

    private void updateCardImages(Player p, ImageView img) {
        if (!p.getHand().isEmpty() && img != null) {
            Card latestCard = p.getHand().get(p.getHand().size() - 1);
            img.setImage(new Image("file:cards/" + latestCard.getFaces() + "_" + latestCard.getSuits() + ".png"));
        }
    }

    private ImageView getNextAvailableImageView(Player p) {
        int handSize = p.getHand().size();
        if (p == dealer) {
            return switch (handSize) {
                case 1 -> dealerImg1;
                case 2 -> dealerImg2;
                case 3 -> dealerImg3;
                case 4 -> dealerImg4;
                case 5 -> dealerImg5;
                default -> null;
            };
        } else {
            return switch (handSize) {
                case 1 -> playerImg1;
                case 2 -> playerImg2;
                case 3 -> playerImg3;
                case 4 -> playerImg4;
                case 5 -> playerImg5;
                default -> null;
            };
        }
    }

    private void updateHandValues() {
        dealerHandValueLbl.setText("Value: " + dealer.valueOfHand());
        playerHandValueLbl.setText("Value: " + player.valueOfHand());
    }

    private void updateCurrencyLabel() {
        currencyLbl.setText("Currency: $" + player.getCurrency());
    }

    private void saveWins() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("wins.txt"))) {
            writer.println("Player Wins: " + player.getWins());
            writer.println("Dealer Wins: " + dealer.getWins());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWins() {
        try (Scanner scanner = new Scanner(new File("wins.txt"))) {
            if (scanner.hasNextLine()) player.setWins(scanner.nextInt());
            if (scanner.hasNextLine()) dealer.setWins(scanner.nextInt());
        } catch (Exception ignored) {}
    }
}


