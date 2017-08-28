package exer;


public class Accounts
{

    public static String[][] userAndPassword= new String[10][10];
    static boolean  logged = false;

    public static void createUserValidation(String user, String pass) {
        for (int i = 0; i < userAndPassword.length; i++) {
            for (int j = 0; j < userAndPassword[1].length; j++) {
                if (userAndPassword[i][0].equalsIgnoreCase(user)) {
                    System.out.println("User in use");
                }

            }
        }
    }

    public static void createUser(String user, String pass){

        for(int i = 0; i < userAndPassword.length; i++) {
            userAndPassword[i][0] = user;
            for (int j = 0; j < userAndPassword[1].length; j++)
            {
                userAndPassword[0][j] = pass;
            }
        }

    }

    public static void loginUser (String user, String pass)
    {
        for(int i = 0; i < userAndPassword.length; i++)
        {
            for (int j = 0; j < userAndPassword[1].length; j++)
            {
                if (userAndPassword[i][j].equalsIgnoreCase(user))
                {
                    if (userAndPassword[i][j].equalsIgnoreCase(pass)) {

                        logged = true;
                    }
                }else{
                    System.out.println("Incorrect User or Password");
                }

            }
        }
    }


} //EOF
