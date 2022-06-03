package domain_herhalingstest;


public class DomainException extends  RuntimeException{

    public DomainException(){
        super();
    }
    public DomainException(String boodschap){
        super(boodschap);
    }
}
