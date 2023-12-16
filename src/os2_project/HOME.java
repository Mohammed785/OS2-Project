package os2_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.concurrent.Semaphore;

import javax.swing.SwingConstants;
import java.awt.Color;

public class HOME {

	private JFrame frame;
	private JTextField TAsCount;
	private JTextField ChairsCount;
	private JLabel lblChairs;
	private JTextField StudentsCount;
	private JLabel lblStudents;
	private JButton StartBtn;
	private JLabel lblNewLabel_2;
	private JTextField TA_W;
	private JTextField TA_S;
	private JTextField Student_W;
	private JLabel lblStudentsWaitingOn_1;
	private JTextField Students_L;
	
	private Semaphore ta_semaphore;
	private Semaphore chairs_semaphore;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME window = new HOME();
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
	public HOME() {
		this.ta_semaphore = null;
		this.chairs_semaphore = null;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 747, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TAsCount = new JTextField();
		TAsCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TAsCount.setToolTipText("Enter TAs count");
		TAsCount.setBounds(174, 101, 102, 39);
		frame.getContentPane().add(TAsCount);
		TAsCount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TAs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(28, 107, 118, 26);
		frame.getContentPane().add(lblNewLabel);
		
		ChairsCount = new JTextField();
		ChairsCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChairsCount.setToolTipText("Enter TAs count");
		ChairsCount.setColumns(10);
		ChairsCount.setBounds(174, 181, 102, 39);
		frame.getContentPane().add(ChairsCount);
		
		lblChairs = new JLabel("Chairs");
		lblChairs.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChairs.setBounds(28, 187, 118, 26);
		frame.getContentPane().add(lblChairs);
		
		StudentsCount = new JTextField();
		StudentsCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		StudentsCount.setToolTipText("Enter TAs count");
		StudentsCount.setColumns(10);
		StudentsCount.setBounds(174, 266, 102, 39);
		frame.getContentPane().add(StudentsCount);
		
		lblStudents = new JLabel("Students");
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStudents.setBounds(28, 272, 118, 26);
		frame.getContentPane().add(lblStudents);
		
		StartBtn = new JButton("Start");
		StartBtn.setBackground(new Color(0, 128, 128));
		StartBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		StartBtn.setBounds(64, 359, 167, 50);
		frame.getContentPane().add(StartBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Inputs");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(85, 28, 130, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator vertical_separator = new JSeparator(SwingConstants.VERTICAL);
		vertical_separator.setSize(2, 558);
		vertical_separator.setLocation(330, 0);
		vertical_separator.setForeground(Color.BLACK);
		vertical_separator.setBackground(Color.BLACK);
		frame.getContentPane().add(vertical_separator);
		
		lblNewLabel_2 = new JLabel("Outputs");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(465, 28, 130, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblTasWorking = new JLabel("TAs Working");
		lblTasWorking.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTasWorking.setBounds(371, 107, 155, 33);
		frame.getContentPane().add(lblTasWorking);
		
		TA_W = new JTextField();
		TA_W.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TA_W.setText("0");
		TA_W.setEditable(false);
		TA_W.setToolTipText("Enter TAs count");
		TA_W.setColumns(10);
		TA_W.setBounds(579, 101, 102, 39);
		frame.getContentPane().add(TA_W);
		
		TA_S = new JTextField();
		TA_S.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TA_S.setText("0");
		TA_S.setEditable(false);
		TA_S.setToolTipText("Enter TAs count");
		TA_S.setColumns(10);
		TA_S.setBounds(579, 181, 102, 39);
		frame.getContentPane().add(TA_S);
		
		JLabel lblTasSleeping = new JLabel("TAs Sleeping");
		lblTasSleeping.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTasSleeping.setBounds(371, 187, 155, 33);
		frame.getContentPane().add(lblTasSleeping);
		
		JLabel lblStudentsWaitingOn = new JLabel("<html>Students Waiting On Chairs</html>");
		lblStudentsWaitingOn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentsWaitingOn.setBounds(371, 248, 155, 66);
		frame.getContentPane().add(lblStudentsWaitingOn);
		
		Student_W = new JTextField();
		Student_W.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Student_W.setText("0");
		Student_W.setEditable(false);
		Student_W.setToolTipText("Enter TAs count");
		Student_W.setColumns(10);
		Student_W.setBounds(579, 266, 102, 39);
		frame.getContentPane().add(Student_W);
		
		lblStudentsWaitingOn_1 = new JLabel("<html>Students Thats Will Come Later</html>");
		lblStudentsWaitingOn_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentsWaitingOn_1.setBounds(371, 343, 155, 66);
		frame.getContentPane().add(lblStudentsWaitingOn_1);
		
		Students_L = new JTextField();
		Students_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Students_L.setText("0");
		Students_L.setEditable(false);
		Students_L.setToolTipText("Enter TAs count");
		Students_L.setColumns(10);
		Students_L.setBounds(579, 361, 102, 39);
		frame.getContentPane().add(Students_L);
		
		StartBtn.addActionListener(e->{
			try {		
				if(Integer.parseInt(Students_L.getText())>0) {
					JOptionPane.showMessageDialog(frame, "there is a Simulation already running.","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(TAsCount.getText().isBlank()||ChairsCount.getText().isBlank()) {
						JOptionPane.showMessageDialog(frame, "Please Make sure to enter ta,chairs and students count.", "Warning", JOptionPane.WARNING_MESSAGE);
						return;
				}
				int ta_count = Integer.parseInt(TAsCount.getText());
				int chairs_count = Integer.parseInt(ChairsCount.getText());
				int students_count = Integer.parseInt(StudentsCount.getText());
				ta_semaphore = new Semaphore(ta_count,true);
				chairs_semaphore = new Semaphore(chairs_count, true);
				Student students[] = new Student[students_count];
				Students_L.setText(Integer.toString(students_count));
				TA_S.setText(Integer.toString(ta_count));
				for(int i=0;i<students_count;i++) {
					students[i] = new Student(ta_semaphore,chairs_semaphore,TA_W,TA_S,Student_W,Students_L);
					new Thread(students[i]).start();
				}
			} catch (NumberFormatException  e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(frame, "Can't convert string to number","Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		
	}
}
