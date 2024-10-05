package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginState extends GameState {

    private Background bg;

    private StringBuilder userInput;

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public LoginState(GameStateManager gsm) {
        this.gsm = gsm;

        userInput = new StringBuilder();

        try {
            bg = new Background("/Backgrounds/menubg.png", 1);
            bg.setVector(-0.1, 0);

            titleColor = new Color(128, 0, 0);
            titleFont = new Font("Century Gothic", Font.PLAIN, 28);

            font = new Font("Arial", Font.PLAIN, 12);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {}

    public void update() {
        bg.update();
    }

    public void draw(Graphics2D g) {
        // Draw background
        bg.draw(g);

        // Draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Login", 20, 70);

        // Draw user input
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Enter your name:", 145, 140);
        g.drawString(userInput.toString(), 145, 160);
    }

    private void submit() {
        String name = userInput.toString();
        // No further actions for user input..
        
        // Switch to the next state
        gsm.setState(GameStateManager.LEVEL1STATE);
    }

    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            submit();
        } else if (k == KeyEvent.VK_BACK_SPACE && userInput.length() > 0) {
            userInput.deleteCharAt(userInput.length() - 1);
        } else {
            char keyChar = (char) k;
            if (Character.isLetterOrDigit(keyChar) || Character.isWhitespace(keyChar)) {
                userInput.append(keyChar);
            }
        }
    }

    public void keyReleased(int k) {}
}
