package cn.hust.study.springboot.controller;

import cn.hust.study.springboot.entity.Customer;
import cn.hust.study.springboot.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class MyRestController {

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User getUser() {
        //...
        return new User();
    }

    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {
        // ...
        return null;
    }

    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
        // ...
        return null;
    }
}
