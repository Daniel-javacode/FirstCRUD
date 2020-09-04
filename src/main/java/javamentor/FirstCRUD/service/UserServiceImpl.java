package javamentor.FirstCRUD.service;

import javamentor.FirstCRUD.dao.UserDAO;
import javamentor.FirstCRUD.dao.UserDAOImpl;
import javamentor.FirstCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public User readById(int id) {
        return userDAO.readById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
