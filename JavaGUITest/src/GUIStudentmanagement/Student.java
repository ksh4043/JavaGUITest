package GUIStudentmanagement;

public class Student {
	private String name;
	private String stdId;
	private String major;
	private int Python;
	private int Java;
	private int db;
	
	public Student(String name, String stdId, String major, int Python, int Java, int db) {
		this.name = name;
		this.stdId = stdId;
		this.major = major;
		this.Python = Python;
		this.Java = Java;
		this.db = db;	
	}
	
	public String getStudentName() {
		return name;
	}
	
	public String getStudentId() {
		return stdId;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getPython() {
		return Python;
	}
	
	public int getJava() {
		return Java;
	}
	
	public int getDb() {
		return db;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + ", 학번 : " + stdId + ", 학과 : " + major + ", 파이썬 점수 : " + Python + ", 자바 점수 : " + Java + ", DB 점수 : " + db;
	}
}
