package javamentor.FirstCRUD.dao;

import javamentor.FirstCRUD.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void create(User user);

    User readById(int id);

    void update(User user);

    void delete(User user);


}
