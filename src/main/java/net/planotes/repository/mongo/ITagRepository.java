package net.planotes.repository.mongo;

import net.planotes.model.mongo.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ITagRepository extends MongoRepository<Tag, String> {
    Optional<Tag> findByName(String name);
}
