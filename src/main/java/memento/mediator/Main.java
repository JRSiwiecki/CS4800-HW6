package memento.mediator;

public class Main
{
    public static void main(String[] args)
    {
        ChatServer chatServer = new ChatServer();

        User userA = new User("A");
        User userB = new User("B");
        User userC = new User("C");

        chatServer.registerUser(userA);
        chatServer.registerUser(userB);

        // Sending normal messages (1-to-1)
        userA.sendMessage(chatServer, new User[]{userB}, "hello 1");

        userB.printMessageBox();

        userA.sendMessage(chatServer, new User[]{userB}, "hello 2");
        userB.sendMessage(chatServer, new User[]{userA}, "hello 3");

        userB.printMessageBox();
        userA.printMessageBox();

        // Block Messages
        chatServer.blockUser(userA, userB);

        userB.sendMessage(chatServer, new User[]{userA}, "did you block me 4");

        userA.printMessageBox();

        chatServer.unblockUser(userA, userB);
        userB.sendMessage(chatServer, new User[]{userA}, "did you unblock me 5");
        userA.printMessageBox();

        // Undo messages
        userA.undoLastMessageSent(chatServer);
        userB.printMessageBox();

        userB.undoLastMessageSent(chatServer);
        userA.printMessageBox();

        // Messages to multiple users
        userA.sendMessage(chatServer, new User[]{userB, userC}, "hello to you all 6");
        userB.printMessageBox();
        userC.printMessageBox();

        // View chat histories
        System.out.println(userA.getChatHistory().getMessageList());

        // Iterator
        System.out.println(userA.iterator().next());
    }
}
