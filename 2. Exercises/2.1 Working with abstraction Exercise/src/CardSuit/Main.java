package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String rank = console.nextLine();
        String suits = console.nextLine();

        Card card = new Card(CardSuit.valueOf(suits), CardRanks.valueOf(rank));
        System.out.printf("Card name: %s of %s; Card power: %d",card.getCardRank(),card.getCardSuit(),card.getPower());
    }
}
