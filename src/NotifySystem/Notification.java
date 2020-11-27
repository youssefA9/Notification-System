package NotifySystem;

import java.util.ArrayList;

public class Notification {
    TemplateList t;
    String subject, language, content;
    ArrayList<String> Placeholders = new ArrayList<>();
    Channel c;

    public void setPlaceholders(ArrayList<String> placeholders) {
        Placeholders = placeholders;
    }

    public ArrayList<String> getPlaceholders() {
        return Placeholders;
    }

    /*
        public Template Search(String sub){
            for(int i=0;i<t.getTemplates().size();i++){
                if(t.getTemplates().get(i).getSubject().equals(sub)){
                    return t.getTemplates().get(i);

                }
            }
            return null;
        }*/
    public void ConstructNotification(Template temp) {

        this.subject = temp.getSubject();
        this.language = temp.getLanguage();
        int z = 0;
        for (int i = 0; i < temp.getContent().length(); i++) {

            if (temp.getContent().charAt(i) == '#') {
                //  this.content.charAt(i)=Placeholders.get(z);
                z++;

            } else {
                //   this.content.charAt(i)=temp.getContent().charAt(i);

            }

        }


    }


    public void ShowNotify() {
        System.out.println("Subject is: " + this.subject);

    }

}
