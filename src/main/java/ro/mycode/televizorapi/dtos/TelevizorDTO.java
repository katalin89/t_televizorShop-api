package ro.mycode.televizorapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelevizorDTO {
    private String marca="";
    private String model="";
    private int pret=0;

}
