package ro.mycode.televizorapi.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.televizorapi.dtos.TelevizorDTO;
import ro.mycode.televizorapi.model.Televizor;
import ro.mycode.televizorapi.service.TvService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/televizor")

public class TelevizorResource {

    private TvService tvService;

    public TelevizorResource(TvService tvService) {
        this.tvService = tvService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Televizor>> getAllTelevizoare() {
        List<Televizor> allTelevizoare = tvService.getAllTelevizoare();
        return new ResponseEntity<>(allTelevizoare, HttpStatus.OK);

    }

    @DeleteMapping("/deleteTelevizorByModel/{model}")
    ResponseEntity deleteByModel(@PathVariable String model) {
        this.tvService.deleteTelevizorByModel(model);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody TelevizorDTO televizor, String model) {
        this.tvService.update(televizor, model);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
