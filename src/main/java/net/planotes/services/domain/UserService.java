package net.planotes.services.domain;

import net.planotes.model.mysql.Password;
import net.planotes.model.mongo.User;
import net.planotes.repositories.mongo.IUserRepository;
import net.planotes.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Value("${server.host}")
    String host;

    @Value("${server.port}")
    String port;

    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private EmailService service;

    public List<User> getAll() {
        return repository.findAll();
    }
    public User getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    public User create(User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        String content = "\n" +
                "    <div style=\"padding: 10px; font-family: 'Courier New', Courier, monospace; text-align: center;\">\n" +
                "        <h1>Activate your account</h1>\n" +
                "        <hr>\n" +
                "        <p> You need to go to the activation page and continue your registration.<br> \\n\" +\n" +
                "        \"To go to the page go to the <a href='" + host + ":" + port +"'>link</a> or click the button \\\"OPEN\\\"\\n\" +\n" +
                "                \"        You can change a password in 15 next minutes.</p>\n" +
                "        <button style=\"padding: 5px 20px;\n" +
                "        border: none;\n" +
                "        font-weight: 800;\n" +
                "        font-size: medium;\n" +
                "        border-radius: 5px;\n" +
                "        background-color: rgb(99, 67, 67);\n" +
                "        color: white;\n" +
                "        font-family: 'Courier New', Courier, monospace;\">\n" +
                "            OPEN\n" +
                "        </button>\n" +
                "    </div>";
        service.send(user.getEmail(), "Activate your account", content);
        return repository.save(user);
    }

    public User create(String code, User user){
        User user1 = repository.findAll()
                .stream()
                .filter(item -> item.getActivationCode().equals(code))
                .findFirst().orElse(null);

        if( user1 == null) return null;

        user.setId(user1.getId());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setActivationCode(null);
        user = repository.save(user);
        passwordService.create(new Password(LocalDateTime.now(),
                LocalDateTime.now(), user.getId(), user.getPassword()));
        return user;
    }

    public User update(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return repository.save(user);
    }

    public User delete(String id) {
        User user = repository.findById(id).orElse(null);
        passwordService.deleteByUserId(user.getId());
        repository.deleteById(id);
        return user;
    }

    public User auth(String email, String password) {
        User user = repository.findAll().stream().
                filter(item -> item.getEmail().equals(email)).findFirst().orElse(null);
        if (user == null) return null;

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    public void forgotPassword(String emailTo, String subject) {

        User user = repository.findAll().stream()
                .filter(item -> item.getEmail().equals(emailTo))
                .findFirst().orElse(null);

        if (user == null) return;

        String content = "\n" +
                "    <div style=\"padding: 10px; font-family: 'Courier New', Courier, monospace; text-align: center;\">\n" +
                "        <h1>Restore password</h1>\n" +
                "        <hr>\n" +
                "        <p> You need to go to the restore page and enter your new password.<br> \\n\" +\n" +
                "        \"            To go to the page go to the <a href=\\\"https:\\google.com\\\">link</a> or click the button \\\"OPEN\\\"\\n\" +\n" +
                "                \"        You can change a password in 15 next minutes.</p>\n" +
                "        <button style=\"padding: 5px 20px;\n" +
                "        border: none;\n" +
                "        font-weight: 800;\n" +
                "        font-size: medium;\n" +
                "        border-radius: 5px;\n" +
                "        background-color: rgb(99, 67, 67);\n" +
                "        color: white;\n" +
                "        font-family: 'Courier New', Courier, monospace;\">\n" +
                "            OPEN\n" +
                "        </button>\n" +
                "    </div>";

        service.send(emailTo, subject, content);
    }


}
