package GUIStudentmanagement;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JPanel removePanel = createRemoePanel();
		JPanel exitPanel = createExitPanel();
	}

	private JPanel createExitPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel createRemoePanel() {
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
		// TODO Auto-generated method stub
		return null;
	}

}
