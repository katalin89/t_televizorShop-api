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

    @Query("select t from Televizor t where t.marca=?1")

    List<Televizor>getAllTelevizorById(String marca);
}


/*



    @Query("select m  from  Masina m where  m.marca = ?1")//?1 este primul parametru de la List<masina>,daca ar avea 2 parametri am putea scrie si doi

    List<Masina> getAllMasinaByMarca(String marca);
}

//ordoneaza in ordine crescatoare

//@Query("select  m from Masina m order by m.pret")
//List<Masina>
//List<Masina>

//select * from autovit_db.masini order by pret asc;
*/