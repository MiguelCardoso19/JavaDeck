public class Card {

    private String name;
    private int score;
    private String graphic;

    public Card(String name, int score, String graphic){
        this.name = name;
        this.score = score;
        this.graphic = graphic;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGraphic() {
        return graphic;
    }
}
