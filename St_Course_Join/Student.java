package St_Course_Join;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class Student {

    public static void readST()
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Connect_DB.connectDB();
        try {
            String query = "SELECT *FROM student";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            System.out.println("|STID|\t|STName|\t|STGender|\t\t|STEmail|\t\t\t\t|STBdate|");
            System.out.println("----------------------------------------------------------------------------");
            while (rs.next()) {
                int stID = rs.getInt("stID");
                String stName = rs.getString("stName");
                String stGender = rs.getString("stGender");
                String stEmail = rs.getString("stEmail");
                String stBdate = rs.getString("stBdate");
                System.out.println(stID + "\t\t" + stName + "\t\t " + stGender + "\t\t\t\t" + stEmail + "\t\t" + stBdate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void writeST() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Connect_DB.connectDB();

        try {
            String query="insert into student_management.student values(?, ?, ?, ?, ?)";
            PreparedStatement ps_w=con.prepareStatement(query);
            Scanner sc= new Scanner(System.in);
            Scanner sc1= new Scanner(System.in);
            int stID;
            String stName,stGender,stEmail;
            System.out.println("Enter the Student ID: ");
            stID= sc1.nextInt();
            System.out.println("Enter the Student name:");
            stName= sc.nextLine();
            System.out.println("Enter the Student Gender:");
            stGender=sc.nextLine();
            System.out.println("Enter the Student Email:");
            stEmail=sc.nextLine();
            System.out.println("Enter the Student Date of Birth:");
            String date;
            Scanner sc2 = new Scanner(System.in);
            date=sc2.nextLine();
            LocalDate stBdate=LocalDate.parse(date);

            ps_w.setInt(1, stID);
            ps_w.setString(2,stName);
            ps_w.setString(3,stGender);
            ps_w.setString(4,stEmail);
            ps_w.setDate(5, Date.valueOf(stBdate));
            ps_w.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

