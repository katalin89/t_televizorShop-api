package ro.mycode.televizorapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.televizorapi.constants.Constants.TV_DUPLICATION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingTv extends  RuntimeException {

    public  ExistingTv(){
        super( TV_DUPLICATION);
    }
}
