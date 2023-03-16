package ro.mycode.televizorapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.televizorapi.constants.Constants.EMPTY_DATABASE_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptieTvDBEmpty  extends RuntimeException{
    public  ExceptieTvDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
