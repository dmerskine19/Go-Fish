package project;

public class NewPlayer extends Player {
/**Sets New Players name, creating an ID.
* @param name - User specified name
**/
public NewPlayer(final String name) {
super(name);
Player.setPlayerID(name);
}
}
