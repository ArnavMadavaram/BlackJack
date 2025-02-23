package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;

public class Card extends ImageView {
    static String[] Faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    static String[] Suits = {"Hearts","Spade","Diamond","Clubs"};

    static int height = 130;

    String face;

    String suit;

    public Card(String face, String suit){
        this.face = face;
        this.suit = suit;

        Image cardImage = new Image("file:cards/" + face + "_" + suit + ".png");
        setImage(cardImage);
        setFitHeight(130);
        setPreserveRatio(true);
    }

    public String getFaces(){
        return face;
    }

    public String getSuits(){
        return suit;
    }

    public int valueOf() {
        if (face.equals("J") || face.equals("Q") || face.equals("K")) {
            return 10;
        } else if (face.equals("A")) {
            return 11;
        } else {
            return Integer.parseInt(face);

        }
    }


}
//package project;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//public class Card extends ImageView {
//    static String[] Faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//    static String[] Suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
//    static int height = 130;
//
//    private String face;
//    private String suit;
//
//    public Card(String face, String suit) {
//        this.face = face;
//        this.suit = suit;
//
//        Image cardImage = new Image("file:cards/" + face + "_" + suit + ".png");
//        setImage(cardImage);
//        setFitHeight(height);
//        setPreserveRatio(true);
//    }
//
//    public String getFaces() {
//        return face;
//    }
//
//    public String getSuits() {
//        return suit;
//    }
//
//    public int valueOf() {
//        if (face.equals("J") || face.equals("Q") || face.equals("K")) {
//            return 10;
//        } else if (face.equals("A")) {
//            return 11;
//        } else {
//            return Integer.parseInt(face);
//        }
//    }
//}
//package project;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//public class Card extends ImageView {
//    static String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//    static String[] suits = {"Spade", "Hearts", "Diamond", "Clubs"};
//    static int height = 130;
//
//    private String face;
//    private String suit;
//
//    public Card(String face, String suit) {
//        this.face = face;
//        this.suit = suit;
//        setImage(new Image("file:cards/" + face + "_" + suit + ".png"));
//        setFitHeight(height);
//        setPreserveRatio(true);
//    }
//
//    public String getFace() {
//        return face;
//    }
//
//    public int getValue() {
//        if (face.equals("J") || face.equals("Q") || face.equals("K")) return 10;
//        if (face.equals("A")) return 11;
//        return Integer.parseInt(face);
//    }
//}
//package project;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//public class Card extends ImageView {
//    private static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//    private static final int HEIGHT = 130;
//    private final String face;
//
//    public Card(String face, String suit) {
//        this.face = face;
//        String imagePath = "/cards/" + face + "_" + suit + ".png";
//        this.setImage(new Image(imagePath));
//        this.setFitHeight(HEIGHT);
//        this.setPreserveRatio(true);
//    }
//
//    public String getFace() {
//        return face;
//    }
//
//    public int valueOf() {
//        if ("JQK".contains(face)) return 10;
//        if ("A".equals(face)) return 11; // Handle Ace value in Player class
//        return Integer.parseInt(face);
//    }
//}



