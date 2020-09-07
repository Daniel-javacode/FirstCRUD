package javamentor.FirstCRUD.dao;

import javamentor.FirstCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    /*@Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }*/

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User readById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }


    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
