import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class SortStudent implements Comparator<Student> 
{ 
    public int compare(Student a, Student b) 
    { 
        if((b.getCgpa() - a.getCgpa()) !=0 ) 
            return Double.compare(b.getCgpa(),a.getCgpa());
        else if((b.getFname().compareTo(a.getFname()))!=0 ) 
            return (a.getFname()).compareTo(b.getFname());
        else if((b.getId() - a.getId()) != 0) 
            return (b.getId() - a.getId());

        return 0;
    } 
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
         Collections.sort(studentList, new SortStudent()); 

      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



