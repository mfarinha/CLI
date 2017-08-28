package exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input
{

    private boolean running = true;
    private String tag = "Guest";
    private String input;
    private String pass;
    private String user = "";
    private int lineNumber = 1;
    private List<String> history = new ArrayList<String>();
    private Mysqlcon mysqlcon = new Mysqlcon();


    public void console() throws Exception {



        while (running) {
            System.out.print("MF " + tag + " "+ lineNumber + ":");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            lineNumber++;
            history.add(input);

            if (input.equalsIgnoreCase("History")){

                    System.out.println(history);

            }

            if (input.equalsIgnoreCase("exit"))
            {
                running = false;
            }

            if (input.equalsIgnoreCase("login")){
                System.out.println("Enter username");
                user = sc.nextLine();
                System.out.println("Enter Password");
                pass = sc.nextLine();
                mysqlcon.login(user, pass);

                if (mysqlcon.logged == true){
                tag = user;
            }

            }

            if (input.equalsIgnoreCase("Create user")){
                System.out.println("Insert username");
                user = sc.nextLine();
                System.out.println("Insert Password");
                pass = sc.nextLine();
                mysqlcon.validateUsernameAndPassowrd(user, pass);

            }

        }

    }

}//EOF
