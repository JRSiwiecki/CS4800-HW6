package memento.mediator;

import java.sql.Timestamp;

public class Message
{
    private final String content;
    private final User sender;
    private final Timestamp timestamp;

    public Message(String content, User sender)
    {
        this.content = content;
        this.sender = sender;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getContent()
    {
        return content;
    }

    public User getSender()
    {
        return sender;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }
}
