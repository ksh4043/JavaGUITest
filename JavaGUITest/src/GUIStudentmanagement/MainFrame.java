package GUIStudentmanagement;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;
// 화면 전환이 여러번 이루어지는 경우, 기능이 달라짐에 따라 메서드를 각각 정의하여 작성
public class MainFrame extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	
	public MainFrame() {
		// GUI 화면을 구현함
		setTitle("학생 성적 관리 프로그램");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
		JPanel menuPanel = createMenuPanel();
		JPanel inputPanel = createInputPanel();
		JPanel searchPanel = createSearchPanel();
		JPanel modifyPanel = createModifyPanel();
		JPanel removePanel = createRemovePanel();
		JPanel exitPanel = createExitPanel();
		
		mainPanel.add(menuPanel, "메뉴");
		//mainPanel.add(inputPanel, "입력");
		//mainPanel.add(searchPanel, "검색");
		//mainPanel.add(modifyPanel, "수정");
		//mainPanel.add(removePanel, "삭제");
		//mainPanel.add(exitPanel, "종료");
		
		add(mainPanel);
	}

	private JPanel createExitPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel createRemovePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel createModifyPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel createSearchPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new GridLayout(8, 2));
		JLabel nameLabel = new JLabel("이름 : ");
		JTextField nameField = new JTextField();
		JLabel majorLabel = new JLabel("학과 : ");
		JTextField majorField = new JTextField();
		JLabel sIdLabel = new JLabel("학번 : ");
		JTextField sIdField = new JTextField();
		JLabel pythonLabel = new JLabel("학번 : ");
		JTextField pythonField = new JTextField();
		JLabel javaLabel = new JLabel("학번 : ");
		JTextField javaField = new JTextField();
		JLabel dbLabel = new JLabel("학번 : ");
		JTextField dbField = new JTextField();
		JButton submitBtn = new JButton("입력 완료");
        JButton backBtn = new JButton("뒤로 가기");
        
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));
		
		return panel;
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

}
