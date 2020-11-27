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
        if (file.exists()) {
            try {
                Scanner sc = new Scanner(file);
                int counter = 0;
                int templateIndex = 0;
                int placeHolder_Counter = 0;
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
                    for (int i = 0; i < templates.get(templateIndex).getContent().length(); i++) {
                        if (templates.get(templateIndex).getContent().charAt(i) == '#') {
                            placeHolder_Counter++;
                        }
                    }
                    templates.get(templateIndex).setNumOfPlaceholder(placeHolder_Counter);
                    placeHolder_Counter = 0;
                    temp = "";
                    templateIndex++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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
                file.write("‽" + "\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

