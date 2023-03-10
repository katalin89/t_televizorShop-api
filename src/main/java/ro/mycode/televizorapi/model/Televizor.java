package ro.mycode.televizorapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import ro.mycode.televizorapi.dtos.TelevizorDTO;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
//text+=id+","+marca+","+model+","+pret;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "Televizor")
@Table(name="televizoare")

public class Televizor  implements Comparable<Televizor>{

    @Id
    @SequenceGenerator(name="televizor_sequence",sequenceName = "televizor_sequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "televizor_sequence")
    private Long id;

    @Column(name="marca",nullable = false)
    @Size(min=2,message="Marca trebuie sa fie cel putin din doua litere")
    private String marca;

    @Column(name="model",nullable=false)
    @Size(max=20,message = "Nu poate fi ma lung decat 20 de caractere")
    private String model;

    @Column(name="pret",nullable = false)
    @Min(value=5000,message = "Pretul minim este de 5000")
    private  int pret;


    @Override
    public int compareTo(Televizor o) {

        if(this.model.compareTo(o.model)>0){
            return 1;
        }
        if(this.model.compareTo(o.model)<0){
            return -1;
        }else

            return 0;
    }
    @Override
    public  boolean equals(Object o){
        Televizor televizor=(Televizor) o;
        return  this.model.equals(televizor.model);
    }
}

