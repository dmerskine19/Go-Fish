import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewplayerTest {
    @Test
            void TestNewplayer(){
        //regular input

        Player s1 = new Player("HoangNguyen");
        assertArrayEquals("HoangNguyen", Player.getPlayerID());
        assertNotEquals("drew",Player.getPlayerID());
    }

