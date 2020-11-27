package NotifySystem;

public class Email implements Channel {
    String email;

    @Override
    public void setMethod(String method) {
        this.email = method;
    }
}
