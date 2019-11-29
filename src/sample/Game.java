package sample;

public class Game {
    Player player;
    Level level;
    int totalScore;

    Game(String p)
    {
        player = new Player(p,this);
//        level = new Level1();
        totalScore = 0;
    }

    public String getLevel()
    {
        return level.toString();
    }
    public void setLevel(Level i)
    {
        level = i;
    }
    public Player getPlayer()
    {
        return player;
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
