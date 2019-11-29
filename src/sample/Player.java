package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Player implements Serializable {
    public static Map<String,Player> players = new HashMap<String,Player>();
    private String name;
    private Game game;
    Player(String n, Game g)
    {
        name = n;
        game = g;
        players.put(name,this);
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
    public boolean doesPlayerExist(Player p)
    {
        if(players.containsKey(p))
            return true;
        return false;
    }
    public String getName() {
        return name;
    }
    public Game getGame() {
        return game;
    }
}
