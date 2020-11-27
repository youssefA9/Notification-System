package NotifySystem;

public class SMS implements Channel {
    String phone;


    @Override
    public void setMethod(String method) {
        this.phone=method;

    }
}
