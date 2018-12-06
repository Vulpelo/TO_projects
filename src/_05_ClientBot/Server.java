// wzorzec obiektowy: Obserwator / Observer
package _05_ClientBot;

import java.util.ArrayList;

public class Server implements Runnable {
    private ArrayList<Client> clients = new ArrayList<>();

    // makes connection with new client
    public void register(Client client) {

    }

    // disconnects client from server
    public void unregister(Client client) {

    }

    // Server notifies All clients to do something
    public void notifyAllClients() {

    }

    // Server notifies specific client to do something
    public void notifyClient(Client client) {

    }

    // Updates server data when client is notifying server
    public void update() {

    }



    @Override
    public void run() {

    }
}
