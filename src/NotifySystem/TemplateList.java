package NotifySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TemplateList {
    private ArrayList<Template> templates = new ArrayList<Template>();

    TemplateList() {
        File file = new File("backup.txt");
        try {
            Scanner sc = new Scanner(file);
            int counter = 0;
            int templateIndex = 0;
            String temp = "";
            String temp1;


            while (sc.hasNextLine()) {
                counter = 0;
                templates.add(new Template());
                temp1 = sc.nextLine();
                while (!temp1.matches("‽")) {
                    if (counter == 0) {
                        templates.get(templateIndex).setSubject(temp1);
                        temp1 = sc.nextLine();
                        counter++;
                    } else if (counter == 1) {
                        templates.get(templateIndex).setLanguage(temp1);
                        temp1 = sc.nextLine();
                        counter++;
                    } else {
                        if (counter != 2) {
                            temp = templates.get(templateIndex).getContent();
                            temp += "\n";
                        }
                        temp += temp1;
                        templates.get(templateIndex).setContent(temp);
                        temp1 = sc.nextLine();
                        counter++;
                    }
                }
                temp = "";
                templateIndex++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*Template template = new Template();
        Management manager = new Management();
        ArrayList<String> place = new ArrayList<String>();
        place.add("X");
        place.add("Y");
        String content = "Dear " + place.get(0) + ", \n" + "Thanks for buying our product : " + place.get(1) + ".\n" + "Best regards";
        template = manager.create("Confirmation", content, place);
        templates.add(template);*/
    }


    public void setTemplates(ArrayList<Template> templates) {
        this.templates = templates;
    }

    public ArrayList<Template> getTemplates() {
        return templates;
    }

    public void updateList() {

        try {
            FileWriter file = new FileWriter("backup.txt");
            for (int i = 0; i < templates.size(); i++) {
                file.write(templates.get(i).getSubject() + "\n");
                file.write(templates.get(i).getLanguage() + "\n");
                file.write(templates.get(i).getContent() + "\n");
                file.write("‽");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
