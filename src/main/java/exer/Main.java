package exer;


public class Main
{


    public static void main(String[] args) throws Exception {
        Input input = new Input();
        input.console();
        Mysqlcon mysqlcon = new Mysqlcon();
        mysqlcon.connection();
    }


}//EOF

