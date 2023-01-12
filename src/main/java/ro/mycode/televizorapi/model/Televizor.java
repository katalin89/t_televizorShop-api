package ro.mycode.televizorapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name="televizoare")
@AllArgsConstructor
@NoArgsConstructor
public class Televizor  implements Comparable<Televizor>{
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String marca;
    private String model;
    private int pret;



    @Override
    public int compareTo(Televizor o) {
        return 0;
    }

    @Override
    public String toString(){
        String text="";
        text+=id+","+marca+","+model+","+pret;
        return  text;
    }

    public int compare(Object o){
        Televizor televizor=(Televizor) o;
        if(this.pret>televizor.pret){
            return 1;
        }else if(this.pret<televizor.pret){
            return  0;
        }
        return -1;
    }
}

