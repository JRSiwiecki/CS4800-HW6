package memento.mediator;

import java.util.ArrayList;
import java.util.Iterator;

public class User implements Iterable<Object>
{
    private final String username;
    private final ArrayList<Message> messageBox = new ArrayList<>();
    private final ChatHistory chatHistory = new ChatHistory();

    public User(String username)
    {
        this.username = username;
    }

    public void sendMessage(ChatServer server, User[] receivers, String messageContent)
    {
        Message message = new Message(messageContent, this, receivers);
        server.sendMessage(this, receivers, message);
        chatHistory.addMessageToHistory(message);
    }

    public void receiveMessage(Message message)
    {
        messageBox.add(message);
    }

    public void undoLastMessageSent(ChatServer chatServer)
    {
        chatServer.undoMessage(chatHistory.getLastMessageSent());
        chatHistory.getMessageList().remove(chatHistory.getLastMessageSent());
    }

    public String getUsername()
    {
        return username;
    }

    public ArrayList<Message> getMessageBox()
    {
        return messageBox;
    }

    public ChatHistory getChatHistory()
    {
        return chatHistory;
    }

    public String toString()
    {
        return username;
    }

    public void printMessageBox()
    {
        System.out.println("--- " + username + "'S MESSAGE BOX ---");
        for (Message message : messageBox)
        {
            System.out.println(message);
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public Iterator<Object> iterator()
    {
        return chatHistory.iterator(this);
    }
}
