package St_Course_Join;

import java.util.Scanner;

public class TestDB {
    public static void main(String agrs[]) {
        // Student st = null;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the value of n:");
        System.out.println("1 for showing student's info and 2 for course info and 3 for Join operation:");
        n = sc.nextInt();
         if (n == 1) {
            Student.readST();
            Student.writeST();
        }
        else if(n==2)
         {
             Course.readCourse();
             Course.writeCourse();
         }
        else
         {
             Join.join();
         }
    }
}
