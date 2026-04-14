package how;

//USE showroom_db;

//SELECT * FROM car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class CarFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcar_name;
	private JTextField txtcar_color;
	private JTextField txtcar_fuel_type;
	private JTextField txtcar_price;
	private JTextField txtcar_type;
	private JTextField txtcar_transmission;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarFrame frame = new CarFrame();
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
	public CarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("car_name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(56, 28, 92, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("car_color");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(56, 71, 92, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("car_fuel_type");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(56, 115, 111, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("car_price");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(56, 158, 92, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("car_type");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(56, 198, 92, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("car_transmission");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(56, 233, 148, 27);
		contentPane.add(lblNewLabel_5);
		
		txtcar_name = new JTextField();
		txtcar_name.setBackground(new Color(128, 255, 255));
		txtcar_name.setBounds(267, 29, 148, 27);
		contentPane.add(txtcar_name);
		txtcar_name.setColumns(10);
		
		txtcar_color = new JTextField();
		txtcar_color.setBackground(new Color(128, 255, 255));
		txtcar_color.setColumns(10);
		txtcar_color.setBounds(267, 71, 148, 27);
		contentPane.add(txtcar_color);
		
		txtcar_fuel_type = new JTextField();
		txtcar_fuel_type.setBackground(new Color(128, 255, 255));
		txtcar_fuel_type.setColumns(10);
		txtcar_fuel_type.setBounds(267, 115, 148, 33);
		contentPane.add(txtcar_fuel_type);
		
		txtcar_price = new JTextField();
		txtcar_price.setBackground(new Color(128, 255, 255));
		txtcar_price.setColumns(10);
		txtcar_price.setBounds(267, 159, 148, 27);
		contentPane.add(txtcar_price);
		
		txtcar_type = new JTextField();
		txtcar_type.setBackground(new Color(128, 255, 255));
		txtcar_type.setColumns(10);
		txtcar_type.setBounds(267, 198, 148, 27);
		contentPane.add(txtcar_type);
		
		txtcar_transmission = new JTextField();
		txtcar_transmission.setBackground(new Color(128, 255, 255));
		txtcar_transmission.setColumns(10);
		txtcar_transmission.setBounds(267, 233, 148, 27);
		contentPane.add(txtcar_transmission);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setForeground(new Color(0, 0, 0));
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

		            String car_name = txtcar_name.getText();
		            String car_color = txtcar_color.getText();
		            String car_fuel_type = txtcar_fuel_type.getText();
		            int car_price = Integer.parseInt(txtcar_price.getText());
		            String car_type = txtcar_type.getText();
		            String car_transmission = txtcar_transmission.getText();

		            String query = "INSERT INTO car (car_name, car_color, car_fuel_type, car_price, car_type, car_transmission) VALUES (?, ?, ?, ?, ?, ?)";

		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, car_name);
		            ps.setString(2, car_color);
		            ps.setString(3, car_fuel_type);
		            ps.setInt(4, car_price);
		            ps.setString(5, car_type);
		            ps.setString(6, car_transmission);

		            int result = ps.executeUpdate();
		            JOptionPane.showMessageDialog(null, result + " Record Inserted Successfully!");

		            ps.close();
		            con.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		btnInsert.setBounds(56, 286, 148, 33);
		contentPane.add(btnInsert);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcar_name.setText("");
				txtcar_color .setText("");
				txtcar_fuel_type .setText("");
				txtcar_price.setText("");
				txtcar_type.setText("");
				txtcar_transmission.setText("");
			}
		
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(267, 286, 148, 33);
		contentPane.add(btnReset);

	}
}
