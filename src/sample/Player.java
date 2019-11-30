package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Player implements Serializable,Comparable<Player> {
    public transient static Map<String,Player> players = new HashMap<String,Player>();
    private String name;
    private Game game;
    private int score;
    private int highestLevel;
    Player(String n, Game g)
    {
        name = n;
        game = g;
        players.put(name,this);
        score = 0;
//        score = s;
        highestLevel = 5;
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
    public boolean doesPlayerExist(Player p)
    {
        if(players.containsKey(p))
            return true;
        return false;
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
}
