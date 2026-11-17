
package com.example.dependencymockdemo.service;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.dependencymockdemo.model.User;

@Service
public class UserService {

    private Map<Integer, User> users = new LinkedHashMap<>();

    public UserService() {
        users.put(1, new User(1, "Gopi", "gopi@gmail.com"));
        users.put(2, new User(2, "Krishna", "krishna@gmail.com"));
        users.put(3, new User(3, "Rahul", "rahul@gmail.com"));
        users.put(4, new User(4, "Priya", "priya@gmail.com"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public User addUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(int id, User user) {
        if (!users.containsKey(id)) {
            return null;
        }

        user.setId(id);
        users.put(id, user);
        return user;
    }

    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }
}
