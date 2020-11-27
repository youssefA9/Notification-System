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

    public void notify(TemplateList obj) {
        for (int i = 0; i < obj.getTemplates().size(); i++) {

            t.getTemplates().add(obj.getTemplates().get(i));

        }
    }

    public Template Search(String sub) {
        for (int i = 0; i < t.getTemplates().size(); i++) {
            if (t.getTemplates().get(i).getSubject().equals(sub)) {
                return t.getTemplates().get(i);

            }
        }
        return null;
    }

    /*  public void ConstructNotification(Template temp){
         this.subject=temp.getSubject();
         this.language=temp.getLanguage();
         String newContent=
      }

     */
    public void ShowNotify(Notification obj) {
        //  System.out.println("Subject is: "+obj.);

    }

}
