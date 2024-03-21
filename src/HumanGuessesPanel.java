import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * UI for when the human is guessing a number
 *
 * NOTE: Do not edit this file
 */
public class HumanGuessesPanel extends JPanel {
    private HumanGuessesGame game;

    public HumanGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){
        game = new HumanGuessesGame();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel promptPanel = new JPanel(new FlowLayout());

        JLabel prompt = new JLabel("Enter your guess:");
        promptPanel.add(prompt);

        JTextField guessTxt = new JTextField("");
        promptPanel.add(guessTxt);

        promptPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, guessTxt.getHeight() + 8));
        this.add(promptPanel);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        JLabel reply = new JLabel("");
        reply.setMinimumSize(prompt.getSize());
        this.add(reply);
        reply.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0,40)));

        JPanel buttonPanel = new JPanel();

        JButton quit = new JButton("Back to Home");
        quit.addActionListener(e -> {
            // See itemStateChanged in https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
            CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
            cardLayout.show(cardsPanel, ScreenID.HOME.name());
        });
        buttonPanel.add(quit);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                int guessVal = Integer.parseInt(guessTxt.getText());

                GuessResult res = game.makeGuess(guessVal);

                if (res == GuessResult.LOW) {
                    reply.setText(guessVal + " is too low.");
                } else if (res == GuessResult.HIGH) {
                    reply.setText(guessVal + " is too high.");
                } else {
                    reply.setText("");

                    // Send the result from the game to the callback function
                    GameResult result = new GameResult(true, guessVal, game.getNumGuesses());
                    gameFinishedCallback.accept(result);

                    CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
                    cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
                }

                guessTxt.setText("");
                guessTxt.requestFocusInWindow();
            } catch (NumberFormatException nfe) {
                reply.setText("Please enter a valid number.");
            }
        });
        buttonPanel.add(submit);

        this.add(Box.createVerticalGlue());

        this.add(buttonPanel);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                reply.setText("");
                guessTxt.setText("");
                guessTxt.requestFocusInWindow();
                SwingUtilities.getRootPane(submit).setDefaultButton(submit);

                game = new HumanGuessesGame();
            }
        });
    }

}

