package net.planotes.repositories.mysql;

import net.planotes.model.mysql.Password;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasswordRepository extends MongoRepository<Password, String> {
}
