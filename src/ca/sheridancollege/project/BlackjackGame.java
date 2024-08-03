/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class BlackjackGame extends Game {
    public static GroupOfCards deck;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        initializeDeck();
    }

    public void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.addCard(new Card(rank, suit));
            }
        }
        deck.shuffle();
    }

    public void dealInitialCards() {
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                blackjackPlayer.addCard(deck.getCard());
                blackjackPlayer.addCard(deck.getCard());
            }
        }
        if (getDealer() instanceof BlackjackPlayer) {
            BlackjackPlayer dealer = (BlackjackPlayer) getDealer();
            dealer.addCard(deck.getCard());
            dealer.addCard(deck.getCard());
        }
    }

    public void getTurn() {
        for (Player player : getPlayers()) {
            player.play();
        }
        getDealer().play();
    }

    @Override
    public void play() {
        dealInitialCards();
        getTurn();
    }

    @Override
    public void declareWinner() {
        BlackjackPlayer dealer = (BlackjackPlayer) getDealer();
        int dealerHandValue = dealer.getHandValue();
        System.out.println("Dealer's hand value: " + dealerHandValue);

        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                int playerHandValue = blackjackPlayer.getHandValue();
                System.out.println(blackjackPlayer.getName() + "'s hand value: " + playerHandValue);

                if (playerHandValue > 21) {
                    System.out.println(blackjackPlayer.getName() + " busts. Dealer wins!");
                } else if (dealerHandValue > 21 || playerHandValue > dealerHandValue) {
                    System.out.println(blackjackPlayer.getName() + " wins!");
                } else if (playerHandValue < dealerHandValue) {
                    System.out.println("Dealer wins against " + blackjackPlayer.getName());
                } else {
                    System.out.println(blackjackPlayer.getName() + " ties with the dealer.");
                }
            }
        }
    }
}
