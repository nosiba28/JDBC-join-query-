package St_Course_Join;

import java.sql.*;
import java.util.Scanner;

public class Join{


    public static void join()
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        con = Connect_DB.connectDB();

        try{
            int q;
            System.out.println("Please Enter the value of query:");
            Scanner sc=new Scanner(System.in);

            System.out.println("1 for showing all the student's name who enrolled in the given course:");
            System.out.println("2 for showing all the course name taken by a student:");
            q=sc.nextInt();
            if(q==1) {
                System.out.println("Please Enter the CourseID:");
                int C_id;
                C_id=sc.nextInt();
                String query = "SELECT stName from Student s, Course c WHERE s.stID=c.stID and c.CourseID="+C_id;

                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                System.out.println("STName");
                System.out.println("----------------------------------------------------------------------------");
                while (rs.next()) {
                    //  int stID = rs.getInt("stID");
                    String stName = rs.getString("stName");

                    System.out.println(stName);

                }
            }
            else if(q==2)
            {
                System.out.println("Please Enter the Student ID:");
                int st_id;
                st_id=sc.nextInt();
                String query = "Select CourseName from course c, student s where s.stID=c.stID and s.stID="+st_id;
                ps=con.prepareStatement(query);
                rs=ps.executeQuery();
                System.out.println("CourseName");
                System.out.println("----------------------------------------------------------------------------");
                while (rs.next()) {
                    //  int stID = rs.getInt("stID");
                    String CourseName = rs.getString("CourseName");

                    System.out.println(CourseName);

                }

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

}

