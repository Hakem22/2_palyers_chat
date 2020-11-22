package model;
/**
 * A player is able to send and receive messages with other players
 * @author Imene Hakem
 */
public interface Player {

    /**
     * @return the player name
     */
    String getName();

    /**
     * Sends a message to another player
     * @param Receiver refers to the receiver
     * @param message  the message sent to the other player
     * @return returns the reply from the other player
     */
    String sendMessage(Player Receiver, String message);

    /**
     * Receives a message from another player.
     * @param Sender refers to the sender
     * @param message   the message received from the other player
     * @return  returns a reply to be sent to the sender
     */
    String receiveMessage(Player Sender, String message) ;
}
