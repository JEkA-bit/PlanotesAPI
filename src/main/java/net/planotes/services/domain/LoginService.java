package net.planotes.services.domain;

import net.planotes.model.mongo.Login;
import net.planotes.model.mongo.User;
import net.planotes.repositories.mongo.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    ILoginRepository repository;

    public List<Login> getAll() {
        return repository.findAll();
    }

    public List<Login> getAllByUser(User user) {
        return repository.findAll()
                .stream()
                .filter(item -> item.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public void update(Login login) {
        repository.save(login);
    }

    public Login create(Login login) {
        return repository.save(login);
    }

    public Login getOne(String id){
        return repository.findById(id).orElse(null);
    }

    public Login delete(String id){
        Login login = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return login;
    }
}
