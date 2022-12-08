package project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void testPLayer(){
        Player a = new Player( "HoangNguyen");
        assertArrayEquals("HoangNguyen".toCharArray(), Player.getPlayerID().toCharArray());
        assertNotEquals("drew",Player.getPlayerID());
    }
}