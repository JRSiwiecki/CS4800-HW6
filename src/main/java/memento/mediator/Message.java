package memento.mediator;

import java.sql.Timestamp;

public class Message
{
    private String content;
    private User sender;
    private Timestamp timestamp;

    public Message(String content, User sender)
    {
        this.content = content;
        this.sender = sender;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
}
