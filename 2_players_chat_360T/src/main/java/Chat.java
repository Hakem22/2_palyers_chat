import model.Player;
import model.PlayerImpl;

/**
 * This class starts a new chat between two players
 *
 * @author Imene Hakem
 */
public class Chat {

    /**
     * Start a new chat with two players.
     * Initiator sends a message to player2, player2 sends back a message to initiator.
     * Print out the message received from both players
     *
     * @param args
     */

    public static void main(String[] args) {
        Player initiator = new PlayerImpl("Initiator");
        Player player2 = new PlayerImpl("Player_2");

        String messageReceivedFromPlayer2 = initiator.sendMessage(player2, "Hi, I am " + initiator.getName());
        String messageReceivedFromInitiator = player2.sendMessage(initiator, "Hi , I am " + player2.getName());

        messageReceivedFromPlayer2 = initiator.sendMessage(player2, "Hi, I am " + initiator.getName());
    }
}
