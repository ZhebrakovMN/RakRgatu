package sample;
public class RandomExeption extends Throwable {
    String message;
    public RandomExeption(){
            message="Ошибка приложения";
    }
    public RandomExeption(String msg){
            message = msg;
    }
    public String getMessage(){
        return message;
    }
    public String toString(){
        return getClass().getName()+": "+getMessage();
    }
}
