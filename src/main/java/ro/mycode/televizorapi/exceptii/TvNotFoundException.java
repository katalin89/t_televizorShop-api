package ro.mycode.televizorapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.televizorapi.constants.Constants.TV_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TvNotFoundException  extends RuntimeException{

    public TvNotFoundException(){

        super(TV_NOT_FOUND_EXCEPTION);
    }
}
