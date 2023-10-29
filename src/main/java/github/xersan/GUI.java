package github.xersan;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

class GUI extends JFrame {

    private User userLoggedIn;
    private User aUser;

    @SuppressWarnings("CallToPrintStackTrace")
    GUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(424, 148);
        setTitle("User Login");
        getContentPane().setLayout(new CardLayout(0, 0));

        //---------Login Panel---------//
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        getContentPane().add(loginPanel, "name_8873849194100");

        JTextField nameTextField = new JTextField();
        nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        nameTextField.setText("username");
        nameTextField.setBounds(113, 11, 107, 20);
        nameTextField.setColumns(10);
        loginPanel.add(nameTextField);

        JButton enterUserPageButton = new JButton("Enter User Page");
        enterUserPageButton.setBounds(10, 42, 146, 23);
        loginPanel.add(enterUserPageButton);

        JButton enterInfectionsPageButton = new JButton("Show Potential Infections");
        enterInfectionsPageButton.setBounds(166, 42, 230, 23);
        loginPanel.add(enterInfectionsPageButton);

        JButton saveButton = new JButton("Save State");
        saveButton.setBounds(131, 76, 146, 23);
        loginPanel.add(saveButton);

        JTextField emailTextField = new JTextField();
        emailTextField.setHorizontalAlignment(SwingConstants.CENTER);
        emailTextField.setText("user email");
        emailTextField.setBounds(230, 11, 166, 20);
        emailTextField.setColumns(10);
        loginPanel.add(emailTextField);

        //---------Login Panel End---------//


        //---------User Page Panel---------//
        JPanel userPagePanel = new JPanel();
        userPagePanel.setLayout(null);
        getContentPane().add(userPagePanel, "name_8892565890500");

        JButton backToLoginPageButton = new JButton("Back to Login Screen");
        backToLoginPageButton.setBounds(410, 10, 176, 23);
        userPagePanel.add(backToLoginPageButton);

        JTextArea nameTextArea = new JTextArea();
        nameTextArea.setEditable(false);
        nameTextArea.setBounds(11, 9, 127, 22);
        userPagePanel.add(nameTextArea);

        JTextArea emailTextArea = new JTextArea();
        emailTextArea.setEditable(false);
        emailTextArea.setBounds(148, 9, 235, 22);
        userPagePanel.add(emailTextArea);

        JPanel friendsPostPanel = new JPanel();
        friendsPostPanel.setBounds(11, 330, 605, 213);
        friendsPostPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        userPagePanel.add(friendsPostPanel);

        JTextArea recentPostsLabel = new JTextArea();
        recentPostsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        recentPostsLabel.setBackground(UIManager.getColor("Panel.background"));
        recentPostsLabel.setText("Recent Posts by Friends");
        recentPostsLabel.setEditable(false);
        friendsPostPanel.add(recentPostsLabel);

        JTextArea recentPostsTextArea = new JTextArea();
        recentPostsTextArea.setEditable(false);
        recentPostsTextArea.setRows(10);
        recentPostsTextArea.setColumns(34);

        JScrollPane scroll = new JScrollPane (recentPostsTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        friendsPostPanel.add(scroll);

        JPanel suggestedFriendsPanel = new JPanel();
        suggestedFriendsPanel.setBounds(11, 572, 605, 163);
        userPagePanel.add(suggestedFriendsPanel);

        JTextArea suggestedFriendsLabel = new JTextArea();
        suggestedFriendsLabel.setText("Suggested Friends");
        suggestedFriendsLabel.setBackground(UIManager.getColor("Panel.background"));
        suggestedFriendsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        suggestedFriendsLabel.setEditable(false);
        suggestedFriendsPanel.add(suggestedFriendsLabel);

        JTextArea suggestedFriendsTextArea = new JTextArea();
        suggestedFriendsTextArea.setEditable(false);
        suggestedFriendsPanel.add(suggestedFriendsTextArea);

        JPanel postPanel = new JPanel();
        postPanel.setBounds(10, 106, 606, 220);
        userPagePanel.add(postPanel);

        JTextArea newPostTextArea = new JTextArea();
        newPostTextArea.setColumns(34);
        newPostTextArea.setRows(10);

        JScrollPane scroll3 = new JScrollPane(newPostTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        postPanel.add(scroll3);

        JButton newPostButton = new JButton("Post");
        postPanel.add(newPostButton);

        JTextField makeFriendNameTextField = new JTextField();
        makeFriendNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        makeFriendNameTextField.setText("Enter name");
        makeFriendNameTextField.setBounds(11, 42, 127, 20);
        makeFriendNameTextField.setColumns(10);
        userPagePanel.add(makeFriendNameTextField);

        JButton addFriendButton = new JButton("Make Friend");
        addFriendButton.setBounds(148, 42, 144, 23);
        userPagePanel.add(addFriendButton);

        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(10, 10, 89, 23);
        loginPanel.add(newUserButton);

        //---------User Page Panel End---------//


        //---------Likely Infected Panel---------//
        JPanel likelyInfectedPanel = new JPanel();
        likelyInfectedPanel.setLayout(null);
        getContentPane().add(likelyInfectedPanel, "name_12531046406600");

        JPanel likelyInfectedTextAreaPanel = new JPanel();
        likelyInfectedTextAreaPanel.setBounds(10, 11, 466, 286);
        likelyInfectedTextAreaPanel.setLayout(new BoxLayout(likelyInfectedTextAreaPanel, BoxLayout.X_AXIS));
        likelyInfectedPanel.add(likelyInfectedTextAreaPanel);

        JTextArea likelyInfectedTextArea = new JTextArea();
        likelyInfectedTextArea.setEditable(false);

        JScrollPane scroll2 = new JScrollPane (likelyInfectedTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        likelyInfectedTextAreaPanel.add(scroll2);

        JButton backToLoginPageButton2 = new JButton("Back to Login Screen");
        backToLoginPageButton2.setBounds(127, 308, 241, 23);
        likelyInfectedPanel.add(backToLoginPageButton2);

        //---------Likely Infected Panel End---------//


        //---------Button Listeners---------//
        enterUserPageButton.addActionListener(e -> {
            userLoggedIn = User.searchForUser(nameTextField.getText());

            if (userLoggedIn != null) {
                GUI.this.setSize(632, 777);
                loginPanel.setVisible(false);
                userPagePanel.setVisible(true);
                setTitle("User Page");

                nameTextArea.setText(userLoggedIn.getName());
                emailTextArea.setText(userLoggedIn.getEmail());
                suggestedFriendsTextArea.setText("");
                newPostTextArea.setText("");
                recentPostsTextArea.setText("");
                makeFriendNameTextField.setText("Enter name");

                HashSet<User> suggestedFriends = userLoggedIn.findSuggestedFriends();
                int counter = 0;

                for (User user: suggestedFriends) {
                    suggestedFriendsTextArea.append(user.getName());

                    if (suggestedFriends.size() > ++counter)
                        suggestedFriendsTextArea.append("\n");
                }

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                for (Post post: userLoggedIn.findPostsMadeByThisAndByItsFriends())
                    recentPostsTextArea.append(post.author().getName() + ", " + dateFormat.format(post.timestamp()) +
                            ", " + post.postString() + "\n");
            }
            else
                JOptionPane.showMessageDialog(null, "User " + nameTextField.getText() +
                        " Not Found!");
        });

        enterInfectionsPageButton.addActionListener(e -> {
            userLoggedIn = User.searchForUser(nameTextField.getText());

            if (userLoggedIn != null) {
                GUI.this.setSize(492, 415);
                loginPanel.setVisible(false);
                likelyInfectedPanel.setVisible(true);
                setTitle("Possible Virus Spread");

                likelyInfectedTextArea.setText("***************************************************************************\n");
                likelyInfectedTextArea.append(userLoggedIn.getName() + " has been infected. The following users have to be tested.\n");
                likelyInfectedTextArea.append("***************************************************************************\n");

                for(User user: userLoggedIn.findYourFriendsAndTheirFriends())
                    likelyInfectedTextArea.append(user.getName() + "\n");
            }
            else
                JOptionPane.showMessageDialog(null, "User " + nameTextField.getText() +
                        " Not Found!");
        });

        newPostButton.addActionListener(e -> {
            if (!newPostTextArea.getText().isBlank()) {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                userLoggedIn.makePost(new Post(date, newPostTextArea.getText(), userLoggedIn));

                String backup = recentPostsTextArea.getText();
                recentPostsTextArea.setText(userLoggedIn.getName() + ", " + dateFormat.format(date) + ", " +
                        newPostTextArea.getText() + "\n");
                recentPostsTextArea.append(backup);
                newPostTextArea.setText("");
            }
            else {
                newPostTextArea.setText("");
                JOptionPane.showMessageDialog(null, "Empty Post!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        newUserButton.addActionListener(e -> {
            aUser = User.searchForUser(nameTextField.getText());

            if (aUser == null) {
                int flag = UserFactory.createUser(nameTextField.getText(), emailTextField.getText());

                if (flag == 0)
                    JOptionPane.showMessageDialog(null, "User "  + nameTextField.getText() +
                            " created!");
                else if (flag == 1)
                    JOptionPane.showMessageDialog(null, "Empty name!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                else
                JOptionPane.showMessageDialog(null, "Wrong email format!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "User " + nameTextField.getText() +
                        " already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        addFriendButton.addActionListener(e -> {
            aUser = User.searchForUser(makeFriendNameTextField.getText());

            if (aUser != null) {
                double result = userLoggedIn.addFriend(aUser);

                if (result == -1)
                    JOptionPane.showMessageDialog(null, "Cannot befriend yourself!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                else if (result == -2)
                    JOptionPane.showMessageDialog(null, "Users are already friends!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Success! Graph diameter is: " + result);
            }
            else
                JOptionPane.showMessageDialog(null, "User " + makeFriendNameTextField.getText() +
                        " does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        saveButton.addActionListener(e -> {
            try {
                FileOutputStream fileOut = new FileOutputStream("uomsocial.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);

                out.writeObject(User.getAllUsers());
                out.writeObject(User.getFriendsGraph());

                out.close();
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        backToLoginPageButton.addActionListener(e -> {
            GUI.this.setSize(424, 148);
            loginPanel.setVisible(true);
            userPagePanel.setVisible(false);
            setTitle("User Login");
        });

        backToLoginPageButton2.addActionListener(e -> {
            GUI.this.setSize(424, 148);
            loginPanel.setVisible(true);
            likelyInfectedPanel.setVisible(false);
            setTitle("User Login");
        });

        //---------Button Listeners End---------//

        setVisible(true);

    }

}

