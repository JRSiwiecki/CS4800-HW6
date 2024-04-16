package memento.mediator;

import java.sql.Timestamp;

public class MessageMemento
{
    private final String messageContent;
    private final Timestamp timestamp;

    public MessageMemento(Message message)
    {
        messageContent = message.getContent();
        timestamp = message.getTimestamp();
    }

    public String getMessageContent()
    {
        return messageContent;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }
}
