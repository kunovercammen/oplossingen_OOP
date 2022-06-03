package inlezenUitBestand.db;

public class DbException extends RuntimeException {

    public DbException(){
        super();
    }
    public DbException(String s){
        super(s);
    }
}
