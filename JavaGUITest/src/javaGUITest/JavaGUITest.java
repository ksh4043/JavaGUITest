package javaGUITest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JFrame에 상속시켜 setTitle(), setSize() 메서드를 직접 호출
public class JavaGUITest extends JFrame {
	private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // JavaGUITest() 생성자
    public JavaGUITest() {
        setTitle("학생 성적 관리 프로그램");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기 버튼을 누르면 동작 정지하도록 설정
        setLocationRelativeTo(null);	// 화면을 중앙에 배치

        cardLayout = new CardLayout();	// 화면 전환을 위한 cardLayout 객체 생성
        mainPanel = new JPanel(cardLayout);	// 실제로 화면 전환이 이루어질 진짜 화면 객체

        // 화면 추가
        JPanel menuPanel = createMenuPanel();
        JPanel inputPanel = createInputPanel();

        mainPanel.add(menuPanel, "메뉴");	// cardLayout은 배열이나 리스트와 비슷한 개념이기 때문에 먼저 들어간 menuPanel이 초기화면(0번 index)으로 잡힘
        mainPanel.add(inputPanel, "입력");

        add(mainPanel);	// frame(화면)에 생성한 mainPanel을 추가하여 보여줌
    }

    // JPanel 타입의 createMenuPanel() 생성자 메서드
    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton inputBtn = new JButton("학생 정보 입력");
        JButton exitBtn = new JButton("종료");

        inputBtn.addActionListener(e -> cardLayout.show(mainPanel, "입력"));
        exitBtn.addActionListener(e -> System.exit(0));	// 종료 버튼 클릭 시, 프로그램 종료

        panel.add(inputBtn);
        panel.add(exitBtn);

        return panel;	// return 하는 데이터도 JPanel 타입
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));	// 열이 4개, 행이 2개인 화면으로 생성한다는 뜻, GirdLayout() 메서ㄷ로 생성 시, 추가하는 화면이 순차적으로 자리 잡음
        JLabel nameLabel = new JLabel("이름:");
        JTextField nameField = new JTextField();
        JLabel scoreLabel = new JLabel("점수:");
        JTextField scoreField = new JTextField();
        JButton submitBtn = new JButton("입력 완료");
        JButton backBtn = new JButton("뒤로 가기");

        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "메뉴"));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(scoreLabel);
        panel.add(scoreField);
        panel.add(submitBtn);
        panel.add(backBtn);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	JavaGUITest frame = new JavaGUITest();
            frame.setVisible(true);
        });
    }
}
