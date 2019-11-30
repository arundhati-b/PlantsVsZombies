package sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;

public class Game implements Serializable {
    private Player player;
    private Level level;
    private transient static Game game;

    private Game(Player p)
    {
        player = p;
        level = new Level1(2,8);
    }

    public Level getLevel()
    {
        return level;
    }
    public void setLevel(Level i)
    {
        level = i;
    }
    public Player getPlayer()
    {
        return player;
    }

    public static Game getInstance()
    {
        return game;
    }

    public static Game getInstance(Player p)
    {
        if(game == null)
            game = new Game(p);
        return game;
    }
    public static Game getInstance(Game g)
    {
        if(game == null)
            game = g;
        return game;
    }

    public static void setClear()
    {
        game = null;
    }


    public int playGame()
    {

        while (true)
        {
            try
            {
                level.play();
                setNextLevel();
            }
            catch(GameLostException e)
            {
                return -1;
            }
            catch(GameWinException e)
            {
                return 0;
            }
        }
    }
    public void setNextLevel() throws GameWinException
    {
        switch (level.getLvlNo())
        {
            case 1: level = new Level2(8,15);
                Player.getInstance().setHighestLevel(max(Player.getInstance().getHighestLevel(),level.getLvlNo()));
            break;
            case 2: level = new Level3(9,18);
                Player.getInstance().setHighestLevel(max(Player.getInstance().getHighestLevel(),level.getLvlNo()));
            break;
            case 3: level = new Level4(10,22);
                Player.getInstance().setHighestLevel(max(Player.getInstance().getHighestLevel(),level.getLvlNo()));
            break;
            case 4: level = new Level5(11,25);
                Player.getInstance().setHighestLevel(max(Player.getInstance().getHighestLevel(),level.getLvlNo()));
            break;
            case 5: throw new GameWinException();

        }
    }

    public void print()
    {
        player.print();
        level.print();
    }
}
