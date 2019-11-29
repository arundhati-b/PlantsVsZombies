package sample;

public class Game {
    Player player;
    Level level;

    Game(Player p)
    {
        player = p;
        level = new Level1();
    }

    public String getLevel()
    {
        return level.toString();
    }
    public void setLevel(Level i)
    {
        level = i;
    }
}
