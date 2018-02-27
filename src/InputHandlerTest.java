import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InputHandlerTest {

    private Player player = new Player();
    private Map map;

    @Before
    public void setUp() {
        fileLayout = Data.setFileLayout("MonsterSiebel.json");
        if (fileLayout != null) {
            player.currentRoom = fileLayout.rooms[0];
        }
    }

    @Test
    public void nullPlayerInputTest() {
        player = null;
        String input = "go west";
        InputHandler.inputHandler(input, player);
    }

    @Test
    public void possibleGoHandlerTest() {
        String input = "go east";
        assertEquals(true, InputHandler.inputHandler(input, player));
        assertEquals("SiebelEntry", player.currentRoom.name);
    }
    @Test
    public void impossibleGoHandlerTest() {
        String input = "go west";
        assertEquals(false, InputHandler.inputHandler(input, player));
        assertEquals("SiebelEntry", player.currentRoom.name);
    }
    @Test
    public void takeHandlerTest() {

    }

    @Test
    public void dropHandlerTest() {
        String input = "drop pocket lint";
        assertEquals(true, InputHandler.inputHandler(input, player));

    }

    @Test
    public void listHandlerTest() {

    }

    @Test
    public void exitHandlerTest() {

    }
