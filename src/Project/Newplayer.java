package Project;

public class NewPlayer extends Player{
	public NewPlayer(String name){
		super(name);
		Player.setPlayerID(name);

	}
}
