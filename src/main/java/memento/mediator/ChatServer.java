package memento.mediator;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer
{
    private final ArrayList<User> registeredUsers = new ArrayList<>();
    private final HashMap<User, ArrayList<User>> blockMap = new HashMap<>();

    public void registerUser(User user)
    {
        if (!registeredUsers.contains(user))
        {
            registeredUsers.add(user);
        }
    }

    public void unregisterUser(User user)
    {
        registeredUsers.remove(user);
    }

    public void sendMessage(User sender, User[] receivers, Message message)
    {
        for (User receiver: receivers)
        {
            ArrayList<User> blockList = getBlockMap(receiver);

            if (blockList.contains(sender))
            {
                continue;
            }

            receiver.receiveMessage(message);
        }
    }

    public void undoLastMessageSent(User user)
    {

    }

    public void blockUser(User blocker, User blockee)
    {
        ArrayList<User> blockList = getBlockMap(blocker);

        if (!blockList.contains(blockee))
        {
            blockList.add(blockee);
            blockMap.put(blocker, blockList);
        }
    }

    public void unblockUser(User blocker, User blockee)
    {
        ArrayList<User> blockList = getBlockMap(blocker);

        blockList.remove(blockee);
    }

    public ArrayList<User> getBlockMap(User user)
    {
        ArrayList<User> blockList = blockMap.get(user);

        if (blockList == null)
        {
            blockMap.put(user, new ArrayList<>());
        }

        blockList = blockMap.get(user);

        return blockList;
    }
}
