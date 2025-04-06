package GUIStudentmanagement;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;
// 화면 전환이 여러번 이루어지는 경우, 기능이 달라짐에 따라 메서드를 각각 정의하여 작성
public class MainFrame extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private StudentManager stdM = new StudentManager();
	private JPanel menuPanel;
	private JPanel inputPanel;
	private JPanel searchPanel;
	private JPanel modifyPanel;
	private JPanel removePanel;
	private JPanel exitPanel;
	private JPanel unvalidPanel;
	private JPanel inputSeccessPanel;
	private JPanel searchSuccessPanel;
	private JPanel searchFailPanel;
	
	public MainFrame() {
		// GUI 화면을 구현함
		setTitle("학생 성적 관리 프로그램");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
		menuPanel = createMenuPanel();
		inputPanel = createInputPanel();
		searchPanel = createSearchPanel();
		modifyPanel = createModifyPanel();
		removePanel = createRemovePanel();
		exitPanel = createExitPanel();
		unvalidPanel = createUnvP();
		inputSeccessPanel = createInputSccess();
		searchSuccessPanel = createSearchSuccess();
		searchFailPanel = createSearchFail();
		
		mainPanel.add(menuPanel, "메뉴");
		mainPanel.add(inputPanel, "입력");
		mainPanel.add(searchPanel, "검색");
		mainPanel.add(modifyPanel, "수정");
		mainPanel.add(removePanel, "삭제");
		mainPanel.add(exitPanel, "종료");
		mainPanel.add(unvalidPanel, "입력 오류");
		mainPanel.add(inputSeccessPanel, "입력 성공");
		mainPanel.add(searchSuccessPanel, "검색 성공");
		mainPanel.add(searchFailPanel, "검색 실패");
		
		add(mainPanel);
	}
	
	private JPanel createMenuPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		
		JButton inputBtn = new JButton("학생 정보 입력");
		JButton searchBtn = new JButton("학생 정보 검색");
		JButton modifyBtn = new JButton("학생 정보 수정");
		JButton removeBtn = new JButton("학생 정보 삭제");
		JButton exitBtn = new JButton("프로그램 종료");
		
		inputBtn.addActionListener(e -> cardLayout.show(mainPanel, "입력"));
		searchBtn.addActionListener(e -> cardLayout.show(mainPanel, "검색"));
		modifyBtn.addActionListener(e -> cardLayout.show(mainPanel, "수정"));
		removeBtn.addActionListener(e -> cardLayout.show(mainPanel, "삭제"));
		exitBtn.addActionListener(e -> cardLayout.show(mainPanel, "종료"));
		
		panel.add(inputBtn);
		panel.add(searchBtn);
		panel.add(modifyBtn);
		panel.add(removeBtn);
		panel.add(exitBtn);
		
		return panel;
	}
	
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new GridLayout(7, 2));
		JLabel nameLabel = new JLabel("이름 : ");
		JTextField nameField = new JTextField();
		JLabel majorLabel = new JLabel("학과 : ");
		JTextField majorField = new JTextField();
		JLabel sIdLabel = new JLabel("학번 : ");
		JTextField sIdField = new JTextField();
		JLabel pythonLabel = new JLabel("파이썬 점수 : ");
		JTextField pythonField = new JTextField();
		JLabel javaLabel = new JLabel("자바 점수 : ");
		JTextField javaField = new JTextField();
		JLabel dbLabel = new JLabel("DB 점수 : ");
		JTextField dbField = new JTextField();
		JButton submitBtn = new JButton("입력 완료");
        JButton backBtn = new JButton("뒤로 가기");
        
        // 학번 검사 및 데이터 유효성 검사
        submitBtn.addActionListener(e -> {
        	Student student = stdM.addStudent(nameField.getText(), sIdField.getText(), majorField.getText(), pythonField.getText(), javaField.getText(), dbField.getText());
        	// student 객체가 null 인 경우, 비정상적인 데이터 입력이므로 재입력을 요구하거나 작업을 취소함
        	if(student == null) {
        		cardLayout.show(mainPanel, "입력 오류");
        	}else {
        		// null 이 아닌 경우, 정상적인 입력이므로 입력된 학생의 정보를 한번 보여줌
        		cardLayout.show(mainPanel, "입력 성공");
        		System.out.println("Success Test");
        		System.out.println(student.getStudentName() + " " + student.getStudentId() + " " + student.getMajor() + " " + student.getPython() + " " + student.getJava() + " " + student.getDb());
        	}
        });
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));
        
        panel.add(nameLabel);		
        panel.add(nameField);
        panel.add(majorLabel);
        panel.add(majorField);
        panel.add(sIdLabel);
        panel.add(sIdField);
        panel.add(pythonLabel);
        panel.add(pythonField);
        panel.add(javaLabel);
        panel.add(javaField);
        panel.add(dbLabel);
        panel.add(dbField);
        panel.add(submitBtn);
        panel.add(backBtn);
        
		return panel;
	}
	
	private JPanel createSearchPanel() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel sIdLabel = new JLabel("학번 : ");
		JTextField sIdField = new JTextField();
		JButton submitBtn = new JButton("입력 완료");
        JButton backBtn = new JButton("뒤로 가기");
        
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));
        submitBtn.addActionListener(e -> {
        	Student student = stdM.searchStudent(sIdField.getText());
        	if(student == null) {
        		// 검색에 실패했을 경우
        		cardLayout.show(mainPanel, "검색 실패");
        	}else {
        		// 검색에 성공해서 학생 정보가 넘어왔을 경우
        		printStudent(student);
        		cardLayout.show(mainPanel, "검색 성공");
        	}
        });
        
        panel.add(sIdLabel);
        panel.add(sIdField);
        panel.add(submitBtn);
        panel.add(backBtn);
		
		return panel;
	}

	private JPanel createModifyPanel() {
		JPanel panel = createSearchPanel();
		// 수정을 위한 메서드 추가 또는 호출 이후 패널을 return
		
		return panel;
	}
	
	private JPanel createRemovePanel() {
		JPanel panel = createSearchPanel();
		// 삭제를 위한 메서드 추가 또는 호출 이후 패널을 return
		
		return panel;
	}

	private JPanel createExitPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1));
		JLabel messageLabel = new JLabel("프로그램을 종료합니다.");
		JButton cfBtn = new JButton("확인");
		
		cfBtn.addActionListener(e -> System.exit(0));
		
		panel.add(messageLabel);
		panel.add(cfBtn);
		
		return panel;
	}

	private JPanel createUnvP() {
		JPanel panel = new JPanel(new GridLayout(2,1));
		JLabel label = new JLabel("잘못된 입력입니다. 다시 입력하여 주십시오.");
		JButton btn = new JButton("확인");
		
		btn.addActionListener(e -> {
			resetInputPanel();
			cardLayout.show(mainPanel, "입력");
		});
		
		panel.add(label);
		panel.add(btn);
		
		return panel;
	}

	// 입력 화면을 초기화
	private void resetInputPanel() {
		if (inputPanel != null) {
	        mainPanel.remove(inputPanel);
	    }

	    inputPanel = createInputPanel();
	    mainPanel.add(inputPanel, "입력");

	    // revalidate -> [JPanel의 컴포넌트가 추가/제거 되는 경우, repaint -> UI를 다시 그림(단순 재호출)] -> 갱신시키는 역할
	    mainPanel.revalidate();
	    mainPanel.repaint();
	}
	
	private JPanel createInputSccess() {
		JPanel panel = new JPanel(new GridLayout(3,1));
		JLabel label = new JLabel("학생 정보 입력 성공!");
		JButton btn = new JButton("확인");
		
		btn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));
		
		panel.add(label);
		panel.add(btn);
		
		return panel;
	}
	
	private JPanel createSearchFail() {
		// 검색 실패 화면
		JPanel panel = new JPanel(new GridLayout(2,1));
		JLabel label = new JLabel("해당 학번의 학생 정보가 존재하지 않습니다!");
		JButton btn = new JButton("확인");
		
		btn.addActionListener(e -> cardLayout.show(mainPanel, "검색"));
		
		panel.add(label);
		panel.add(btn);
		
		return panel;
	}

	private JPanel createSearchSuccess() {
		// 검색 성공 화면
		JPanel panel = new JPanel(new GridLayout(2,1));
		JLabel label = new JLabel("");
		JButton btn = new JButton("확인");
		
		btn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));
		
		panel.add(label);
		panel.add(btn);
		
		return panel;
	}
	
	private void printStudent(Student student) {
		// 검색 성공 시 학생 정보를 출력해주는 작업 -> 필드 화면에 데이터를 집어 넣을 것임
		JPanel panel = getSrsP();
		JLabel label = (JLabel)panel.getComponent(0);
		//System.out.println(panel.getComponentCount());
		label.setText("이름 : " + student.getStudentName() + " 학번 : " + student.getStudentId() + " 학과 : " + student.getMajor() + " 파이썬 : " + student.getPython() + " 자바 : " + student.getJava() + " DB : " + student.getDb());
	}

	private JPanel getSrsP() {
		return searchSuccessPanel;
	}
}
