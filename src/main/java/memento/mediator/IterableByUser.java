package memento.mediator;

import java.util.Iterator;

public interface IterableByUser
{
    Iterator iterator(User userToSearchWith);
}
