package NotifySystem;

import java.util.ArrayList;


public class Template {
    private String Subject;
    private String Content;
    private String Language;
    private int NumOfPlaceholder;

    public void setNumOfPlaceholder(int n) {
        this.NumOfPlaceholder = n;
    }

    public void setSubject(String s) {
        this.Subject = s;
    }

    public void setContent(String c) {
        this.Content = c;
    }

    public void setLanguage(String l) {
        this.Language = l;
    }

    public int getNumOfPlaceholder() {
        return NumOfPlaceholder;
    }

    public String getContent() {
        return Content;
    }

    public String getSubject() {
        return Subject;
    }

    public String getLanguage() {
        return Language;
    }

}
