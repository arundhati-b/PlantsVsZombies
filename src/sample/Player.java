package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Player {
    public static Map<Player,Game> players = new HashMap<Player,Game>();
    private String name;
    private Game game;
    Player(String n)
    {
        name = n;
        game = new Game(this);
        players.put(this,game);
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
