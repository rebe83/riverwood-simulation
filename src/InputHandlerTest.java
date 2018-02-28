import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputHandlerTest {

    private Player player;
    private Map map;
    private Simulation sim;

    @Before
    public void setUp() {
        sim = new Simulation();
        map = new Map();
        player = new Player();
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
        String input = "list";
        assertEquals("", InputHandler.inputHandler(input,player));
    }
}
