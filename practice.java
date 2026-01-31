import java.util.ArrayList;
import java.util.List;

public class practice {

    public static void main(String[] args) {
        UserManager manager = new UserManager();

        User user1 = new User("Aisha", "aisha@mail.com", "Admin");
        User user2 = new User("Dana", "dana@mail.com", "User");

        manager.addUser(user1);
        manager.addUser(user2);

        manager.updateUser("dana@mail.com", "Dana A.", "User");

        manager.removeUser("aisha@mail.com");

        manager.printUsers();
    }
}

class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void update(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + role;
    }
}

class UserManager {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String email) {
        User user = findByEmail(email);
        if (user != null) {
            users.remove(user);
        }
    }

    public void updateUser(String email, String newName, String newRole) {
        User user = findByEmail(email);
        if (user != null) {
            user.update(newName, newRole);
        }
    }

    private User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

