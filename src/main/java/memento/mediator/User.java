package memento.mediator;

import java.util.ArrayList;

public class User
{
    private final String username;
    private final ArrayList<Message> messageBox = new ArrayList<>();

    public User(String username)
    {
        this.username = username;
    }

    public void sendMessage(ChatServer server, ArrayList<User> receivers, String messageContent)
    {
        Message message = new Message(messageContent, this);
        server.sendMessage(this, receivers, message);
    }

    public void receiveMessage(Message message)
    {
        messageBox.add(message);
    }

    public void undoLastMessageSent(ChatServer server)
    {
        server.undoLastMessageSent(this);
    }

    public String getUsername()
    {
        return username;
    }

    public ArrayList<Message> getMessageBox()
    {
        return messageBox;
    }
}
