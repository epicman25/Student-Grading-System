import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class StudentOrTeacher {

	private JFrame frame = new JFrame("Student grading system");;
	public void createWindow() {
	    
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentOrTeacher window = new StudentOrTeacher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentOrTeacher() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student grading system");
		
		frame.getContentPane().setBackground(new Color(252,218,183));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(100, 100, 572, 353);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to the student grading portal.");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(137, 92, 274, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton StudentLogin = new JButton("Student");
		StudentLogin.setFocusable(false);
		StudentLogin.setBackground(UIManager.getColor("Button.background"));
		StudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StudentInterface frame2 = new StudentInterface();
				frame2.setVisible(true);
			}
		});
		StudentLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		StudentLogin.setBounds(124, 216, 114, 59);
		frame.getContentPane().add(StudentLogin);
		
		JButton TeacherLogin = new JButton("Teacher");
		TeacherLogin.setBackground(UIManager.getColor("Button.background"));
		TeacherLogin.setFocusable(false);
		TeacherLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		TeacherLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TeacherLogin frame3 = new TeacherLogin();
				frame3.setVisible(true);
			}
		});
		TeacherLogin.setBounds(297, 216, 114, 59);
		frame.getContentPane().add(TeacherLogin);
		
		JLabel lblNewLabel_2 = new JLabel("STUDENT GRADING SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 33));
		lblNewLabel_2.setBounds(10, 11, 536, 59);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT GRADING SYSTEM");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 36));
		lblNewLabel_1.setBounds(34, 11, 481, 70);
				
	}
}
