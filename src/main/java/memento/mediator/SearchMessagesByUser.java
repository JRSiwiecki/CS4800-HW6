package memento.mediator;

import java.util.Iterator;

public class SearchMessagesByUser implements Iterator<Message>
{
    private final Iterator<Message> iterator;

    public SearchMessagesByUser(ChatHistory chatHistory, User user) {
        this.iterator = chatHistory.iterator(user);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Message next() {
        return iterator.next();
    }
}
