import java.awt.BorderLayout;

import javax.swing.*;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TeacherLogin extends JFrame {

	private JPanel contentPane;
	private JTextField TeacherUsername;
	private JPasswordField TeacherPassword;
	Connection DBConnection = null;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
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
	public TeacherLogin() {
		setTitle("Login");
		DBConnection = DatabaseConnection.databaseconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252,218,183));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 60, 95, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 122, 95, 45);
		contentPane.add(lblNewLabel_1);
		
		TeacherUsername = new JTextField();
		TeacherUsername.setBounds(148, 63, 183, 35);
		contentPane.add(TeacherUsername);
		TeacherUsername.setColumns(10);
		
		TeacherPassword = new JPasswordField();
		TeacherPassword.setBackground(new Color(255, 255, 255));
		TeacherPassword.setBounds(148, 128, 183, 37);
		contentPane.add(TeacherPassword);
		
		JButton TeacherLoginButton = new JButton("Login");
		TeacherLoginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		TeacherLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String querycell = "select * from TeacherLoginDetails where Username = ? and Password = ?";
					PreparedStatement pst=DBConnection.prepareStatement(querycell) ;
					pst.setString(1, TeacherUsername.getText());
					pst.setString(2, TeacherPassword.getText());
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						
					count+=1;	
					}
					if(count == 1) {
						TeacherLogin frame = new TeacherLogin();
						frame.setVisible(false);
						dispose();
						TeacherInterface frame4 = new TeacherInterface();
						frame4.setVisible(true);
					}
					else if(count == 0) {
						JOptionPane.showMessageDialog(null, "Login Details wrong");
					}
					rs.close();
					pst.close();
					
				}catch(Exception l) {
					JOptionPane.showMessageDialog(null, l);
				}
			}
		});
		TeacherLoginButton.setBounds(66, 190, 122, 45);
		contentPane.add(TeacherLoginButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin frame3 = new TeacherLogin();
				frame3.setVisible(false);
				dispose();
				StudentOrTeacher.main(null);
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(251, 190, 122, 45);
		contentPane.add(btnBack);
	}

}
