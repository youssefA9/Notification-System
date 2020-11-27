package NotifySystem;

import java.util.ArrayList;

public class Notification {
    TemplateList t;
    String subject, language, content = null;
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
        String c = temp.getContent();
        for (int i = 0; i < c.length(); i++) {

            if (c.charAt(i) == '#') {
                String s = c.substring(0, i);
                c = c.substring(i + 1, c.length());
                c = s + Placeholders.get(z) + c;
                z++;
            }
        }
    }

    public void ShowNotify() {
        System.out.println("Subject is: " + this.subject);

    }

}
