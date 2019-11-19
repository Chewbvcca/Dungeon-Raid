package SCCGame;


import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Character
{
    private String role;
    private Sprite character;
    private Texture charSprite;
    private float xPos;
    private float yPos;

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

    public Sprite getSprite()
    {
        return character;
    }
    private int left = 1;
    private int frame = 0;
    public void moveLeft(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 32,32,32,32));
        character.move(x,y);
    }

    public void moveRight(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 64,64,32,32));
        character.move(x,y);
    }

    public void moveUp(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect(frame * 64,96,32,32));
        character.move(x,y);
    }

    public void moveDown(float x, float y)
    {
        frame += 1;

        if(frame > 5) frame = 0;
        character.setTextureRect(new IntRect( frame * 32,0,32,32));
        character.move(x,y);
    }

    public void stayIdle()
    {
        character.setTextureRect(new IntRect( 32,0,32,32));
    }

}
