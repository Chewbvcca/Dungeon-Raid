package SCCGame;

import org.jsfml.graphics.Image;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class GameWindow
{
    private static final int WIDTH = 640;
    private static final int HEIGHT = 640 /12 * 9;
    private static final String name = "Dungeon Raid";

    private RenderWindow game;
    private Character character;
    private Clock animationTime = new Clock();
    private Image img = new Image();

    /**
     * This is the Constructor for the main game window.
     * @param WIDTH is the width of the frame.
     * @param HEIGHT is the height of the frame.
     * @param name is a string representing the name of the game.
     */
    public GameWindow()
    {
        game = new RenderWindow(new VideoMode(WIDTH, HEIGHT),name);
        character = new Character(WIDTH / 2,HEIGHT / 2 );

        this.run();
    }

    /**
     * Method that adds a character to the window.
     * @param c is the character added in the window.
     */
    private void addCharacter(Character c)
    {
        character.drawCharacter(game);
    }

    /**
     * Method that starts the game.
     */
    private synchronized void run()
    {
        while(game.isOpen())
        {
            if(animationTime.getElapsedTime().asMicroseconds() >= 90000) {
                animationTime.restart();

                for (Event e : game.pollEvents()) {
                    if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
                        game.close();
                }
                if (Keyboard.isKeyPressed((Keyboard.Key.W))) {
                    character.moveUp(0, -7);
                }

                if (Keyboard.isKeyPressed((Keyboard.Key.A))) {
                    character.moveLeft(-7, 0);
                }

                if (Keyboard.isKeyPressed((Keyboard.Key.S))) {
                    character.moveDown(0, 7);
                }

                if (Keyboard.isKeyPressed((Keyboard.Key.D))) {
                    character.moveRight(7, 0);
                }

                //START OF THE FRAME
                game.clear();

                character.drawCharacter(game);

                //END OF THE FRAME
                game.display();
            }
        }
    }
}