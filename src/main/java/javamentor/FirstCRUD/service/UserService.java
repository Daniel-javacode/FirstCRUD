package javamentor.FirstCRUD.service;

import javamentor.FirstCRUD.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void create(User user);

    User readById(int id);

    void update(User user);

    void delete(User user);


}
