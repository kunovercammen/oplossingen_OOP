package ScannerEnWriter;


public class DomainException extends  RuntimeException{

    public DomainException(){
        super();
    }
    public DomainException(String boodschap){
        super(boodschap);
    }
}
