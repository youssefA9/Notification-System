package NotifySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Management manager = new Management();
        TemplateList templist = new TemplateList();
        Template newtemp = new Template();
        System.out.println("========= NOTIFICATION SYSTEM ============");
        Scanner input = new Scanner(System.in);
        Scanner ContentInput = new Scanner(System.in);
        Scanner cases = new Scanner(System.in);
        String line;
        StringBuilder Content = new StringBuilder();
        Scanner read = new Scanner(System.in);
        String subject, language, content;
        int switchh = 0;
        while (switchh != 6) {
            Content.delete(0, Content.length());
            System.out.println("1- Read Template \n2- Create Template \n3- Update Template \n4- Delete Template \n5- Create Notification \n6-Exit");
            switchh = input.nextInt();

            switch (switchh) {
                case 1:
                    System.out.println("Enter Subject of Template: ");

                    subject = read.nextLine();
                    System.out.println(subject);
                    manager.read(subject, templist.getTemplates());
                    break;
                case 2:

                    System.out.println("Enter Subject of The new Template");
                    subject = cases.nextLine();
                    if (manager.CheckSubject(subject, templist.getTemplates())) {

                        System.out.println("Enter Language:");
                        language = cases.nextLine();
                        System.out.println("Enter Content of The new Template: \n  (Note: Write (#) if you want to put a placeholder)");
                        System.out.println("Enter (.) in a line when you finish writing the content");
                        line = "";
                        while (ContentInput.hasNextLine()) {
                            line = ContentInput.nextLine();
                            if (line.equals("."))
                                break;
                            Content.append(line + "\n");

                        }
                        content = Content.toString();
                        Content.trimToSize();
                        newtemp = manager.create(subject, content, language);
                        manager.add(newtemp, templist.getTemplates());
                        templist.updateList();
                    } else {
                        System.out.println("This Subject is already taken!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Subject of Template");
                    subject = cases.nextLine();
                    if (!manager.CheckSubject(subject, templist.getTemplates())) {
                        System.out.println("Enter new Language : ");
                        language = cases.nextLine();
                        System.out.println("Enter Content of The new Template: \n  (Note: Write (#) if you want to put a placeholder)");
                        System.out.println("Enter (.) in a line when you finish writing the content");
                        line = "";
                        while (ContentInput.hasNextLine()) {
                            line = ContentInput.nextLine();
                            if (line.equals("."))
                                break;
                            Content.append(line + "\n");

                        }
                        content = Content.toString();
                        Content.trimToSize();
                        manager.update(subject, content, language, templist.getTemplates());
                    } else {
                        System.out.println("There is no Template with this subject!");
                    }
                    templist.updateList();
                    break;
                case 4:
                    System.out.println("Enter Subject of The new Template");
                    subject = cases.nextLine();
                    if (!manager.CheckSubject(subject, templist.getTemplates())) {
                        manager.delete(subject, templist.getTemplates());
                        templist.updateList();
                    } else {
                        System.out.println("There is no Template with this subject!");
                    }
                    break;
                case 5:
                    System.out.println("To create a notification, you must select a template");
                    //can show list of templates <subjects> then he choose subject and put the placeholders ,construct and show.
                    //or he can enter template subject, if found , get number of placeholders, enter placeholder..
                    //then construct notification then show it
                case 6:
                    break;
                default:
                    System.out.println("Wrong input! please enter a valid one!");
                    break;


            }
        }
        input.close();
        ContentInput.close();
        cases.close();
        read.close();
    }
}
