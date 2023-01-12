package ro.mycode.televizorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.televizorapi.model.Televizor;

import java.util.List;

@Repository
public interface TelevizorRepo extends JpaRepository<Televizor,Long> {
    @Query("select  distinct p.marca from Televizor p")
    List<String>getAllMarci();
}


/*

@Repository
public interface MasinaRepo extends JpaRepository<Masina,Long> {


    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();
}*/