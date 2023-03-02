package ro.mycode.televizorapi.controller;

import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import ro.mycode.televizorapi.dtos.TelevizorDTO;
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
    public List<Televizor> getAllTelevizoare() {
        return televizorRepo.findAll();
    }

    @GetMapping("api/v1/televizoare/marci")
    public List<String> getAllMarci() {

        return televizorRepo.getAllMarci();
    }

    @GetMapping("api/v1/televizoare/{marca}")
    public List<Televizor> getAllTelevizoareByMarca(@PathVariable String marca) {
        return televizorRepo.getAllTelevizorByMarca(marca);

    }

    @PostMapping("api/v1/add")
    public Televizor addTelevizor(@RequestBody Televizor televizor) {
        this.televizorRepo.save(televizor);

        return televizor;
    }

    @DeleteMapping("api/v1/deleteByMarca/{marca}")
    public String deleteTelevizor(@PathVariable String marca) {

        this.televizorRepo.deleteTelevizorByMarca(marca);

        return marca;
    }


    @DeleteMapping("api/v1/delete/{id}")
    public long deleteTelevizorById(@PathVariable long id) {
        this.televizorRepo.deleteById(id);
        return id;
    }

    @PutMapping("api/v1/update")
    public Televizor updateTelevizor(@RequestBody TelevizorDTO televizor) {
        Televizor t = televizorRepo.findByModel(televizor.getModel());

        if (televizor.getMarca().equals("") == false) {
            t.setMarca(televizor.getMarca());
        } else System.out.println("Nu are valoare");

        if (televizor.getModel().equals("") == false) {
            t.setModel(televizor.getModel());
        } else System.out.println("Nu are valoare");

        if (televizor.getPret() != 0) {
            t.setPret(televizor.getPret());
        }else System.out.println("Nu are valoare");
        televizorRepo.save(t);

        return t;
    }

    @GetMapping("api/v1/get/televizor/{id}")

    public  Televizor getAllTelevizorById(@PathVariable int id){
        return  televizorRepo.findById(Long.valueOf(id)).get();
    }

    @GetMapping("api/v1/sortByPrice")
    public List<Televizor>sortByPrice(){
        return  televizorRepo.sortByPrice();
    }

    @GetMapping("api/v1/sortByModel")
    public List<Televizor>sortByModel(){
        return  televizorRepo.sortByModel();
    }


}




