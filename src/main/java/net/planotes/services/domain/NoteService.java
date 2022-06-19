package net.planotes.services.domain;

import net.planotes.model.mongo.Note;
import net.planotes.repositories.mongo.INoteRepository;
import net.planotes.repositories.mongo.INoteTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    INoteRepository repository;

    @Autowired
    INoteTagRepository noteTagRepository;

    TagService tagService;

    public List<Note> getAll(){
        return repository.findAll();
    }

    public Note getOne(String id){
        return repository.findById(id)
                .orElse(null);
    }

    public List<Note> getAllByParentId(String id){
        return repository.findAll()
                .stream()
                .filter(item -> item.getParentNote().getId() == id)
                .collect(Collectors.toList());
    }

    public Note create(Note note) {
        return repository.save(note);
    }

    public Note update(Note note) {
        return repository.save(note);
    }

    public Note delete(String id) {
        Note note = repository.findById(id)
                .orElse(null);
        repository.deleteById(id);
        return note;
    }

    public List<Note> getAllByUserId(String id){
        return repository.findAll()
                .stream()
                .filter(item -> item.getUser().equals(id))
                .collect(Collectors.toList());
    }

//    public List<Note> getAllByTagName(String tag, String id){
//
//        List<NoteTag> list = tagService.getAllByTagName(tag);
//
//    }

}
