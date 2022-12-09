class Player {
    /**Unique ID given to each player.**/
    private static String playerID;
    /**Sets each player's ID to the given name.
     * @param name - User inputted name
     **/
    Player(final String name) {
        playerID = name;
    }
    /**@return player name as a string.**/
    private static String getPlayerID() {
        return playerID;
    }
    /**Sets each player's ID to the given ID.
     * @param givenID - User inputted name
     **/
    private static void setPlayerID(final String givenID) {
        playerID = givenID;
    }

}
