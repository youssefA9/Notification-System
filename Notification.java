package NotifySystem;

import java.util.ArrayList;

public class Notification {
    //private ArrayList<Template> t=new ArrayList<Template>();
    TemplateList t;
    channel c;
    public  void notify(TemplateList obj){
for(int i=0;i<obj.getTemplates().size();i++){

    t.getTemplates().add(obj.getTemplates().get(i));

}


    }
    public Template Search(String sub){
        for(int i=0;i<t.getTemplates().size();i++){
        if(t.getTemplates().get(i).getSubject().equals(sub)){
            return t.getTemplates().get(i);

        }


        }

        return null;
    }
public void ShowNotify(){

        for(int i=0;i<t.getTemplates().size();i++){
            System.out.println(t.getTemplates().get(i));


        }


}

}
