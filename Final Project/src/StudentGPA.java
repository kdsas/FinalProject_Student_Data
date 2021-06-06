import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;



class Student {
	 String name;    // Name
    String address; // Address
     double GPA;   // GPA
	public Student() {
		this(" ", " ", 0);
	}
	
	public Student(String address, String name, double gpa) {//Construct a new student with given fields
		this.address    = address;
		this.name   = name;
	    this.GPA   = gpa;
	 
	}

	
@Override
public String toString() {

return "Student [address=" + address + ", name=" + name + ", GPA=" + GPA + "]";//Returns linked list info in string format

}	
}
public class StudentGPA {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);// Reads console input
		System.out.println("Input number of students:");
		int n = Integer.parseInt(in.nextLine().trim());//Establishes number of students entered 
		System.out.println("Input Student Name, Address, and GPA:");
		Student stu = new Student();//References student class
		
		for (int i = 0; i < n; i ++) {// For loop of each student
			stu.name = in.next();//Reads name input from console
			stu.address = in.next();//Reads address input from console
			stu.GPA = in.nextDouble();//Reads GPA input from console
	        
	        
			System.out.println(stu.name + " " +stu.address+ " "+ stu.GPA);//Prints info out
			
			final List<String> nameList = new ArrayList<>();//Establishes name list for adding student names to txt file
			nameList.add(stu.name);//Adds name to list
	        
            LinkedList<Student> students = new LinkedList<Student>(); //Establish object of the linked list class
	    	 students.add(new Student(stu.address, stu.name, stu.GPA)); //Add variables to the linked list
	    	 System.out.println(students);// Prints info out
	   
			final Path path = Paths.get("studentInfo");//Gets txt file
			Files.write(path, nameList, StandardCharsets.UTF_8, StandardOpenOption.CREATE);//Creates txt file if it doesn't exist
			Files.write(path, nameList, StandardCharsets.UTF_8, StandardOpenOption.APPEND);//Writes name value at the end of file
			
			BufferedReader reader = null; //Reads txt file
			 
	        BufferedWriter writer = null;//Writes to txt file
	 
	        //Create an ArrayList object to hold the lines of input file
	 
	        ArrayList<String> lines = new ArrayList<String>();
	 
	        try
	        {
	            //Creating BufferedReader object to read the input file
	 
	            reader = new BufferedReader(new FileReader("studentInfo"));
	 
	            //Reading all the lines of input file one by one and adding them into ArrayList
	 
	            String currentLine = reader.readLine();
	 
	            while (currentLine != null)
	            {
	                lines.add(currentLine);
	 
	                currentLine = reader.readLine();
	            }
	 
	            //Sorts the ArrayList
	 
	            Collections.sort(lines);
	 
	            //Creating BufferedWriter object to write in txt file
	 
	            writer = new BufferedWriter(new FileWriter("studentInfo"));
	 
	            //Writing sorted lines in txt file
	 
	            for (String line : lines)
	            {
	                writer.write(line);
	 
	                writer.newLine();
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            //Closing the reader and writer
	 
	            try
	            {
	                if (reader != null)
	                {
	                    reader.close();
	                }
	 
	                if(writer != null)
	                {
	                    writer.close();
	                }
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	
		
			
			
		
		

		
			
	    	   
	    	

		
	
		
	}

	
	


}



	
	


		 

	 
    
    



