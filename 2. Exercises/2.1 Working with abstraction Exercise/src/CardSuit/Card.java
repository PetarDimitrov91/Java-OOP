package CardSuit;

public class Card {
    private CardSuit cardSuit;
    private CardRanks cardRank;
    private int power;


    public Card(CardSuit suit, CardRanks rank) {
        this.cardSuit = suit;
        this.cardRank = rank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }

    public int getPower() {
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }


}
