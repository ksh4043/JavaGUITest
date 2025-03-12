package GUIStudentmanagement;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GUIStudentManagementApp {
	
	public static void main(String[] args) {
		// GUI 생성자 호출 및 실행으로 화면 생성
		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
	}
}
