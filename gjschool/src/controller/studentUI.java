package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.studentDao;
import dao.impl.studentDaoImpl;
import model.student;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
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
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 10, 285, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 71, 417, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 88, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 58, 88, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 108, 88, 22);
		panel.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setBounds(108, 11, 119, 21);
		panel.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setColumns(10);
		chi.setBounds(108, 59, 119, 21);
		panel.add(chi);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(108, 109, 119, 21);
		panel.add(eng);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 232, 417, 176);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 397, 120);
		panel_1.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(10, 10, 417, 46);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=name.getText();
				int CHI=Integer.parseInt(chi.getText());
				int ENG=Integer.parseInt(eng.getText());
				
				student s=new student(Name,CHI,ENG);
				
				new studentDaoImpl().add(s);
				
				name.setText("");
				chi.setText("");
				eng.setText("");
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnNewButton.setBounds(237, 10, 170, 120);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢(String)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				output.setText(new studentDaoImpl().querysAll());
			}
		});
		btnNewButton_1.setBounds(21, 10, 141, 26);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查詢(List)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*	1.提取List
				 * 	2.排列
				 * 	3.output
				 */
				int i=0;
				int sum=0;
				String show="";
				List<student> l=new studentDaoImpl().queryAll2();
				for(student o:l)
				{
					i++;
					sum=sum+o.getChi()+o.getEng();
					show=show+"名="+o.getName()+
							"\t國文="+o.getChi()+
							"\t英文="+o.getEng()+
							"\t總分="+(o.getChi()+o.getEng())+"\n";
					
										
				}
				output.setText(show+"總分平均="+sum/i);
				
			}
		});
		btnNewButton_2.setBounds(252, 10, 141, 26);
		panel_1.add(btnNewButton_2);
	}
}
