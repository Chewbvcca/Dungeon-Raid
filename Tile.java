import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import java.io.IOException;
import java.nio.file.Paths;


public class Tile
{
    private Sprite groundUnit;
    private Texture gU;
    private float xPos;
    private float yPos;

    public Tile(float xPos, float yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        try
        {
            gU = new Texture();
            gU.loadFromFile(Paths.get("Images/ground_1.png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        groundUnit = new Sprite(gU);
        groundUnit.setPosition(xPos,yPos);
        groundUnit.scale(2,2);
    }

    public void drawTile(RenderWindow game)
    {
        game.draw(groundUnit);
    }
}