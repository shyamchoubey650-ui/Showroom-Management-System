package Empolyes;

//USE showroom_db;

//SELECT * FROM employees;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;

public class EmpolyesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemp_id;
	private JTextField txtemp_name;
	private JTextField txtemp_age;
	private JTextField txtemp_department;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpolyesFrame frame = new EmpolyesFrame();
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
	public EmpolyesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("emp_id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(70, 38, 141, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("emp_name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(70, 86, 141, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("emp_age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(70, 134, 141, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("emp_department");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(70, 182, 141, 22);
		contentPane.add(lblNewLabel_3);
		
		txtemp_id = new JTextField();
		txtemp_id.setBackground(new Color(0, 255, 255));
		txtemp_id.setBounds(281, 38, 141, 22);
		contentPane.add(txtemp_id);
		txtemp_id.setColumns(10);
		
		txtemp_name = new JTextField();
		txtemp_name.setBackground(new Color(0, 255, 255));
		txtemp_name.setColumns(10);
		txtemp_name.setBounds(281, 88, 141, 22);
		contentPane.add(txtemp_name);
		
		txtemp_age = new JTextField();
		txtemp_age.setBackground(new Color(0, 255, 255));
		txtemp_age.setBounds(281, 134, 141, 22);
		contentPane.add(txtemp_age);
		txtemp_age.setColumns(10);
		
		txtemp_department = new JTextField();
		txtemp_department.setBackground(new Color(0, 255, 255));
		txtemp_department.setColumns(10);
		txtemp_department.setBounds(281, 184, 141, 22);
		contentPane.add(txtemp_department);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(70, 240, 141, 28);
		btnInsert.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/showroom_db",
		                "root",
		                "Shyam@737"
		            );

		            System.out.println("Connection Successfully created!!");

		            String emp_id = txtemp_id.getText();
		            String emp_name = txtemp_name.getText();
		            int emp_age = Integer.parseInt(txtemp_age.getText());
		            String emp_department = txtemp_department.getText();

		            String query = "INSERT INTO employees (emp_id, emp_name, emp_age, emp_department) VALUES (?, ?, ?, ?)";

		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, emp_id);
		            ps.setString(2, emp_name);
		            ps.setInt(3, emp_age);
		            ps.setString(4, emp_department);

		            int result = ps.executeUpdate();
		            JOptionPane.showMessageDialog(null, result + " Record Inserted Successfully!");

		            ps.close();
		            con.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		contentPane.add(btnInsert);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtemp_id.setText("");
				txtemp_name .setText("");
				txtemp_department .setText("");
				txtemp_age.setText("");
			}
		
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(281, 240, 141, 28);
		contentPane.add(btnReset);

	}

}
