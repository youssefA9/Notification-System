package NotifySystem;

import java.util.ArrayList;

public class Templates {
    private ArrayList<Template> templates=new ArrayList<Template>();
    Templates(){
        Template template=new Template();
        Managment manager=new Managment();
        ArrayList<String>place=new ArrayList<String>();
        place.add("X");place.add("Y");
        String content="Dear " + place.get(0) + ", \n" + "Thanks for buying our product : " + place.get(1) + ".\n" + "Best regards";
        template=manager.create("Confirmation",content,place);
        templates.add(template);
    }

    public void setTemplates(ArrayList<Template> templates) {
        this.templates = templates;
    }

    public ArrayList<Template> getTemplates() {
        return templates;
    }
}
