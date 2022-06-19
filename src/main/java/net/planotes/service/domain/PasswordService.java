package net.planotes.service.domain;

import net.planotes.model.mysql.Password;
import net.planotes.model.mongo.User;
import net.planotes.repository.mysql.IPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordService {

    @Autowired
    IPasswordRepository repository;

    public List<Password> getAll(){
        return repository.findAll();
    }

    public List<Password> getAllByUser(User user){
        return repository.findAll()
                .stream()
                .filter(item -> item.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public void create(Password password){
        repository.save(password);
    }

    public void update(Password password){
        repository.save(password);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public Password getOne(String id){
        return repository.findById(id).orElse(null);
    }

    public void deleteByUserId(String id){
        repository.findAll()
                .stream()
                .filter(item -> item.getUser().equals(id))
                .collect(Collectors.toList())
                .forEach(item -> repository.deleteById(item.getId()));
    }


}
