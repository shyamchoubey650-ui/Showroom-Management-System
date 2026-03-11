package shyam;

// USE showroom_db;

// SELECT * FROM showroom;

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

public class javaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtshowroom_name;
	private JTextField txtshowroom_address;
	private JTextField txttotal_employees;
	private JTextField txttotal_cars_in_stock;
	private JTextField txtmanager_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javaFrame frame = new javaFrame();
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
	public javaFrame() {
		getContentPane().setBackground(new Color(128, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 390);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("showroom_name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 29, 154, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("showroom_address");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(60, 80, 154, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("total_employees");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(60, 138, 154, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("total_cars_in_stock");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(60, 194, 154, 30);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("manager_name");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(60, 247, 154, 30);
		getContentPane().add(lblNewLabel_4);
		
		txtshowroom_name = new JTextField();
		txtshowroom_name.setBackground(new Color(128, 255, 255));
		txtshowroom_name.setBounds(270, 30, 186, 30);
		getContentPane().add(txtshowroom_name);
		txtshowroom_name.setColumns(10);
		
		txtshowroom_address = new JTextField();
		txtshowroom_address.setBackground(new Color(128, 255, 255));
		txtshowroom_address.setBounds(270, 80, 186, 30);
		getContentPane().add(txtshowroom_address);
		txtshowroom_address.setColumns(10);
		
		txttotal_employees = new JTextField();
		txttotal_employees.setBackground(new Color(128, 255, 255));
		txttotal_employees.setBounds(270, 138, 186, 30);
		getContentPane().add(txttotal_employees);
		txttotal_employees.setColumns(10);
		
		txttotal_cars_in_stock = new JTextField();
		txttotal_cars_in_stock.setBackground(new Color(128, 255, 255));
		txttotal_cars_in_stock.setBounds(270, 194, 186, 30);
		getContentPane().add(txttotal_cars_in_stock);
		txttotal_cars_in_stock.setColumns(10);
		
		txtmanager_name = new JTextField();
		txtmanager_name.setBackground(new Color(128, 255, 255));
		txtmanager_name.setBounds(270, 247, 186, 30);
		getContentPane().add(txtmanager_name);
		txtmanager_name.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setForeground(new Color(0, 0, 0));
		btnInsert.setBackground(new Color(255, 255, 255));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(60, 299, 168, 30);
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

		            String showroom_name = txtshowroom_name.getText();
		            String showroom_address = txtshowroom_address.getText();
		            String manager_name = txtmanager_name.getText();
		            int total_employees = Integer.parseInt(txttotal_employees.getText());
		            int total_cars_in_stock = Integer.parseInt(txttotal_cars_in_stock.getText());

		            // ✅ FIXED QUERY
		            String query = "INSERT INTO showroom (showroom_name, showroom_address, manager_name, total_employees, total_cars_in_stock) VALUES (?, ?, ?, ?, ?)";

		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, showroom_name);
		            ps.setString(2, showroom_address);
		            ps.setString(3, manager_name);
		            ps.setInt(4, total_employees);
		            ps.setInt(5, total_cars_in_stock);

		            int result = ps.executeUpdate();
		            JOptionPane.showMessageDialog(null, result + " Record Inserted Successfully!");
		            ps.close();
		            con.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		getContentPane().add(btnInsert);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtshowroom_name.setText("");
				txtshowroom_address.setText("");
				txttotal_employees.setText("");
				txttotal_cars_in_stock.setText("");
				txtmanager_name.setText("");
			}
		
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(270, 299, 186, 30);
		getContentPane().add(btnReset);

	}
}
