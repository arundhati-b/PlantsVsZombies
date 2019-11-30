package sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class playerList implements Serializable {
    private Map<String,Player> players;
    private static playerList list;

    private playerList()
    {
        players = new HashMap<>();
    }

    public static playerList getInstance()
    {
        if(list == null)
        {
            list = new playerList();
        }
        return list;
    }

    public static playerList getInstance(playerList l)
    {
        list = l;
        return list;
    }

    public Map<String, Player> getList()
    {
        return players;
    }

    public boolean doesPlayerExist(Player p)
    {
        if(players.containsKey(p))
            return true;
        return false;
    }

    public void addPlayer(Player p)
    {
        players.put(p.getName(),p);
    }
}
