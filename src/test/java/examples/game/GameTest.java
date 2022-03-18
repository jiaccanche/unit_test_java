package examples.game;

import com.course.testing.game.Dice;
import com.course.testing.game.Player;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {

    @Test
    public void looses_when_dice_number_is_too_low(){
        Dice dice = new Dice(6);
        Player player1 = new Player(dice,3);
        Assert.assertEquals(false, player1.win());
    }

    @Test
    public void looses_when_dice_number_is_too_low_mockito(){
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player1 = new Player(dice,3);
        Assert.assertEquals(false, player1.win());
    }
}
