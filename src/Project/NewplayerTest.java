package project;

import org.junit.jupiter.api.Test;
import project.Player;

import static org.junit.jupiter.api.Assertions.*;

class NewplayerTest {
    @Test
    void TestNewplayer() {
        //regular input

        Player s1 = new Player("HoangNguyen");
        assertArrayEquals("HoangNguyen".toCharArray(), Player.getPlayerID().toCharArray());
        assertNotEquals("drew", Player.getPlayerID());
    }
}

