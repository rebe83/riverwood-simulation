import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InputHandlerTest {

    private Player player = new Player();
    private Map map;

    @Before
    public void setUp() {
        map = new Map();
        player.setCurrentLocation(map.getLocations()[2][2]);

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
        assertEquals(2.3, player.getCurrentLocation().getCoordinate(), 0.0005);
    }

    @Test
    public void impossibleGoHandlerTest() {
        String input = "go west";
        assertEquals(false, InputHandler.inputHandler(input, player));
        assertEquals(2.2, player.getCurrentLocation().getCoordinate(), 0.0005);
    }

    @Test
    public void takeHandlerTest() {
        String input = "take sytofoam";
        assertEquals(true, InputHandler.inputHandler(input, player));

    }

    @Test
    public void dropHandlerTest() {
        String input = "drop styrofoam";
        assertEquals(true, InputHandler.inputHandler(input, player));

    }

    @Test
    public void listHandlerTest() {

    }

    @Test
    public void exitHandlerTest() {

    }
}
