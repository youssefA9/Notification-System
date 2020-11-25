package NotifySystem;

import java.util.ArrayList;


public class Template {
    private String Subject;
    private String Content;
    ArrayList<String>Placeholders = new ArrayList<String>();
    public void setSubject(String s){
        this.Subject=s;
    }
    public void setContent(String c){
        this.Content=c;

    }
    public void setPlaceholders(ArrayList<String>m){
        for(int i=0;i<m.size();i++){
            Placeholders.add(m.get(i));
        }
    }
    public String getContent(){
        return Content;
    }

    public String getSubject(){
        return Subject;
    }

    public ArrayList<String> getPlaceholders(){
        return Placeholders;
    }

}
