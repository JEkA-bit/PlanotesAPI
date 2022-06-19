package net.planotes.repositories.mongo;

import net.planotes.model.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    User findUserByActivationCode(String activationCode);
    User findUserByEmail(String email);
    User deleteUserById(String id);
    User findAllByPassword(String password);
    User deleteUsersByActivationCodeIsNotNullAndPasswordIsNull();
}
