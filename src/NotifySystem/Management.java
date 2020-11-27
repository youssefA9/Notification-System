package NotifySystem;

import java.util.ArrayList;

public class Management {
    public Template create(String Subject, String Content, String language) {
        Template template = new Template();
        template.setSubject(Subject);
        template.setContent(Content);
        template.setLanguage(language);
        int placeHolder_Counter = 0;
        for (int i = 0; i < template.getContent().length(); i++) {
            if (template.getContent().charAt(i) == '#') {
                placeHolder_Counter++;
            }
        }
        template.setNumOfPlaceholder(placeHolder_Counter);
        return template;
    }

    public ArrayList<Template> add(Template newTemplate, ArrayList<Template> temp) {
        temp.add(newTemplate);
        return temp;
    }

    public boolean CheckSubject(String subject, ArrayList<Template> temp) {
        for (int i = 0; i < temp.size(); i++) {
            if ((temp.get(i).getSubject().toLowerCase()).equals(subject.toLowerCase()))
                return false;
        }
        return true;
    }

    public void read(String subject, ArrayList<Template> temp) {
        boolean flag = true;
        for (int i = 0; i < temp.size(); i++) {
            if ((temp.get(i).getSubject().toLowerCase()).equals(subject.toLowerCase())) {
                System.out.println(temp.get(i).getSubject());
                System.out.println(temp.get(i).getLanguage());
                System.out.println(temp.get(i).getContent());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Can't find this template!");
        }
    }

    public void update(String Subject, String Content, String language, ArrayList<Template> temp) {
        int placeHolder_Counter = 0;
        for (int i = 0; i < temp.size(); i++) {
            if ((temp.get(i).getSubject().toLowerCase()).equals(Subject.toLowerCase())) {
                temp.get(i).setLanguage(language);
                temp.get(i).setContent(Content);
                for (int j = 0; j < Content.length(); j++) {
                    if (Content.charAt(j) == '#') {
                        placeHolder_Counter++;
                    }
                }
                temp.get(i).setNumOfPlaceholder(placeHolder_Counter);
            }
        }
    }

    public void delete(String Subject, ArrayList<Template> temp) {
        boolean flag = true;
        for (int i = 0; i < temp.size(); i++) {
            if ((temp.get(i).getSubject().toLowerCase()).equals(Subject.toLowerCase())) {
                temp.remove(temp.get(i));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Can't find this template!");
        }
    }
}
