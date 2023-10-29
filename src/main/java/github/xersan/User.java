package github.xersan;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.GraphMeasurer;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

class User implements Serializable {

    private final String name;
    private final String email;
    private final ArrayList<User> friends = new ArrayList<>();
    private final ArrayList<Post> posts = new ArrayList<>();

    private static ArrayList<User> allUsers = new ArrayList<>();
    private static Graph<User, DefaultEdge> friendsGraph = new SimpleGraph<>(DefaultEdge.class);

    User(String name, String email) {
        this.name = name;
        this.email = email;
        allUsers.add(this);
        friendsGraph.addVertex(this);
    }

    String getName() {
        return this.name;
    }

    String getEmail() {
        return this.email;
    }

    ArrayList<User> getFriends() {
        return this.friends;
    }

    ArrayList<Post> getPosts() {
        return this.posts;
    }

    static ArrayList<User> getAllUsers() {
        return User.allUsers;
    }

    static Graph<User, DefaultEdge> getFriendsGraph() {
        return User.friendsGraph;
    }

    static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }

    static void setFriendsGraph(Graph<User, DefaultEdge> friendsGraph) {
        User.friendsGraph = friendsGraph;
    }

    void makePost(Post post) {
        this.posts.add(post);
    }

    double addFriend(User user) {
        if (this.equals(user))
            return -1;

        if (this.friends.contains(user))
            return -2;

        this.friends.add(user);
        user.getFriends().add(this);
        friendsGraph.addEdge(user, this);
        return new GraphMeasurer<>(friendsGraph).getDiameter();
    }

    HashSet<User> findSuggestedFriends() {
        HashSet<User> suggestedFriends = findYourFriendsAndTheirFriends();

        this.friends.forEach(suggestedFriends::remove);

        return suggestedFriends;
    }

    ArrayList<Post> findPostsMadeByThisAndByItsFriends() {
        ArrayList<Post> posts = new ArrayList<>(this.posts);

        for (User friend: this.friends)
            posts.addAll(friend.getPosts());

        if (posts.size() >= 2)
            posts.sort((o1,o2) -> o2.timestamp().compareTo(o1.timestamp()));

        return posts;
    }

    HashSet<User> findYourFriendsAndTheirFriends() {
        HashSet<User> yourFriendsAndTheirFriends = new HashSet<>(this.friends);

        for (User friend: this.friends)
            yourFriendsAndTheirFriends.addAll(friend.getFriends());

        yourFriendsAndTheirFriends.remove(this);

        return yourFriendsAndTheirFriends;
    }

    static User searchForUser(String name) {
        for (User user: User.allUsers)
            if(user.getName().equals(name))
                return user;

        return null;
    }

}
