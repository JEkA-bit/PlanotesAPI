package net.planotes.repositories.mongo;

import net.planotes.model.mongo.NoteTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INoteTagRepository extends MongoRepository<NoteTag, String> {
}
