import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class to represent a single instance of a mob in a room.
 * This mob has the same dynamics and phyisics as the regular character.
 * The movemenent and spawning of this character is random within the instance
 * of the dungeon.
 * @author Vlad Diaconu
 */
public class Mob extends Character
{
    private int times = 5;
    private boolean wentUp = false;
    private boolean wentDown = false;
    private boolean wentLeft = false;
    private boolean wentRight = false;
    private final boolean dead = false;

    public Mob(final float x, final float y) 
    {
        super(x, y);
    }

    public void moveMOB(final Mob regularMonster)
    {
        if(wentUp == false)
        {
            regularMonster.moveUp(0, -7);
            times -= 1;

            if(times == 0)
            {
                wentUp = true;
                times = 5;
            }
        }
        else if(wentLeft == false && wentUp == true)
        {
            regularMonster.moveLeft(-7, 0);
            times -= 1;

            if(times == 0)
            {
                wentLeft = true;
                times = 5;
            }
        }
        else if(wentDown == false && (wentLeft == true && wentUp == true))
        {
            regularMonster.moveDown(0, 7);
            times -= 1;

            if(times == 0)
            {
                wentDown = true;
                times = 5;
            }
        }
        else if(wentRight == false && wentDown == true && (wentLeft == true && wentUp == true))
        {
            regularMonster.moveRight(7, 0);
            times -= 1;

            if(times == 0)
            {
                wentRight = true;
                times = 5;
            }
        }
        if(wentDown == true && wentUp == true && wentLeft == true && wentRight == true)
        {
            wentDown = false;
            wentLeft = false;
            wentRight = false;
            wentUp = false;
        }
        if( dead == true)
        {
            //TODO: Death Animation
        }
    }
}