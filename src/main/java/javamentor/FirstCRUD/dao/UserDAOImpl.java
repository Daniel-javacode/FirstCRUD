package javamentor.FirstCRUD.dao;

import javamentor.FirstCRUD.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(AUTO_ID.getAndIncrement());
        user1.setName("Вася");
        user1.setSurname("Пупкин");
        user1.setEmail("pupok@gamil.com");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(AUTO_ID.getAndIncrement());
        user2.setName("Витя");
        user2.setSurname("Попкин");
        user2.setEmail("popok@gmail.com");
        users.put(user2.getId(), user2);
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void create(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public User readById(int id) {
        return users.get(id);
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }


    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }
}
