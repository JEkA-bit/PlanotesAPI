package net.planotes.restcontrollers;

import net.planotes.model.mongo.Note;
import net.planotes.services.domain.NoteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteRestController {

    @Autowired
    private NoteService service;

    @GetMapping("/")
    public List<Note> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Note getOne(@PathVariable(value = "id") String id){
        return service.getOne(id);
    }

    @GetMapping("/p-{id}")
    public List<Note> getAllByParentId(@PathVariable(value = "id") String id){
        return service.getAllByParentId(id);
    }

    @PostMapping("/")
    public Note create(@RequestBody Note note){
        return service.create(note);
    }

    @PutMapping("/")
    public Note update(@RequestBody Note note){
        return service.update(note);
    }

    @DeleteMapping("/{id}")
    public Note delete(@PathVariable(value = "id") String id){
        return service.delete(id);
    }
}
