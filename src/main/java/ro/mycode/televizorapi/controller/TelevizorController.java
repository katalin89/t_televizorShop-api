package ro.mycode.televizorapi.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.televizorapi.model.Televizor;
import ro.mycode.televizorapi.repository.TelevizorRepo;

import java.util.List;

@RestController
@CrossOrigin
public class TelevizorController {

    private TelevizorRepo televizorRepo;

    public TelevizorController(TelevizorRepo televizorRepo) {
        this.televizorRepo = televizorRepo;
    }
    @GetMapping("api/v1/televizoare")
    public List<Televizor>getAllTelevizoare(){
        return  televizorRepo.findAll();
    }

    @GetMapping("api/v1/televizoare/marci")
    public List<String>getAllMarci(){

        return  televizorRepo.getAllMarci();
    }
    @GetMapping("api/v1/televizoare/{marca}")
    public  List<Televizor> getAllTelevizoareByMarca(@PathVariable String marca){
        return  televizorRepo.getAllTelevizorById(marca);

    }

}




