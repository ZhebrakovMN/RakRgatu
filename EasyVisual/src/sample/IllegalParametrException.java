package sample;

public class IllegalParametrException extends Throwable{
    String message;
    public IllegalParametrException(){
        message="Ошибка приложения";
    }
    public IllegalParametrException(String msg){
        message = msg;
    }
    public String getMessage(){
        return message;
    }
    public String toString(){
        return getClass().getName()+": "+getMessage();
    }
}
