import java.io.IOException;
import java.util.LinkedList;

public class Engine {
    LinkedList<Server.PlayerConnection> listOfPlayers;
    private boolean isGameOn = true;
    private boolean isRoundOn = true;
    private CardFactory cardFactory;

    public Engine() {
        cardFactory = new CardFactory();
    }

    public void start(Server server) throws IOException {
        cardFactory.getDeck();
        listOfPlayers = server.getList();
        listOfPlayers.get(0).setDeck(cardFactory.cardDealerP1());
        listOfPlayers.get(1).setDeck(cardFactory.cardDealerP2());

        while (isGameOn) {
            if (listOfPlayers.get(0).getDeck().size() == 0) {
                try {
                    if (listOfPlayers.get(0).getScore() > listOfPlayers.get(1).getScore()) {
                        listOfPlayers.get(0).broadcastMessage(listOfPlayers.get(0).getName() + "\u001B[33m"+" Won the Game!");
                        listOfPlayers.get(0).broadcastMessage("\u001B[33m"+"\n"+"\n" +
                                "             ___________\n" +
                                "            '._==_==_=_.'\n" +
                                "            .-\\:      /-.\n" +
                                "           | (|:.     |) |\n" +
                                "            '-|:.     |-'\n" +
                                "              \\::.    /\n" +
                                "               '::. .'\n" +
                                "                 ) (\n" +
                                "               _.' '._\n" +
                                "              `\"\"\"\"\"\"\"`\n");

                    } else if (listOfPlayers.get(0).getScore() < listOfPlayers.get(1).getScore()) {
                        listOfPlayers.get(1).broadcastMessage(listOfPlayers.get(1).getName() + "\u001B[33m"+ " Won the Game");
                        listOfPlayers.get(1).broadcastMessage("\u001B[33m"+"\n"+"\n" +
                                "             ___________\n" +
                                "            '._==_==_=_.'\n" +
                                "            .-\\:      /-.\n" +
                                "           | (|:.     |) |\n" +
                                "            '-|:.     |-'\n" +
                                "              \\::.    /\n" +
                                "               '::. .'\n" +
                                "                 ) (\n" +
                                "               _.' '._\n" +
                                "              `\"\"\"\"\"\"\"`\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                isGameOn = false;
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (listOfPlayers.get(0).getPlayerAnswer() && listOfPlayers.get(1).getPlayerAnswer()) {
                listOfPlayers.get(0).setPlayerAnswer();
                listOfPlayers.get(1).setPlayerAnswer();

                Thread t1 = new Thread(() -> {
                    try {
                        listOfPlayers.get(0).roundPrompt();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                Thread t2 = new Thread(() -> {
                    try {
                        listOfPlayers.get(1).roundPrompt();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                t1.start();
                t2.start();

                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(isRoundOn) {
                    isRoundOn = false;
                    roundCheckWin();

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }


    public void roundCheckWin() {

        Thread t2 = new Thread(() -> {
            try {
                isRoundOn = true;

                if (listOfPlayers.get(0).getCardScore() > listOfPlayers.get(1).getCardScore()) {
                    listOfPlayers.get(0).broadcastMessage(listOfPlayers.get(0).getName() + " Won this round!");
                    listOfPlayers.get(0).setScore(10);
                    listOfPlayers.get(0).broadcastMessage(listOfPlayers.get(0).getName()+" :  "
                            +listOfPlayers.get(0).getScore());
                    listOfPlayers.get(0).broadcastMessage(listOfPlayers.get(1).getName()+" :  "
                            +listOfPlayers.get(1).getScore());
                } else {
                    listOfPlayers.get(0).broadcastMessage(listOfPlayers.get(1).getName() + " Won this round!");
                    listOfPlayers.get(1).setScore(10);
                    listOfPlayers.get(1).broadcastMessage(listOfPlayers.get(0).getName()+" :  "
                            +listOfPlayers.get(0).getScore());
                    listOfPlayers.get(1).broadcastMessage(listOfPlayers.get(1).getName()+" :  "
                            +listOfPlayers.get(1).getScore());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();


    }
}
