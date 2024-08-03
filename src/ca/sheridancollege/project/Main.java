/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Blackjack");
        BlackjackPlayer player1 = new BlackjackPlayer("Muhammad Butt", 1500);
        BlackjackPlayer dealer = new BlackjackPlayer("Dealer", 10000);

        game.addPlayer(player1);
        game.setDealer(dealer);

        game.play();
        game.declareWinner();
    }
}
