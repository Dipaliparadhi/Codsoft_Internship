import java.util.Scanner;
class GradeOfStudent{
public String grade(int avgp){
switch (avgp / 10) {
case 10:
return "A+";
case 9:
return "A";
case 8:
return "B+";
case 7:
return "B";
case 6:
return "C";
case 5:
return "D";
default:
return "Fail";
}

}
}
public class MainMethod4{
public static void main(String[] args){
GradeOfStudent g = new GradeOfStudent();
Scanner sc = new Scanner(System.in);
//Taking input of how many subjects are there
System.out.println("Enter the amount of subjects");
int totalsubs = sc.nextInt();
int totalmarks = 0;
//Taking and adding all the marks
for (int i = 0; i < totalsubs; i++) {
System.out.println("Enter the marks obtained in subject " + (i + 1));
int marks = sc.nextInt();
totalmarks += marks;
}
//Calculating Percentage
int avgp = totalmarks / totalsubs;
//Calculating Grades
String Grade = g.grade(avgp);
//Displaying all the Data
System.out.println("Total marks obtained :- " + totalmarks);
System.out.println("Percentage obtained :- " + avgp+"%");
System.out.println("Grade obtained :- " + Grade);
sc.close();
//Lets test the code
}
}