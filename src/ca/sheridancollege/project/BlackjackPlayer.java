/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class BlackjackPlayer extends Player {
    private GroupOfCards hand;
    private int totalMoney;

    public BlackjackPlayer(String name, int totalMoney) {
        super(name);
        hand = new GroupOfCards(3); 
        this.totalMoney = totalMoney;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        int value = 0;
        int aces = 0;
        for (Card card : hand.showCards()) {
            switch (card.getRank()) {
                case ACE:
                    aces++;
                    value += 11;
                    break;
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    value += 10;
                    break;
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    public Card getLatestCard() {
        return hand.showCards().get(hand.showCards().size() - 1);
    }

    public boolean isDealer() {
        return getName().equals("Dealer");
    }
    
    @Override
    public void play() {
        if (isDealer()) {
            while (getHandValue() < 17) {
                Card newCard = BlackjackGame.deck.getCard();
                addCard(newCard);
                System.out.println("Dealer drew: " + newCard);
            }
            System.out.println("Dealer's final hand value: " + getHandValue());
        } 
        else {
            Scanner scanner = new Scanner(System.in);
            boolean isPlaying = true;

            while (isPlaying && getHandValue() < 21) {
                System.out.println(getName() + "'s hand value: " + getHandValue());
                System.out.println("Do you want to hit or stand? (h/s)");
                String decision = scanner.nextLine();

                if (decision.equalsIgnoreCase("h")) {
                    Card newCard = BlackjackGame.deck.getCard();
                    addCard(newCard);
                    System.out.println("You drew: " + newCard);
                    if (getHandValue() > 21) {
                        System.out.println("Bust! Your hand value is over 21.");
                        isPlaying = false;
                    }
                } 
                else if (decision.equalsIgnoreCase("s")) {
                    isPlaying = false;
                } 
                else {
                    System.out.println("Invalid input. Please type 'h' to hit or 's' to stand.");
                }
            }
        }
    }
}