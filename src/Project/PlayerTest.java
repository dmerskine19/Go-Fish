import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void testPLayer(){
        Player a = new Player( "HoangNguyen");
        assertArrayEquals("HoangNguyen", Player.getPlayerID());
        assertNotEquals("drew",Player.getPlayerID());
    }
}