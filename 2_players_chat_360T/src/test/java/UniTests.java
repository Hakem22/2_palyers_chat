import com.ginsberg.junit.exit.ExpectSystemExit;
import model.Player;
import model.PlayerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests
 * @author Imene Hakem
 */
public class UniTests {



    private Player initiator;
    private Player player2;

    /**
     * Create two players, initiator and player2
     */
    @BeforeEach
    public void initialization() {
        initiator = new PlayerImpl("initiator");
        player2 = new PlayerImpl("player2");
    }

    /**
     * Initiator sends a message to player2
     */
    @Test
    public void sendMessageToPlayer2() {
        assertNotNull(initiator.sendMessage(player2, "Initiate chat"));
    }

    /**
     * When initiator sends a message to player2, check if player2 received the same message
     */
    @Test
    public void whenInitiatorSendsMessageToPlayer_thenPlayer2SendsBackMessageWithCounter() {
        String receivedMessage = initiator.sendMessage(player2, "Initiate chat");
        assertEquals("Initiate chat", receivedMessage);
    }

    /**
     * When 10 messages are send and received exit the program
     */
    @Test
    @ExpectSystemExit
    public void when10MessageSentAndReceived_thenFinalizeTheProgramGracefully() {
        for (int i = 0; i < 100; i++) {
            initiator.sendMessage(player2, "Initiate chat");
        }
    }
}
