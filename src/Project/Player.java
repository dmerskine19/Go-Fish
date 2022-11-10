package Project;

public abstract class Player{
    private static String playerID;
	private int  points;
	private String result;
    private String playerName;

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public Player(String name)
    {
        playerID= name;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public static String getPlayerID()
    {
        return playerID;
    }

    public static void setPlayerID(String givenID)
    {
        playerID = givenID;
    }

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public int compareTo(Player o){
        if (this.getPoints() == o.getPoints()){
            return 0;
        }
        else if (this.getPoints() > o.getPoints()){
            return 1;
        }
        else
            return -1;
    }
}
