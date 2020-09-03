package javamentor.FirstCRUD.controllers;

import javamentor.FirstCRUD.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    private static User user;

    static {
        user = new User();
        user.setId(3);
        user.setName("Вася");
        user.setSurname("Пупкин");
        user.setEmail("pupok@gmail.com");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allUsers");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
