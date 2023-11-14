import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbSql db=new DbSql();
        //db.alleBoeger();
        //db.alleLaaner();
        db.soegBog(4);
        db.udlaanBog(4,3,"12/10-2023");
        //db.soegLaaner(3);
        //db.udlaanBog(1,2,"201123");
        // db.udlaanBog(2,2,"201123");
        Laaner l=db.laanerOpl1(1);
        System.out.println(l.getFnavn()+" "+l.getEnavn()+" har lånt følgende bøger:");
        ArrayList<Bog> liste=l.getLaenteBoeger();
        for(int i=0;i< liste.size();i++){
            System.out.println(liste.get(i));
        }
    }
}