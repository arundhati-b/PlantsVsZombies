package sample;

public class Game {
    private Player player;
    private Level level;
    private int totalScore;
    private transient static Game game;

    private Game(String p)
    {
        player = new Player(p,this);
//        level = new Level1();
        totalScore = 0;
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

    public static Game getInstance(String p)
    {
        if(game == null)
            game = new Game(p);
        return game;
    }

    public static void clear()
    {
        game = null;
    }


//    public void playGame()
//    {
//        while (true)
//        {
//            try
//            {
//                level.play();
//                setNextLevel();
//            }
//            catch (GameLostException e)
//            {
//
//            }
//            catch(GameWinException e)
//            {
//
//            }
//        }
//    }
//    public void setNextLevel() throws GameWinException
//    {
//        switch (level.getLvlNo())
//        {
//            case 1: level = new Level2();
//            break;
//            case 2: level = new Level3();
//            break;
//            case 3: level = new Level4();
//            break;
//            case 4: level = new Level5();
//            break;
//            case 5: throw new GameWinException();
//        }
//    }
}
