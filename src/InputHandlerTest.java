
import Data.Litter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputHandlerTest {

    private Player player;
    private Map map;

    @Before
    public void setUp() {
        map = new Map();
        player = new Player();
        player.setCurrentLocation(map.getLocations()[2][0]);
    }

    @Test
    public void nullPlayerInputTest() {
        player = null;
        String input = "go west";
        Assert.assertFalse(InputHandler.inputHandler(input, player));
    }

    @Test
    public void possibleEastGoHandlerTest() {
        String input = "go east";
        Assert.assertEquals(true, InputHandler.inputHandler(input, player));
        Assert.assertEquals(21, player.getCurrentLocation().getCoordinate(), 0.0005);
    }

    @Test
    public void impossibleWestGoHandlerTest() {
        String input = "go west";
        Assert.assertEquals(false, InputHandler.inputHandler(input, player));
        Assert.assertEquals(20, player.getCurrentLocation().getCoordinate(), 0.0005);
    }

    @Test
    public void takeHandlerTest() {
        String input = "take styrofoam";
        InputHandler.inputHandler(input, player);
        Assert.assertTrue(player.getInventory().get(0).getName().equals(Litter.STYROFOAM.name()));
    }

    //index out of bounds error ??
    @Test
    public void dropHandlerTest() {
        InputHandler.inputHandler("take styrofoam", player);
        System.out.println(player.getInventory().get(0).getName());
        String input = "drop styrofoam";
        InputHandler.inputHandler(input, player);
        Assert.assertTrue(player.getInventory().size() == 0);
    }

    @Test
    public void listHandlerTest() {
        String input = "list";
        Assert.assertEquals(true, InputHandler.inputHandler(input,player));
    }
}
