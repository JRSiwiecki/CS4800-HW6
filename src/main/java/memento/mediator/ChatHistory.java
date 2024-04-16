package memento.mediator;

import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistory implements IterableByUser
{
    private final ArrayList<Message> messageList = new ArrayList<>();
    private final ArrayList<MessageMemento> mementoList = new ArrayList<>();

    public void addMessageToHistory(Message message)
    {
        messageList.add(message);
        mementoList.add(new MessageMemento(message));
    }

    public Message getLastMessageSent()
    {
        if (messageList.isEmpty())
        {
            return null;
        }

        return messageList.get(messageList.size() - 1);
    }

    public ArrayList<Message> getMessageList()
    {
        return messageList;
    }

    public ArrayList<MessageMemento> getMementoList()
    {
        return mementoList;
    }

    @Override
    public Iterator iterator(User userToSearchWith)
    {
        return messageList.iterator();
    }
}
