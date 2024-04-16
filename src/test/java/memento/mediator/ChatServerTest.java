package memento.mediator;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest
{
    private ChatServer chatServer;
    private User user1;
    private User user2;

    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        chatServer = new ChatServer();

        user1 = new User("A");
        user2 = new User("B");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown()
    {
        chatServer = new ChatServer();

        user1 = new User("A");
        user2 = new User("B");
    }

    @org.junit.jupiter.api.Test
    void registerUser()
    {
        chatServer.registerUser(user1);

        assertTrue(chatServer.getRegisteredUsers().contains(user1));
    }

    @org.junit.jupiter.api.Test
    void unregisterUser()
    {
        chatServer.registerUser(user1);
        chatServer.unregisterUser(user1);

        assertFalse(chatServer.getRegisteredUsers().contains(user1));
    }

    @org.junit.jupiter.api.Test
    void sendMessage()
    {
        user1.sendMessage(chatServer, new User[]{user2}, "message");
        assertEquals("message", user2.getMessageBox().get(0).getContent());
    }

    @org.junit.jupiter.api.Test
    void undoMessage()
    {
    }

    @org.junit.jupiter.api.Test
    void blockUser()
    {
        chatServer.blockUser(user1, user2);
        assertTrue(chatServer.getBlockMap().get(user1).contains(user2));
    }

    @org.junit.jupiter.api.Test
    void unblockUser()
    {
        chatServer.blockUser(user1, user2);
        chatServer.unblockUser(user1, user2);
        assertFalse(chatServer.getBlockMap().get(user1).contains(user2));
    }
}