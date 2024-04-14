package memento.mediator;

public class User
{
    private String username;

    public User(String username)
    {
        this.username = username;
    }

    public void sendMessage(ChatServer server, String receiver)
    {
        server.sendMessage(this, receiver);
    }

    public Message receiveMessage(ChatServer server)
    {
        server.receiveMessage(this);
    }

    public void undoLastMessageSent(ChatServer server)
    {
        server.undoLastMessageSent(this);
    }
}
