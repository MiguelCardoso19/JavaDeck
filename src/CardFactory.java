import java.util.LinkedList;

public class CardFactory {

    LinkedList<Card> deckList = new LinkedList<Card>();

    public void getDeck() {

        Card card1 = new Card("ZUMBAT", 10,
                "\u001B[33m"+"\n┌─────────────────┐\n" +
                        "│     <ZUMBAT>    │\n" +
                        "│                 │\n" +
                        "│                 │\n" +
                        "│\\               /│\n" +
                        "│\\'._  (\\_/)  _.'/│\n" +
                        "│'._ '-(o.o)-' _.'│\n" +
                        "│ / `;=/ \" \\=;` \\ │\n" +
                        "│`\\__| \\___/ |__/´│\n" +
                        "│     \\(_|_)/     │\n" +
                        "│      \" ` \"      │\n" +
                        "│                 │\n" +
                        "│        SCORE:10 │\n" +
                        "└─────────────────┘"+"\u001B[0m");
        deckList.add(card1);


        Card card2 = new Card("GRIZZLY_GUY", 9,
                "\u001B[33m"+"\n┌─────────────────┐\n" +
                        "│  <GRIZZLY_GUY>  │\n" +
                        "│    ()__(()      │\n" +
                        "│   /     \\ \\     │\n" +
                        "│   \\ o o    )    │\n" +
                        "│   (_()_)__/\\    │\n" +
                        "│   /_,==.___ \\   │\n" +
                        "│  (  |--|     )  │\n" +
                        "│  /\\.|__|'-./\\_  │\n" +
                        "│ /(        /   \\ │\n" +
                        "│ \\ \\      (    / │\n" +
                        "│  ) '.____)   /  │\n" +
                        "│(((__.-(((SCORE:9│\n" +
                        "└─────────────────┘"+"\u001B[0m");
        deckList.add(card2);


        Card card3 = new Card("FELINE_FURY", 8,
              "\n┌─────────────────┐\n" +
                      "│  <FELINE_FURY>  │\n" +
                      "│ ._              │\n" +
                      "│ |\\\\_,-~/        │\n" +
                      "│ / _  _ |    ,--.│\n" +
                      "│(  @  @ )   / ,-'│\n" +
                      "│ \\  _T_/-._( (   │\n" +
                      "│ /         `. \\  │\n" +
                      "│|         _  \\ | │\n" +
                      "│ \\ \\ ,  /      | │\n" +
                      "│  || |-_\\__   /  │\n" +
                      "│ ((_/`(____,-'   │\n" +
                      "│         SCORE:8 │\n" +
                      "└─────────────────┘"

                        );
        deckList.add(card3);


        Card card4 = new Card("JACKED ROO", 5,
                "\n┌─────────────────┐\n" +
                        "│   <JACKED_ROO>  │\n" +
                        "│   (\\-\"\"\"-/)     │\n" +
                        "│    |     |      │\n" +
                        "│    \\ ^ ^ /  .-. │\n" +
                        "│     \\_o_/  / /  │\n" +
                        "│    /`   `\\/  |  │\n" +
                        "│   /       \\  |  │\n" +
                        "│   \\ (   ) /  |  │\n" +
                        "│  / \\_) (_/ \\ /  │\n" +
                        "│ (   (\\-/)   )   │\n" +
                        "│  \\ '.___.' /    │\n" +
                        "│ .'  \\-=-/SCORE:5│\n" +
                        "└─────────────────┘");
        deckList.add(card4);


        Card card5 = new Card("RODENT_ROGUE", 4,
                "\n┌─────────────────┐\n" +
                        "│ <RODENT_ROGUE>  │\n" +
                        "│ .--,       .--, │\n" +
                        "│( (  \\.---./  ) )│\n" +
                        "│ '.__/o   o\\__.' │\n" +
                        "│    {=  ^  =}    │\n" +
                        "│     >  -  <     │\n" +
                        "│   //       \\\\  (│\n" +
                        "│  //|   .   |\\\\ )│\n" +
                        "│  \"' \\     / '\"_/│\n" +
                        "│   ___)(_)(___   │\n" +
                        "│  (((__) (__)))  │\n" +
                        "│         SCORE:4 │\n" +
                        "└─────────────────┘");
        deckList.add(card5);


        Card card6 = new Card("BANANA BANDIT", 3,
                "\n┌─────────────────┐\n" +
                        "│ <BANANA_BANDIT> │\n" +
                        "│ / / // .--.     │\n" +
                        "│ \\ \\// / (OO)    │\n" +
                        "│  \\//  |( _ )    │\n" +
                        "│  // \\__/`-'\\_   │\n" +
                        "│ (( \\__     _ \\  │\n" +
                        "│ ))   | ._._|\\ \\ │\n" +
                        "│.-    |     \\ \\ \\│\n" +
                        "│-._   /    o) / /│\n" +
                        "│ \\ \\ /   \\__// / │\n" +
                        "│\\ \\_/   / / >_/  │\n" +
                        "│ \\     / /SCORE:3│\n" +
                        "└─────────────────┘ ");
        deckList.add(card6);


        Card card7 = new Card("POND_PRINCE", 7,
                "\n┌─────────────────┐\n" +
                        "│  <POND_PRINCE>  │\n" +
                        "│     o  o  o     │\n" +
                        "│     |\\/ \\/|     │\n" +
                        "│     |-----|     │\n" +
                        "│     (.)_(.)     │\n" +
                        "│  _ (   _   ) _  │\n" +
                        "│ / \\/`-----'\\/ \\ │\n" +
                        "│_\\ ( (     ) ) /_│\n" +
                        "│)  /\\ \\._./ /\\  (│\n" +
                        "│ )/ /|\\   /|\\ \\( │\n" +
                        "│   º º º º º º   │\n" +
                        "│         SCORE:7 │\n" +
                        "└─────────────────┘");
        deckList.add(card7);


        Card card8 = new Card("PORKY_PIGASUS", 6,
                "\n┌─────────────────┐\n" +
                        "│ <PORKY_PIGASUS> │\n" +
                        "│ __  o      o  __│\n" +
                        "│'  '. \\/\\/\\/ .'  │\n" +
                        "│   _ \\/(..)\\/ _  │\n" +
                        "│\\ (O)( (oo) )(O) │\n" +
                        "│ \\_   _>--<_   _/│\n" +
                        "│  \". >_    _< .\" │\n" +
                        "│  >   /    \\   < │\n" +
                        "│ / /( \\    / )\\ \\│\n" +
                        "│( '\"_ /____\\ _\"' │\n" +
                        "│ \\_/   /  \\   \\_/│\n" +
                        "│         SCORE:6 │\n" +
                        "└─────────────────┘");
        deckList.add(card8);

        Card card9 = new Card("DEBUGS_BUNNY", 1,
                " \n┌─────────────────┐\n" +
                        "│ <DEBUGS_BUNNY>  │\n" +
                        "│      /|      __ │\n" +
                        "│     / |   ,-~ / │\n" +
                        "│    Y :|  //  /  │\n" +
                        "│    | jj /( .^   │\n" +
                        "│    >-\"~\"-v\"     │\n" +
                        "│   /       Y     │\n" +
                        "│  jo  o    |     │\n" +
                        "│ ( ~T~     j     │\n" +
                        "│  >._-' _./      │\n" +
                        "│ /   \"~\"  \\      │\n" +
                        "│/  .  _,  SCORE:1│\n" +
                        "└─────────────────┘");
        deckList.add(card9);


        Card card10 = new Card("MIRANHA", 2,
                "\n┌─────────────────┐\n" +
                        "│<MIRANHA> )      │\n" +
                        "│         (       │\n" +
                        "│   /\\  .\"\"\".  /\\ │\n" +
                        "│  //\\\\/ ,,, \\//\\\\│\n" +
                        "│  |/\\| ,;;;, |/\\|│\n" +
                        "│ //\\\\\\;- \" -;///\\│\n" +
                        "│ // \\/   .   \\/ \\│\n" +
                        "│(|,-_| \\ | / |_-,│\n" +
                        "│ //`__\\.-.-./__`\\│\n" +
                        "│// /.-(() ())-.\\ │\n" +
                        "│ \\|)   '---'   (|│\n" +
                        "│ `\\)  SCORE:2  (/│\n" +
                        "└─────────────────┘ ");
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
