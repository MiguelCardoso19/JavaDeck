import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public LinkedList<PlayerConnection> listOfPlayers = new LinkedList<PlayerConnection>();
    private static int connectionNumber;
    private Engine engine;
    private CountDownLatch latch;

    public static void main(String[] args) {

        Server server = new Server();
        server.serverStart();

    }

    public LinkedList<PlayerConnection> getList() {
        return listOfPlayers;
    }

    private void serverStart() {
        engine = new Engine();
        latch = new CountDownLatch(2);

        Scanner reader = new Scanner(System.in);
        System.out.println("Set port: ");
        int portNum = Integer.parseInt(reader.nextLine());

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        try (ServerSocket serverSocket = new ServerSocket(portNum)) {

            while (serverSocket.isBound() && connectionNumber < 2) {

                Socket playerSocket = serverSocket.accept();
                connectionNumber++;

                PlayerConnection connection = new PlayerConnection(playerSocket, latch);
                fixedPool.submit(connection);
                listOfPlayers.add(connection);

                if (connectionNumber == 2) {
                    latch.await();
                    engine.start(this);
                }
            }


        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }


    public class PlayerConnection implements java.lang.Runnable {
        private static int arePlayerReady;
        Socket playerSocket;
        private int score;
        private LinkedList<Card> deck;
        private int cardScore;
        PrintWriter out;
        BufferedReader in;
        private String name;
        private CountDownLatch latch;
        private boolean playerAnswer = true;

        public PlayerConnection(Socket playerSocket, CountDownLatch latch) {
            this.playerSocket = playerSocket;
            this.latch = latch;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int arePlayerReady() {
            return arePlayerReady;
        }

        public int getCardScore() {
            return cardScore;
        }

        public boolean getPlayerAnswer(){
            return playerAnswer;
        }

        public void setPlayerAnswer(){
            this.playerAnswer = false;
        }

        public void setScore(int score) {
            this.score += score;
        }

        public void setDeck(LinkedList<Card> deck) {
            this.deck = deck;
        }

        public LinkedList<Card> getDeck() {
            return deck;
        }

        public void run() {
            try {
                out = new PrintWriter(playerSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));

                out.println(" ");
                out.println("\u001B[32m" + "______/\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\_____/\\\\\\________/" +
                        "\\\\\\_____/\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\\\\\\\" +
                        "\\________/\\\\\\\\\\\\\\\\\\__/\\\\\\________/\\\\\\_        \n" +
                        " _____\\/////\\\\\\///____/\\\\\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\_______\\/\\\\\\___/\\\\\\\\\\" +
                        "\\" + "\\\\\\\\\\\\\\__\\/\\\\\\////////\\\\\\__\\/\\\\\\///////////______/\\\\\\////////__\\/\\\\\\" +
                        "_____/\\\\\\//__       \n" +
                        "  _________\\/\\\\\\______/\\\\\\/////////\\\\\\_\\//\\\\\\______/\\\\\\___/\\\\\\/////////\\\\" +
                        "\\_\\/\\\\\\______\\//\\\\\\_\\/\\\\\\_______________/\\\\\\/___________\\/\\\\\\__/\\\\\\//_____      \n" +
                        "   _________\\/\\\\\\_____\\/\\\\\\_______\\/\\\\\\__\\//\\\\\\____/\\\\\\___\\/\\\\\\_______\\" +
                        "/\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\______/\\\\\\_____________\\/\\\\\\" +
                        "\\\\\\//\\\\\\_____     \n" +
                        "    _________\\/\\\\\\_____\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\___\\//\\\\\\__/\\\\\\____\\/\\\\" +
                        "\\\\\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\///////______\\/\\\\\\___________" +
                        "__\\/\\\\\\//_\\//\\\\\\____    \n" +
                        "     _________\\/\\\\\\_____\\/\\\\\\/////////\\\\\\____\\//\\\\\\/\\\\\\_____\\/\\\\\\///////" +
                        "//\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\_____________\\//\\\\\\____________\\/\\\\\\____\\" +
                        "//\\\\\\___   \n" +
                        "      __/\\\\\\___\\/\\\\\\_____\\/\\\\\\_______\\/\\\\\\_____\\//\\\\\\\\\\______\\/\\\\\\__" +
                        "_____\\/\\\\\\_\\/\\\\\\_______/\\\\\\__\\/\\\\\\______________\\///\\\\\\__________\\/\\\\\\_" +
                        "____\\//\\\\\\__  \n" +
                        "       _\\//\\\\\\\\\\\\\\\\\\______\\/\\\\\\_______\\/\\\\\\______\\//\\\\\\_______\\/\\\\\\_" +
                        "______\\/\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\/___\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\____\\////\\\\" +
                        "\\\\\\\\\\\\\\_\\/\\\\\\______\\//\\\\\\_ \n" +
                        "        __\\/////////_______\\///________\\///________\\///________\\///________\\///__\\//////" +
                        "//////_____\\///////////////________\\/////////__\\///________\\///__" + "\u001B[0m");

                out.println("\u001B[36m" + "\n       JavaDeck is a multiplayer text-based card game developed in Java by Miguel" +
                        " Cardoso and Pedro Ferreira during their\n" +
                        "       Full Stack Bootcamp at Code for All during a weekend-long challenge.\n" +
                        "       The game features hybrid animal-themed cards with unique scores.\n" +
                        "       Players engage in strategic battles, comparing scores at each round and drawing cards until " +
                        "their hands are empty."+"\u001B[0m");

                out.println(" ");
                out.println("Enter your name below");

                Thread.currentThread().setName("\u001B[35m" + in.readLine() + "\u001B[0m");
                name = Thread.currentThread().getName();
                out.println("Waiting for the opponent to connect");
                arePlayerReady++;
                latch.countDown();


            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }

        public void roundPrompt() throws IOException {
            String[] optionsArray = new String[deck.size()];

            for (int i = 0; i < deck.size(); i++) {
                optionsArray[i] = deck.get(i).getGraphic();
            }

            Prompt prompt = new Prompt(playerSocket.getInputStream(), new PrintStream(playerSocket.getOutputStream()));
            MenuInputScanner roundPrompt = new MenuInputScanner(optionsArray);
            roundPrompt.setMessage("Chose a card to play");
            int answerIndex = prompt.getUserInput(roundPrompt);
            cardScore = deck.get(answerIndex -1).getScore();
            out.println("You chose " + optionsArray[answerIndex - 1]);
            deck.remove(answerIndex - 1);
            playerAnswer = true;
        }

        public void broadcastMessage(String message) throws IOException {
                for (int i = 0; i < listOfPlayers.size(); i++) {
                    Socket player = listOfPlayers.get(i).playerSocket;
                    PrintWriter clientOut = new PrintWriter(player.getOutputStream(), true);
                    clientOut.println(message);
                }
            }
        }
    }