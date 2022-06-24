package St_Course_Join;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class Course {
    public static void readCourse()
    {
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = Connect_DB.connectDB();
        try {
            String query = "SELECT *FROM Course";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            System.out.println("|STID|\t|STName|\t|STGender|\t\t|STEmail|\t\t\t\t|STBdate|\t|CourseID|\t|CourseName|\t\t|CourseTeacher|");
            System.out.println("----------------------------------------------------------------------------");
            while (rs.next()) {
                int stID=rs.getInt("stID");
                int CourseID=rs.getInt("CourseID");
                String CourseName = rs.getString("CourseName");
                String CourseTeacher= rs.getString("CourseTeacher");
                System.out.println(stID + "\t\t" + CourseID + "\t\t " + CourseName + "\t\t\t\t" + CourseTeacher);

            }
            }

        catch(Exception e) {
            System.out.println(e);
        }
        }
        public static void writeCourse()
        {
            Connection conn= null;
            PreparedStatement ps =null;
            ResultSet rs=null;

            conn= Connect_DB.connectDB();

            try{
                String query="insert into student_management.course values(?, ?, ?, ?)";
                PreparedStatement ps_w=conn.prepareStatement(query);
                Scanner sc= new Scanner(System.in);
                Scanner sc1= new Scanner(System.in);
                int stID, CourseID;
                String CourseName,CourseTeacher;
                System.out.println("Enter the Student ID: ");
                stID= sc.nextInt();
                System.out.println("Enter the Course ID:");
                CourseID= sc.nextInt();
                System.out.println("Enter the Course Name:");
                CourseName=sc1.nextLine();
                System.out.println("Enter the Course Teacher:");
                CourseTeacher=sc1.nextLine();

                ps_w.setInt(1, stID);
                ps_w.setInt(2, CourseID);
                ps_w.setString(3,CourseName);
                ps_w.setString(4,CourseTeacher);
                ps_w.execute();
                conn.close();


            }
            catch(Exception e)
            {
             System.out.println(e);
            }
        }
    }

