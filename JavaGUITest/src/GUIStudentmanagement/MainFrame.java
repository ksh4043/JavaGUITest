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
		// TODO Auto-generated method stub
		return null;
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
		
		
		panel.add(inputBtn);
		panel.add(searchBtn);
		panel.add(modifyBtn);
		panel.add(removeBtn);
		panel.add(exitBtn);
		
		return panel;
	}

}
