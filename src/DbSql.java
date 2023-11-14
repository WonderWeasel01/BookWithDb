import java.sql.*;


public class DbSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:/Users/alexwentzel/Documents/1Semester/BookWithDb/identifier.sqlite";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void alleBoeger() {
        try {
            String sql = "select * from Bog";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("bogId"));
                System.out.println(rs.getString("titel"));
                System.out.println(rs.getString("forfatter"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void udlaanBog(int bogId,int lId,String dato){
        try {
            String sql = "insert into udlaan (bogId,lId,ldato,adato) values("+String.valueOf(bogId)+","+String.valueOf(lId)+","+dato+","+"NULL"+");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void laanerOpl(int lId){
        try {
            String sql = "select * from Laaner inner join main.Udlaan on Laaner.lId=udlaan.lId inner join Bog on Bog.bogId=udlaan.bogId";
            sql+=" where Laaner.lId='"+String.valueOf(lId)+"'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("lId"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
                System.out.println(rs.getString("titel"));
                System.out.println(rs.getString("forfatter"));

            }
            stmt.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public Laaner laanerOpl1(int lId){
        Laaner l=new Laaner();
        l.setlNr(lId);
        try {
            String sql = "select * from Laaner where Laaner.lId='"+String.valueOf(lId)+"'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            if(rs.next()){
                l.setFnavn(rs.getString("fnavn"));
                l.setEnavn(rs.getString("enavn"));
            }
            sql = "select * from udlaan inner join Bog on Bog.bogId=udlaan.bogId";
            sql+=" where udlaan.lId='"+String.valueOf(lId)+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Bog b=new Bog();
                b.setTitel(rs.getString("titel"));
                b.setForfatter(rs.getString("forfatter"));
                l.laenBog(b);
                System.out.println("Hej");
            }
            stmt.close();

            return l;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void alleLaaner() {
        try {
            String sql = "select * from main.Laaner";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("lid"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void soegLaaner(int lnr) {
        try {
            String sql = "select * from main.Laaner where lid="+String.valueOf(lnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            if (rs.next()) {
                System.out.println(rs.getInt("lid"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void soegBog(int bogid) {
        try {
            String sql = "select * from main.Bog where Bog.bogid="+String.valueOf(bogid);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            if (rs.next()) {
                System.out.println(rs.getInt("bogid"));
                System.out.println(rs.getString("titel"));
                System.out.println(rs.getString("forfatter"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}