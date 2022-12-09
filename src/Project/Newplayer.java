public class Newplayer extends Player {
/**Sets New Players name, creating an ID.
* @param name - User specified name
**/
public Newplayer(final String name) {
super(name);
Player.setPlayerID(name);
}
}
