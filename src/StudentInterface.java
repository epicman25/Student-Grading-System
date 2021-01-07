import java.awt.BorderLayout;


import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
public class StudentInterface extends JFrame {

	private JPanel contentPane;
	private JTextField StudentName;
	private JTextField StudentSection;
	private JTextField StudentRollNumber;
	private JTable table;
	private JScrollPane scrollPane;
	Connection DBConnection = null;
	private JLabel lblNewLabel_3;
	private JTextField ExamNameTxt;
	private JButton Reset;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInterface frame = new StudentInterface();
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
	public StudentInterface() {
		setTitle("Student Interface");
		DBConnection = DatabaseConnection.databaseconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252,218,183));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(51, 27, 93, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Section");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(51, 70, 93, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Exam");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(51, 146, 137, 53);
		contentPane.add(lblNewLabel_2);
		
		StudentName = new JTextField();
		StudentName.setBounds(198, 30, 144, 30);
		contentPane.add(StudentName);
		
		StudentSection = new JTextField();
		StudentSection.setBounds(198, 70, 144, 30);
		contentPane.add(StudentSection);
		StudentSection.setColumns(10);
		
		StudentRollNumber = new JTextField();
		StudentRollNumber.setBounds(198, 111, 144, 30);
		contentPane.add(StudentRollNumber);
		StudentRollNumber.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 276, 731, 52);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton FindDrade = new JButton("Load Marks");
		FindDrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from StudentDetails where	Name=? and  Section=? and RollNumber = ? and ExamName = ?";
					
					PreparedStatement pst = DBConnection.prepareStatement(query);
					pst.setString(1, StudentName.getText());
					pst.setString(2,StudentSection.getText());
					pst.setString(3, StudentRollNumber.getText());
					pst.setString(4, ExamNameTxt.getText());
					ResultSet res = pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(res));
					pst.close();
					
					
					
					
					
					pst.close();
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, f);
				}
			}
		});
		
		
		
		FindDrade.setFont(new Font("Dialog", Font.BOLD, 18));
		FindDrade.setBounds(150, 212, 172, 53);
		contentPane.add(FindDrade);
		
		lblNewLabel_3 = new JLabel("Roll Number");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(51, 105, 137, 53);
		contentPane.add(lblNewLabel_3);
		
		ExamNameTxt = new JTextField();
		ExamNameTxt.setColumns(10);
		ExamNameTxt.setBounds(198, 159, 144, 30);
		contentPane.add(ExamNameTxt);
		
		Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInterface frame = new StudentInterface();
				frame.setVisible(true);
				dispose();
			}
		});
		Reset.setFont(new Font("Dialog", Font.BOLD, 18));
		Reset.setBounds(420, 212, 172, 53);
		contentPane.add(Reset);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInterface frame = new StudentInterface();
				frame.setVisible(false);
				dispose();
				StudentOrTeacher.main(null);
				
			}
		});
		back.setBounds(633, 331, 89, 23);
		contentPane.add(back);
	}
}
