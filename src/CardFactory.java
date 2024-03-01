import java.util.LinkedList;

public class CardFactory {

    LinkedList<Card> deckList = new LinkedList<Card>();

    public void getDeck() {


        Card card1 = new Card("blue eyes white dragon", 10,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card1);


        Card card2 = new Card("blue eyes white dragon2", 9,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card2);


        Card card3 = new Card("blue eyes white dragon3", 8,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card3);


        Card card4 = new Card("blue eyes white dragon4", 11,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card4);


        Card card5 = new Card("blue eyes white dragon5", 15,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card5);


        Card card6 = new Card("blue eyes white dragon6", 1,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card6);


        Card card7 = new Card("blue eyes white dragon7", 7,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card7);


        Card card8 = new Card("blue eyes white dragon8", 18,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card8);

        Card card9 = new Card("blue eyes white dragon9", 19,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card9);


        Card card10 = new Card("blue eyes white dragon10", 100,
                " /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card10);
    }

    public LinkedList<Card> cardDealerP1() {
        LinkedList<Card> deckP1 = new LinkedList<Card>();
        for (int i = 0; i < 5; i++) {
            int temp = (int) (Math.random() * deckList.size());
            deckP1.add(deckList.get(temp));
            deckList.remove(temp);
        }
        return deckP1;
    }

    public LinkedList<Card> cardDealerP2() {
        return deckList;
    }
}
