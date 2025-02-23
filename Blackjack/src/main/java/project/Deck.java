package project;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
private ArrayList<Card> Cards = new ArrayList<>();
private Random random = new Random();

     Deck() {
        Cards = new ArrayList<>();
        random = new Random();
        reset();
    }

    public Card dealCard(){
        if (Cards.isEmpty()) {
            System.out.println("Deck is empty! Reshuffling...");
            reset();
        }
         int removeRandom = random.nextInt(Cards.size());
         return Cards.remove(removeRandom);
    }

    public void reset(){
         Cards.clear();
         for (String suit : Card.Suits){
             for (String face : Card.Faces){
                 Cards.add(new Card(face,suit));
             }
         }
    }



}
//package project;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//public class Deck {
//    private final ArrayList<Card> cards = new ArrayList<>();
//    private final Random random = new Random();
//    private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
//    private static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//
//    public Deck() {
//        reset();
//    }
//
//    public void reset() {
//        cards.clear();
//        for (String suit : SUITS) {
//            for (String face : FACES) {
//                cards.add(new Card(face, suit));
//            }
//        }
//        Collections.shuffle(cards);
//    }
//
//    public Card dealCard() {
//        return cards.isEmpty() ? null : cards.remove(random.nextInt(cards.size()));
//    }
//}


