package net.planotes.repositories.mongo;

import net.planotes.model.mongo.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends MongoRepository<Note, String> {
}
