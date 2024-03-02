import java.util.LinkedList;

public class CardFactory {

    LinkedList<Card> deckList = new LinkedList<Card>();

    public void getDeck() {


        Card card1 = new Card("blue eyes white dragon", 10,
                "\n /\\                 /\\\n" +
                        "/ \\'._   (\\_/)   _.'/ \\\n" +
                        "|.''._'--(o.o)--'_.''.|\n" +
                        " \\_ / `;=/ \" \\=;` \\ _/\n" +
                        "   `\\__| \\___/ |__/`\n" +
                        "        \\(_|_)/\n" +
                        "         \" ` \"");
        deckList.add(card1);


        Card card2 = new Card("blue eyes white dragon2", 9,
                "\n     (()__(()\n" +
                        "     /       \\ \n" +
                        "    ( /    \\  \\\n" +
                        "     \\ o o    /\n" +
                        "     (_()_)__/ \\             \n" +
                        "    / _,==.____ \\\n" +
                        "   (   |--|      )\n" +
                        "   /\\_.|__|'-.__/\\_\n" +
                        "  / (        /     \\ \n" +
                        "  \\  \\      (      /\n" +
                        "   )  '._____)    /    \n" +
                        "(((____.--(((____/\n");
        deckList.add(card2);


        Card card3 = new Card("blue eyes white dragon3", 8,
                "\n ,_     _\n" +
                        " |\\\\_,-~/\n" +
                        " / _  _ |    ,--.\n" +
                        "(  @  @ )   / ,-'\n" +
                        " \\  _T_/-._( (\n" +
                        " /         `. \\\n" +
                        "|         _  \\ |\n" +
                        " \\ \\ ,  /      |\n" +
                        "  || |-_\\__   /\n" +
                        " ((_/`(____,-'\n");
        deckList.add(card3);


        Card card4 = new Card("blue eyes white dragon4", 11,
                "\n      (\\-\"\"\"-/)\n" +
                        "       |     |\n" +
                        "       \\ ^ ^ /  .-.\n" +
                        "        \\_o_/  / /\n" +
                        "       /`   `\\/  |\n" +
                        "      /       \\  |\n" +
                        "      \\ (   ) /  |\n" +
                        "     / \\_) (_/ \\ /\n" +
                        "    |   (\\-/)   |\n" +
                        "    \\  --^o^--  /\n" +
                        "     \\ '.___.' /\n" +
                        "    .'  \\-=-/  '.\n" +
                        "   /   /`   `\\   \\\n" +
                        "  (//./       \\.\\\\)\n" +
                        "   `\"`         `\"`\n");
        deckList.add(card4);


        Card card5 = new Card("blue eyes white dragon5", 15,
                "\n  .--,       .--,\n" +
                        " ( (  \\.---./  ) )\n" +
                        "  '.__/o   o\\__.'\n" +
                        "     {=  ^  =}\n" +
                        "      >  -  <\n" +
                        "     /       \\\n" +
                        "    //       \\\\\n" +
                        "   //|   .   |\\\\\n" +
                        "   \"'\\       /'\"_.-~^`'-.\n" +
                        "      \\  _  /--'         `\n" +
                        "    ___)( )(___\n" +
                        "   (((__) (__)))\n");
        deckList.add(card5);


        Card card6 = new Card("a monkey", 1,
                "\n         ||\n" +
                        "         ||\n" +
                        "        _;|\n" +
                        "       /__3\n" +
                        "      / /||\n" +
                        "     / / // .--.\n" +
                        "     \\ \\// / (OO)\n" +
                        "      \\//  |( _ )\n" +
                        "      // \\__/`-'\\__\n" +
                        "     // \\__      _ \\\n" +
                        " _.-'/    | ._._.|\\ \\\n" +
                        "(_.-'     |      \\ \\ \\\n" +
                        "   .-._   /    o ) / /\n" +
                        "  /_ \\ \\ /   \\__/ / /\n" +
                        "    \\ \\_/   / /  E_/\n" +
                        "     \\     / /\n" +
                        "      `-._/-'      \n");
        deckList.add(card6);


        Card card7 = new Card("rei sapo", 7,
                "\n         o  o   o  o\n" +
                        "         |\\/ \\^/ \\/|\n" +
                        "         |,-------.|\n" +
                        "       ,-.(|)   (|),-.\n" +
                        "       \\_*._ ' '_.* _/\n" +
                        "        /`-.`--' .-'\\\n" +
                        "   ,--./    `---'    \\,--.\n" +
                        "   \\   |(  )     (  )|   /\n" +
                        "    \\  | ||       || |  /\n" +
                        "     \\ | /|\\     /|\\ | /\n" +
                        "     /  \\-._     _,-/  \\\n" +
                        "    //| \\\\  `---'  // |\\\\\n" +
                        "   /,-.,-.\\       /,-.,-.\\\n" +
                        "  o   o   o      o   o    o\n");
        deckList.add(card7);


        Card card8 = new Card("pokemon", 18,
                "\n       o        o\n" +
                        "  ___   \\      /   ___\n" +
                        ".` __`-. \\/\\/\\/ .-'__ '.\n" +
                        "( /  \\  \\/(..)\\/  /  \\ )\n" +
                        "\\ \\ O ) ( (oo) ) ( O / /\n" +
                        " \\ \\_/ __>----<__ \\_/ /\n" +
                        "  \".   >_      _<   .\"\n" +
                        "    >   /      \\   < \n" +
                        "   / /( \\      / )\\ \\\n" +
                        "  / `\" _/ ____ \\_ \"' \\\n" +
                        "  \\_.-` A/  & \\A '-._/\n");
        deckList.add(card8);

        Card card9 = new Card("blue eyes white dragon9", 19,
                " \n        ,\n" +
                        "        /|      __\n" +
                        "       / |   ,-~ /\n" +
                        "      Y :|  //  /\n" +
                        "      | jj /( .^\n" +
                        "      >-\"~\"-v\"\n" +
                        "     /       Y\n" +
                        "    jo  o    |\n" +
                        "   ( ~T~     j\n" +
                        "    >._-' _./\n" +
                        "   /   \"~\"  |\n" +
                        "  Y     _,  |\n" +
                        " /| ;-\"~ _  l\n" +
                        "/ l/ ,-\"~    \\\n" +
                        "\\//\\/      .- \\\n" +
                        " Y        /    Y    \n" +
                        " l       I     !\n" +
                        " ]\\      _\\    /\"\\\n" +
                        "(\" ~----( ~   Y.  )\n");
        deckList.add(card9);


        Card card10 = new Card("blue eyes white dragon10", 100,
                "\n              (\n" +
                        "               )\n" +
                        "              (\n" +
                        "        /\\  .-\"\"\"-.  /\\\n" +
                        "       //\\\\/  ,,,  \\//\\\\\n" +
                        "       |/\\| ,;;;;;, |/\\|\n" +
                        "       //\\\\\\;-\"\"\"-;///\\\\\n" +
                        "      //  \\/   .   \\/  \\\\\n" +
                        "     (| ,-_| \\ | / |_-, |)\n" +
                        "       //`__\\.-.-./__`\\\\\n" +
                        "      // /.-(() ())-.\\ \\\\\n" +
                        "     (\\ |)   '---'   (| /)\n" +
                        "      ` (|           |) `\n" +
                        "        \\)           (/\n");
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
