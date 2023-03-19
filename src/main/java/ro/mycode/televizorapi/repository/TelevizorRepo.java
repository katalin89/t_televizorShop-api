package ro.mycode.televizorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.televizorapi.model.Televizor;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TelevizorRepo extends JpaRepository<Televizor,Long> {
    @Query("select  distinct p.marca from Televizor p")
    List<String>getAllMarci();

    @Query("select t from Televizor t where t.marca=?1")

    List<Televizor>getAllTelevizorById(String marca);


    @Query("select t from Televizor t where t.marca=?1")

    List<Televizor>getAllTelevizorByMarca(String marca);


    Televizor findTelevizorByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Televizor t where t.model like ?1")
    void deleteTelevizorByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Televizor t where t.marca like ?1")
    void deleteTelevizorByMarca(String marca);

    @Transactional
    @Modifying
    @Query("delete from Televizor t where t.id = ?1")
    void deleteTelevizorById(String id);

    @Transactional
    @Modifying
    @Query("select distinct t from Televizor  t order by  t.model")
    List<Televizor>sortByModel();

    @Transactional
    @Modifying
    @Query("select distinct t from Televizor  t order by  t.marca")
    List<Televizor>sortByMarca();

    @Transactional
    @Modifying
    @Query("select distinct t from Televizor  t order by  t.pret")
    List<Televizor>sortByPret();

    @Transactional
    @Modifying
    @Query("select t from Televizor t where t.marca=?1  and t.model=?2")
    List<Televizor>findTvWith(String marca,String model);
//    @PostMapping("/add")
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