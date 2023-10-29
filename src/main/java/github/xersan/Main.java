package github.xersan;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.*;
import java.util.ArrayList;

public class Main {

    @SuppressWarnings({"unchecked", "CallToPrintStackTrace"})
    public static void main(String[] args) {

        ArrayList<User> users;
        @SuppressWarnings("UnusedAssignment")
        Graph<User, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        try {
            FileInputStream fileIn = new FileInputStream("uomsocial.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            users = (ArrayList<User>) in.readObject();
            User.setAllUsers(users);

            graph = (Graph<User, DefaultEdge>) in.readObject();
            User.setFriendsGraph(graph);

            in.close();
            fileIn.close();
        } catch (ClassCastException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        new GUI();
    }

}
