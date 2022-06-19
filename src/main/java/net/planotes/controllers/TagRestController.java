package net.planotes.controllers;

import net.planotes.model.mongo.Tag;
import net.planotes.services.domain.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TagRestController {

    @Autowired
    private TagService service;

    @GetMapping("/")
    public List<Tag> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Tag getOne(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }

    @PostMapping("/")
    public Tag create(@RequestBody Tag tag){
        return service.create(tag);
    }

    @PutMapping("/")
    public Tag update(@RequestBody Tag tag){
        return service.update(tag);
    }

    @DeleteMapping("/{id}")
    public Tag delete(@PathVariable(value = "id") String id){
        return service.deleteById(id);
    }
}
