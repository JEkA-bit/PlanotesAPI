package net.planotes.repositories.mongo;

import net.planotes.model.mongo.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends MongoRepository<Login, String> {
}
