package javamentor.FirstCRUD.controllers;

import javamentor.FirstCRUD.model.User;
import javamentor.FirstCRUD.service.UserService;
import javamentor.FirstCRUD.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsersController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allUsers");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }*/
}
