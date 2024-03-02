import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public LinkedList<PlayerConnection> listOfPlayers = new LinkedList<PlayerConnection>();
    private static int connectionNumber;

    public static void main(String[] args) {

        Server server = new Server();
        server.serverStart();

    }

    public LinkedList<PlayerConnection> getList(){
        return listOfPlayers;
    }

    private void serverStart(){
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            while (serverSocket.isBound() && connectionNumber < 2) {

                System.out.println("##### GAME SERVER INITIALIZED #####");
                Socket playerSocket = serverSocket.accept();
                connectionNumber++;
                ExecutorService fixedPool = Executors.newFixedThreadPool(2);
                PlayerConnection connection = new PlayerConnection(playerSocket);
                fixedPool.submit(connection);
                listOfPlayers.add(connection);
                Engine engine = new Engine();
                if(connectionNumber == 2 && listOfPlayers.get(0).getName() != null &&
                listOfPlayers.get(1).getName() != null) {
                    engine.start(this);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
    public class PlayerConnection implements java.lang.Runnable {
        Socket playerSocket;
        private int score;
        private LinkedList<Card> deck;
        private int cardScore;
        PrintWriter out;
        BufferedReader in;
        private String name = Thread.currentThread().getName();
        public PlayerConnection(Socket playerSocket) {
            this.playerSocket = playerSocket;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
        public int getCardScore(){
            return cardScore;
        }

        public void setScore(int score) {
            this.score += score;
        }

        public void setDeck(LinkedList<Card> deck){
            this.deck = deck;
        }

        public LinkedList<Card> getDeck(){
            return deck;
        }

        public void run() {

            try {
                out = new PrintWriter(playerSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));

                String[] colors = {"\u001B[31m", "\u001B[32m", "\u001B[33m",
                        "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};
                int randomIndexOfColors = (int) (Math.random() * colors.length);

                out.println(" ");
                out.println("\u001B[32m" + "########## WELCOME TO THE CARD GAME ########## " + "\u001B[0m");
                out.println(" ");
                out.println("Enter your name below");
                Thread.currentThread().setName(colors[randomIndexOfColors] + in.readLine() + "\u001B[0m");

                roundPrompt();

            } catch (IOException e) {
                throw new RuntimeException(e);

            }


        }

        public void roundPrompt() throws IOException {
            String[] optionsArray = new String[deck.size()];

            for (int i=0; i < deck.size(); i++){
                optionsArray[i] = deck.get(i).getGraphic();
            }

            Prompt prompt = new Prompt(playerSocket.getInputStream(), new PrintStream(playerSocket.getOutputStream()));
            MenuInputScanner roundPrompt = new MenuInputScanner(optionsArray);
            roundPrompt.setMessage("Chose a card to play");
            int answerIndex = prompt.getUserInput(roundPrompt);
            cardScore = deck.get(answerIndex).getScore();
            out.println("You chose " + optionsArray[answerIndex - 1]);
            deck.remove(answerIndex);
        }
        public void broadcastMessage(String message) throws IOException {
            synchronized (listOfPlayers) {
                for (int i = 0; i < listOfPlayers.size(); i++) {
                    Socket player = listOfPlayers.get(i).playerSocket;
                    PrintWriter clientOut = new PrintWriter(player.getOutputStream(), true);
                        clientOut.println(message);
                }
            }
        }
    }
}