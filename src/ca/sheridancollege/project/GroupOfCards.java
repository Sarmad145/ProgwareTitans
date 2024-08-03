/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards {
    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int givenSize) {
        cards = new ArrayList<>();
        size = givenSize;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public void clear() {
        cards.clear();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    public ArrayList<Card> showCards() {
        return cards;
    }
}
