package memento.mediator;

import java.sql.Timestamp;

public class Message
{
    private final String content;
    private final User sender;
    private final User[] receivers;
    private final Timestamp timestamp;

    public Message(String content, User sender, User[] receivers)
    {
        this.content = content;
        this.sender = sender;
        this.receivers = receivers;
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

    public User[] getReceivers()
    {
        return receivers;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public String toString()
    {
        return "[" + content + "] from [" + sender.toString() + "] at [" + timestamp + "]";
    }
}
