package memento.mediator;

import java.util.ArrayList;

public class ChatHistory
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
}
