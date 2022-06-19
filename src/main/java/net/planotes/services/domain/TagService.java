package net.planotes.services.domain;

import net.planotes.model.mongo.NoteTag;
import net.planotes.model.mongo.Tag;
import net.planotes.repositories.mongo.INoteTagRepository;
import net.planotes.repositories.mongo.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private ITagRepository repository;

    @Autowired
    INoteTagRepository noteTagRepository;

    public List<Tag> getAll(){
        return repository.findAll();
    }

    public Tag getOneById(String id){
        return repository.findById(id).orElse(null);
    }

    public Tag getOneByName(String name) { return repository.findByName(name).orElse(null); }

    public Tag create(Tag tag){
        Tag tag1 = repository.findByName(tag.getName()).orElse(null);
        if(tag1 != null) {
            System.out.println("Tag is exist");
            return null;
        }

        return repository.save(tag);
    }

    public Tag update(Tag tag){
        tag.setUpdatedAt(LocalDateTime.now());
        return repository.save(tag);
    }

    public Tag deleteById(String id){
        Tag tag1 = repository.findById(id).orElse(null);
        if(tag1 == null) return null;

        repository.deleteById(id);
        return tag1;
    }

    public List<NoteTag> getAllByTagName(String name){
        return noteTagRepository.findAll()
                .stream()
                .filter(item -> item.getTagId()
                        .equals(this.getOneByName(name).getId()))
                .collect(Collectors.toList());
    }
}
