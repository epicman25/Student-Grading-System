import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TeacherInterface extends JFrame {

	private JPanel contentPane;
	private JTextField StudentNameT;
	private JTextField StudentSectionT;
	private JTextField StudentRollNumberT;
	private JTextField Mathematics;
	private JTextField Physics;
	private JTextField Chemistry;
	private JTextField Biology;
	private JTextField BasicElectronics;
	private JTextField English;
	private JTable table;
	Connection DBConnection = null;
	private JTextField ExamNametxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInterface frame = new TeacherInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherInterface() {
		setTitle("Teacher Interface");
		DBConnection = DatabaseConnection.databaseconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252,218,183));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Marks Entry Portal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 11, 799, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(48, 64, 58, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Section");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(48, 139, 58, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll Number");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(50, 230, 124, 31);
		contentPane.add(lblNewLabel_3);
		
		StudentNameT = new JTextField();
		StudentNameT.setBounds(142, 76, 134, 31);
		contentPane.add(StudentNameT);
		StudentNameT.setColumns(10);
		
		StudentSectionT = new JTextField();
		StudentSectionT.setBounds(142, 132, 134, 31);
		contentPane.add(StudentSectionT);
		StudentSectionT.setColumns(10);
		
		StudentRollNumberT = new JTextField();
		StudentRollNumberT.setBounds(142, 231, 134, 31);
		contentPane.add(StudentRollNumberT);
		StudentRollNumberT.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mathematics");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(327, 104, 107, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Physics");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(327, 158, 88, 20);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Chemistry");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(327, 210, 79, 28);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Basic Electronics");
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(539, 153, 134, 31);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("English");
		lblNewLabel_4_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_4.setBounds(539, 210, 88, 28);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Biology");
		lblNewLabel_4_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_5.setBounds(539, 105, 60, 31);
		contentPane.add(lblNewLabel_4_5);
		
		Mathematics = new JTextField();
		Mathematics.setBounds(419, 106, 86, 31);
		contentPane.add(Mathematics);
		Mathematics.setColumns(10);
		
		Physics = new JTextField();
		Physics.setText("");
		Physics.setBounds(419, 154, 86, 30);
		contentPane.add(Physics);
		Physics.setColumns(10);
		
		Chemistry = new JTextField();
		Chemistry.setBounds(419, 208, 86, 30);
		contentPane.add(Chemistry);
		Chemistry.setColumns(10);
		
		Biology = new JTextField();
		Biology.setBounds(664, 106, 86, 30);
		contentPane.add(Biology);
		Biology.setColumns(10);
		
		BasicElectronics = new JTextField();
		BasicElectronics.setBounds(664, 154, 86, 30);
		contentPane.add(BasicElectronics);
		BasicElectronics.setColumns(10);
		
		English = new JTextField();
		English.setBounds(664, 210, 86, 30);
		contentPane.add(English);
		English.setColumns(10);
		
		JButton UploadBtn = new JButton("Upload");
		UploadBtn.setBackground(UIManager.getColor("Button.highlight"));
		UploadBtn.setFont(new Font("Arial", Font.BOLD, 18));
		UploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String uploadquery = "INSERT INTO StudentDetails(Name,Section,RollNumber,Mathematics,Physics,Chemistry,Biology,BasicElectronics,English,FinalGrade,ExamName) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement uploadpst = DBConnection.prepareStatement(uploadquery);
					uploadpst.setString(1, StudentNameT.getText());
					uploadpst.setString(2, StudentSectionT.getText());
					uploadpst.setString(3, StudentRollNumberT.getText());
					uploadpst.setString(4, Mathematics.getText());
					uploadpst.setString(5, Physics.getText());
					uploadpst.setString(6, Chemistry.getText());
					uploadpst.setString(7, Biology.getText());
					uploadpst.setString(8, BasicElectronics.getText());
					uploadpst.setString(9, English.getText());
					uploadpst.setString(11, ExamNametxt.getText());
					int s1,s2,s3,s4,s5,s6,grade;
					s1 = Integer.parseInt(Mathematics.getText());
					s2 = Integer.parseInt(Physics.getText());
					s3 = Integer.parseInt(Chemistry.getText());
					s4 = Integer.parseInt(Biology.getText());
					s5 = Integer.parseInt(BasicElectronics.getText());
					s6 = Integer.parseInt(English.getText());
					grade = (s1+s2+s3+s4+s5+s6)/6;
					
					if(grade>=92 && grade<=100) {
						uploadpst.setString(10, "A+");
					}
					else if(grade>=82) {
						uploadpst.setString(10, "A");
					}
					else if(grade>=72) {
						uploadpst.setString(10, "B+");
					}
					else if(grade>=62) {
						uploadpst.setString(10, "B");
					}
					else if(grade>=52) {
						uploadpst.setString(10, "C+");
					}
					else if(grade>=42) {
						uploadpst.setString(10, "C");
					}
					else if(grade>=35) {
						uploadpst.setString(10, "D+");
					}
					else if(grade<35) {
						uploadpst.setString(10, "F");
					}
					
					uploadpst.executeUpdate();
					
						String query = "select * from StudentDetails where	Name=? and  Section=? and RollNumber = ?";
						PreparedStatement displaypst = DBConnection.prepareStatement(query);
						displaypst.setString(1, StudentNameT.getText());
						displaypst.setString(2,StudentSectionT.getText());
						displaypst.setString(3, StudentRollNumberT.getText());
						ResultSet result = displaypst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(result));
					
					result.close();
					uploadpst.close();
					
					}catch(Exception i)
				{
					JOptionPane.showMessageDialog(null, i);
				}
			}
		});
		UploadBtn.setBounds(210, 290, 107, 54);
		contentPane.add(UploadBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 355, 749, 53);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel ExamName = new JLabel("Exam Name");
		ExamName.setFont(new Font("Arial", Font.BOLD, 15));
		ExamName.setBounds(48, 183, 86, 23);
		contentPane.add(ExamName);
		
		ExamNametxt = new JTextField();
		ExamNametxt.setBounds(142, 184, 134, 31);
		contentPane.add(ExamNametxt);
		ExamNametxt.setColumns(10);
		
		JButton Resetbtn = new JButton("Reset");
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherInterface frame = new TeacherInterface();
				frame.setVisible(true);
				dispose();
			}
		});
		Resetbtn.setFont(new Font("Arial", Font.BOLD, 18));
		Resetbtn.setBounds(492, 292, 107, 54);
		contentPane.add(Resetbtn);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin frame = new TeacherLogin();
				frame.setVisible(true);
				dispose();
				
				}
			
		});
		btnNewButton.setBounds(661, 413, 89, 23);
		contentPane.add(btnNewButton);
	}
}
