package GUIStudentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
	private List<Student> students = new ArrayList<>();
	
	public Student addStudent(String name, String stdId, String major, String Python, String Java, String DB) {
		int pythonInt = 0;
		int javaInt = 0;
		int dbInt = 0;
		// 학번 검사 분기점
		if(isStd(stdId, students)) {
			System.out.println("학생 정보 존재하지 않음. 데이터 유효성 검사 실시!");
			// 데이터 유효성 검사
			try {
				pythonInt = Integer.parseInt(Python);
				javaInt = Integer.parseInt(Java);
				dbInt = Integer.parseInt(DB);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("잘못된 입력임");
				return null;
			}
			
			if((pythonInt > 100 || javaInt > 100 || dbInt > 100) || (pythonInt < 0 || javaInt < 0 || dbInt < 0)) {
				System.out.println("점수는 0점 미만이거나 100점 보다 클 수 없습니다.");
				return null;
			}
		}else {
			System.out.println("학생 정보가 이미 등록되어 있으므로 입력 창으로 돌아감.");
			return null;
		}
		Student student = new Student(name, stdId, major, pythonInt, javaInt, dbInt);
		students.add(student);
		System.out.println("학생 정보를 추가하였습니다!");
		return student;
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
	
	public List<Student> removeStudent(){
		return new ArrayList<>();
	}
	
//	public boolean isValid() {
//		return false;
//	}

	public boolean isStd(String stdId, List<Student> students) {
		for(Student s : students) {
			if(s.getStudentId().equals(stdId)) {
				System.out.println("이미 존재함");
				return false;
			}
		}
		return true;
	}
}
