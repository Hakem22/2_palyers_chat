package model;


import api.Broadcaster;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a player which is able to send and receive message with other players
 *
 * @author Imene Hakem
 */
public class PlayerImpl implements Player {


    /**
     * Player name
     */
    private final String name;
    /**
     * Track received messages for each other player
     */
    private final Map<Player, Integer> receivedMessages = new HashMap<>();

    /**
     * Create a new player with the provided name
     * @param name
     */
    public PlayerImpl(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sends a message to another player
     * @param Receiver refers to the receiver
     * @param message  the message sent to the other player
     * @return returns the reply from the other player
     */
    public String sendMessage(Player Receiver, String message){
        Broadcaster.broadcast(this.name + " sent this message <<" +message + ">> to " +Receiver.getName(), PlayerImpl.class.getName());
        return Receiver.receiveMessage(this, message);
    }

    /**
     * Receives a message from another player.
     * @param Sender refers to the sender
     * @param message   the message received from the other player
     * @return  returns a reply to be sent to the sender
     */
    public String receiveMessage(Player Sender, String message) {
        Integer counter = receivedMessages.getOrDefault(Sender, 0) + 1;
        receivedMessages.put(Sender, counter);
        Broadcaster.broadcast(this.name + " received: "+counter+" message(s) so far from "+ Sender.getName() + " the last message was <<" +message + ">>", PlayerImpl.class.getName());
        if (counter == 10) {
            System.exit(0);
        }
        return this.sendMessage(Sender, "Your last message is <<"+message+">> & your counter is "+counter);
    }
}
