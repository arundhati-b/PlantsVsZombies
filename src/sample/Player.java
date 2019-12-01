package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Player implements Serializable,Comparable<Player> {

    private transient static Player player = null;
//    public Map<String,Player> players = new HashMap<String,Player>();
    private String name;
    private Game game;
    private int score;
    private int highestLevel;
    private int currentLevel;
    private Player(String n)
    {
        name = n;
        playerList.getInstance().addPlayer(this);
        score = 0;
//        score = s;
        highestLevel = 1; // change to 1
    }
    public void saveValues(int updatedScore)
    {
        score += updatedScore;
    }
    public static Player getInstance()
    {
        return player;
    }
    public static Player getInstance(String n)
    {
        if(player == null) {
            player = new Player(n);
        }
        return player;
    }
    public static Player getInstance(Player p)
    {
        if(player == null) {
            player = p;
        }
        return player;
    }

    public static void setClear()
    {
        player = null;
    }
    public void setGame(Game g)
    {
        game = g;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o.getClass() != this.getClass())
            return false;
        Player p = (Player) o;
        if(p.name.equalsIgnoreCase(name))
            return true;
        return false;
    }
    @Override
    public int compareTo(Player p)
    {
        if(score > p.score)
            return 1;
        else if(score < p.score)
            return -1;
        return 0;
    }

    @Override
    public String toString()
    {
        return name+" "+score;
    }
    public String getName() {
        return name;
    }
    public Game getGame() {
        return game;
    }

    public int getScore() {
        return score;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public void setHighestLevel(int l)
    {
        highestLevel = l;
    }

    public void print()
    {
//        System.out.println("Total players registered: "+players.size());
        System.out.println("Player name: "+name);
        System.out.println("Score: "+score);
        System.out.println("Highest Level: "+highestLevel);
    }

}
