
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

	private List<Double> grades = new ArrayList<>();
	private double gradesAverage;

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	
	public List<Double> getGrades(){
		return grades;
	}
	
	public void addGrade(double grade) {
		grades.add(grade);
	}
	
	public double getGradesAverage() {
		int i = grades.size();
		double sum = grades.stream().mapToDouble(Double::doubleValue).sum();
		gradesAverage = sum/i;
		return gradesAverage;
	}
	
	
	
	
}
