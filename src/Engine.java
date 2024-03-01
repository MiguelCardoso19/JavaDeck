import java.io.IOException;
import java.util.LinkedList;

public class Engine {
    LinkedList<Server.PlayerConnection> listOfPlayers;
    private boolean isGameOn = true;
    private Server.PlayerConnection playerConnection;
    private CardFactory cardFactory;

    public Engine() {
        cardFactory = new CardFactory();
    }


    public void start(Server server) {
        cardFactory.getDeck();
        listOfPlayers = server.getList();
        listOfPlayers.get(0).setDeck(cardFactory.cardDealerP1());
        listOfPlayers.get(1).setDeck(cardFactory.cardDealerP2());

        synchronized (listOfPlayers) {
            System.out.println(listOfPlayers.get(0).getName());
            System.out.println(listOfPlayers.get(1).getName());
            while (isGameOn) {
                if (listOfPlayers.get(0).getDeck().size() == 0) {
                    try {
                        if (listOfPlayers.get(0).getScore() > listOfPlayers.get(1).getScore()) {
                            playerConnection.broadcastMessage(listOfPlayers.get(0).getName() + " Won the Game!");
                        } else if (listOfPlayers.get(0).getScore() < listOfPlayers.get(1).getScore()) {
                            playerConnection.broadcastMessage(listOfPlayers.get(1).getName() + "Won the Game");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    isGameOn = false;
                }
                gameRound();
                roundCheckWin();
            }
        }
   }

    public void gameRound() {
       listOfPlayers.get(0).run();
       listOfPlayers.get(1).run();
        /*try {
            listOfPlayers.get(0).roundPrompt();
            listOfPlayers.get(1).roundPrompt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void roundCheckWin() {
        try {
            if (listOfPlayers.get(0).getCardScore() > listOfPlayers.get(1).getCardScore()) {
                playerConnection.broadcastMessage(listOfPlayers.get(0).getName() + " Won this round!");
            } else {
                playerConnection.broadcastMessage(listOfPlayers.get(0).getName() + " Won this round!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
