import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class that represents any type of character in the game
 * @author Vlad Diaconu
 */
public class Character
{
    private String role;
    private Sprite character;
    private Texture charSprite;
    private float xPos;
    private float yPos;
    private float health;
    /**
     * Constructs a character at specified positions in the frame.
     * @param x is the character's relative position on the XO axis.
     * @param y is the character's relative position on the OY axis.
     */
    public Character(float x, float y)
    {
        xPos = x;
        yPos = y;

            charSprite = new Texture();
            charSprite.setSmooth(true);
        try
        {
            charSprite.loadFromFile(Paths.get("Images/spriteSheet.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        character = new Sprite(charSprite);
        character.setTextureRect(new IntRect(0,0,32,32));
        character.setOrigin(Vector2f.div(new Vector2f(charSprite.getSize()),2));
        character.setPosition(x,y);
    }

    /**
     * Draws a character to specified window (of type RenderWindow from JSFML)
     * @param game is the window to which the program draws the character.
     */
    public void drawCharacter(RenderWindow game)
    {
        game.draw(character);

    }

    /**
     * Returns the sprite used to create a entity in the game.
     * @return (*Sprite type of JSFML) character.
     */
    public Sprite getSprite()
    {
        return character;
    }

            /*----------MOVEMENT OF THE CHARACTER------------ */
    private int left = 1;
    private int frame = 0;

    /**
     * Moves the character located at coordinates (X,Y) given as floats while
     * also adjusting the frame rate and the animation of the character.
     * @param x is the OX position.
     * @param y is the YO position.
     */
    public void moveLeft(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 32,32,32,32));
        character.move(x,y);
    }

    /**
     * Moves the character located at coordinates (X,Y) towards right
     * given as floats while
     * also adjusting the frame rate and the animation of the character.
     * @param x is the OX position.
     * @param y is the YO position.
     */
    public void moveRight(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 64,64,32,32));
        character.move(x,y);
    }

    /**
     * Moves the character located at coordinates (X,Y) towards up
     * given as floats while
     * also adjusting the frame rate and the animation of the character.
     * @param x is the OX position.
     * @param y is the YO position.
     */
    public void moveUp(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 64,96,32,32));
        character.move(x,y);
    }

    /**
     * Moves the character located at coordinates (X,Y) towards down
     * given as floats while
     * also adjusting the frame rate and the animation of the character.
     * @param x is the OX position.
     * @param y is the YO position.
     */
    public void moveDown(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect( frame * 32,0,32,32));
        character.move(x,y);
    }

    /**
     * If no movement is currently happening, the character will take an 
     * "idle" position on the current (X,Y) coordinates.
     */
    public void stayIdle()
    {
        character.setTextureRect(new IntRect( 32,0,32,32));
    }

    /**
     * Method used to update the health of a character.
     * @param health represet the health points of a character (float type).
     */
    public void setHealth(float health)
    {
        this.health = health;
    }
    
    /**
     * @return the current health points a character has.
     */
    public float getHealth()
    {
        return health;
    }

    /**
     * @return the current position of the character on the XO coordinate.
     */
    public float getXPosition()
    {
        return xPos;
    }

    /**
     * @return the current position of the character on the YO coordinate.
     */
    public float getYPosition()
    {
        return yPos;
    }
}