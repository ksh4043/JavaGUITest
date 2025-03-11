package GUIStudentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
	private List<Student> students = new ArrayList<>();
	
	public void addStudent(String name, String stdId, String major, int Python, int Java, int db) {
		Student student = new Student(name, stdId, major, Python, Java, db);
		students.add(student);
		System.out.println("학생 정보를 추가하였습니다!");
	}
	
	public boolean searchStudent(String stdId, List<Student> studentList) {
		for (Student s : studentList) {
			if (s.getStudentId().equals(stdId)) {
				return true;
			}
		}
		return false;
	}
	
	public Student modifyStudent() {
		return null;
	}
}
