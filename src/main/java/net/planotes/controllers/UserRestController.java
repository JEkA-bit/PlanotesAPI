package net.planotes.controllers;

import net.planotes.model.mongo.User;
import net.planotes.services.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable(value = "id")String id){
        return service.getOne(id);
    }

    @PostMapping("/")
    public User create(@RequestBody User user){
        return service.create(user);
    }

    @RequestMapping(value = { "/{id}" }, method = { RequestMethod.DELETE })
    public User delete(@PathVariable(value = "id")String id){
        return service.delete(id);
    }

    @PutMapping("/")
    public User update(@RequestBody User user){
        return service.update(user);
    }

    @PostMapping("/auth")
    public User auth(@RequestParam(name = "email", defaultValue = "") String email,
                     @RequestParam(name = "password", defaultValue = "") String password){
        return service.auth(email, password);
    }

    @PostMapping("/reset")
    public void reset(@RequestParam(name = "email", defaultValue = "") String email){
        service.sendLinkToEmailForResetPassword(email, "Password reset");
    }

    @PostMapping("/activate/{code}")
    public void activate(@PathVariable(value = "code")String code, @RequestBody User user){
        service.create(code, user);
    }

    @PostMapping("/reset/{code}")
    public String reset(@PathVariable(value = "code")String code, @RequestParam(name = "password") String password){
        return service.resetPassword(code, password);
    }
}
