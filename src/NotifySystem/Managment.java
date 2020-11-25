package NotifySystem;

import java.util.ArrayList;

public class Managment {

    public Template create(String Subject, String Content , ArrayList<String> Placeholders){
        Template template=new Template();
        template.setSubject(Subject);
        template.setContent(Content);
        template.setPlaceholders(Placeholders);
        return template;
    }
    public ArrayList<Template>add(Template newTemplate,ArrayList<Template>temp){

        temp.add(newTemplate);
        return temp;

    }
    public void read(String Subject,ArrayList<Template>temp){
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).getSubject().equals(Subject)){
                System.out.println(temp.get(i).getContent());
                break;
            }
        }
        System.out.println("Can't find this template!");

    }
    public void update(String Subject,String Content,ArrayList<String>place,ArrayList<Template>temp){
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).getSubject().equals(Subject)){
                temp.get(i).setContent(Content);
                temp.get(i).setPlaceholders(place);
                break;
            }
        }
    }
    public void delete(String Subject,ArrayList<Template>temp){
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).getSubject().equals(Subject)){
                temp.remove(temp.get(i));
                break;
            }
        }
        System.out.println("Can't find this template!");

    }
}
