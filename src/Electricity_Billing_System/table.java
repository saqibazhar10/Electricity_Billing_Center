package Electricity_Billing_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.email.durgesh.Email;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollBar;
public class table extends JFrame {
	public table() {
		setTitle("Electricity Billing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,662,453);
		table_1 = new JTable();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10,44,626,359);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 10, 89, 23);
		contentPane.add(btnNewButton);
		
	}

	private JPanel contentPane;
	private JTable table;
	static public String Amount;
	static public int Date;
	static public String DD;
	static public String W3;
	static public String a,b,c,d,e;
	private JTable table_1;
	public static boolean q,bo;

	/**
	 * Launch the application.
	 */
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table frame = new table();
					frame.createTable();
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


		
	public void createTable() throws Exception{
		try {
		Connection con = getConnection();
		PreparedStatement cons = con.prepareStatement("CREATE TABLE IF NOT EXISTS Cons(ConsN varchar(255) UNIQUE, Id int(11) NOT NULL UNIQUE Auto_Increment,	MeterN varchar(255) UNIQUE, PhoneN varchar(255) UNIQUE ,Email varchar(255), Address varchar(255),PRIMARY KEY(id)) ");
		cons.executeUpdate();
		
		PreparedStatement bill = con.prepareStatement("CREATE TABLE IF NOT EXISTS BillRec(Cons_ID varchar(255) NOT NULL , Month varchar(255) NOT NULL ,Units varchar(255) NOT NULL ,Due_Date varchar(255) NOT NULL, Receivable_WDD varchar(255),Receivable_ADD varchar(255),Paid varchar(255)) ");
		bill.executeUpdate();
		
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Successfully");
		}
	}
	public  void post() throws Exception{
		ArrayList<AddConsu> list = AddConsu.getlist();
		AddConsu tab = new AddConsu();
		tab = list.get(list.size()-1);
		String ConsN = tab.ConsN;
		//String Id = String.valueOf(tab.ConsI) ;
        String MeterN = String.valueOf(tab.MeterN) ;
        String PhoneN = String.valueOf(tab.PhoneN) ;
        String Email = tab.Email;
        String Address = tab.Address;
		try{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO Cons (ConsN,MeterN,PhoneN,Email,Address) VALUES('"+ConsN+"','"+MeterN+"','"+PhoneN+"','"+Email+"','"+Address+"')");
			posted.executeUpdate();
			JOptionPane.showMessageDialog(contentPane,"You have Successfully created a new Consumer :   "+ ConsN );
			try {
				Email email = new Email("uetupdates@gmail.com","Umar617796");
				email.setFrom("uetupdates@gmail.com", "Electricity Billing System");
				email.setSubject("Consumer Added Successfully !");
				email.setContent("<h2>Welcome to Electricity and Billing System</h2> <br>" +
				"<br>Consumer Name : "+ConsN+
				"<br>Meter No      :    "+MeterN+
				"<br>Phone No      : "+ PhoneN+
				"<br>Address       :"+ Address+
				"<br><hr><br><a href=https://iesco.com.pk/downloads/Consumer%20Service%20Manual-2010.pdf><h3>Click Here for Further Instructions </h3></a>","text/html" );
				email.addRecipient(Email);
				email.send();
				}
				catch(Exception p) {
					JOptionPane.showMessageDialog(contentPane,p);
				}

		}catch(Exception SQLIntegrityConstraintViolationException) {
			JOptionPane.showMessageDialog(contentPane,"Duplicate values entered!!");
			}
			
		}
	public  void BillData() throws Exception{
		Generate_Bill a = new Generate_Bill();
		String Cons_Id =String.valueOf(a.getId());
		String Receivable_WDD=String.valueOf(a.getReceivable_WDD());
		String Receivable_ADD=String.valueOf(a.getReceivable_ADD());
		String Due_Date=String.valueOf(a.getDueDate());
		Date=Integer.parseInt(Due_Date) ;

		String Units=String.valueOf(a.getUnits());
		String Month = a.getcomboBox(); 
		String Paid = "0";
		
		Connection co = getConnection();
	    Statement mystmt = co.createStatement();
	    String SQL = "SELECT *FROM Cons WHERE Id ='" +Cons_Id+"'" ;
	    ResultSet rs =mystmt.executeQuery(SQL);
		 if(rs.next()) {
		 	 Statement statement = co.createStatement();
			 String month = "SELECT *FROM billrec WHERE Month ='" +Month+"'" ;
			 ResultSet R =statement.executeQuery(month);
		 	 Statement Statement = co.createStatement();
			 String ConsI = "SELECT *FROM billrec WHERE Cons_Id ='" +Cons_Id+"'" ;
			 ResultSet Result =Statement.executeQuery(ConsI);
		 	if (Result.next()) {
		 		if(R.next() && Result.next()) {
		 			JOptionPane.showMessageDialog(contentPane, "SAME MONTH");
		 		}
		 		
		 		else {
			 		 try{
							Connection con = getConnection();
							PreparedStatement posted = con.prepareStatement("INSERT INTO billrec(Cons_Id,Month,Units,Due_Date,Receivable_WDD,Receivable_ADD,Paid) VALUES('"+Cons_Id+"','"+Month+"','"+Units+"','"+Due_Date+"','"+Receivable_WDD+"','"+Receivable_ADD+"','"+Paid+"')");

							posted.executeUpdate();
						}catch(Exception e) {
							System.out.println(e);}
						finally {
							System.out.println("Inserted Values of");
			 	}
		 			
		 		}
		 	}

		 	
		 	else {
		 		 try{
						Connection con = getConnection();
						PreparedStatement posted = con.prepareStatement("INSERT INTO billrec(Cons_Id,Month,Units,Due_Date,Receivable_WDD,Receivable_ADD,Paid) VALUES('"+Cons_Id+"','"+Month+"','"+Units+"','"+Due_Date+"','"+Receivable_WDD+"','"+Receivable_ADD+"','"+Paid+"')");

						posted.executeUpdate();
					}catch(Exception e) {
						System.out.println(e);}
					finally {
						System.out.println("Inserted Values of");
		 	}
		 }}
		else {
				 JOptionPane.showMessageDialog(contentPane, "NO DATA IN CONSID");
			 }

		}	
	
	public void ShowRecord() {
		/*try {
		Connection con = getConnection();
		DefaultTableModel  model = new DefaultTableModel();
		model.addColumn("ConsN");
		model.addColumn("Id");
		model.addColumn("MeterN");
		model.addColumn("PhoneN");
		model.addColumn("Email");
		model.addColumn("Address");
		
		String query ="select * from cons";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			model.addRow(new Object[] {
					rs.getString("ConsN"),
					rs.getString("Id"),
					rs.getString("MeterN"),
					rs.getString("PhoneN"),
					rs.getString("Email"),
					rs.getString("Address"),
				
					
			});
		}
		rs.close();
		st.close();
		con.close();
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(202);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		
	
		
		
		
		}
		catch(Exception e) {
			System.out.println("Not Done");
		}*/
		
	}
	public  void PayAmout() throws Exception{
		PayBill amount = new PayBill();
		Connection co = getConnection();
	    Statement mystmt = co.createStatement();
	    Statement mstmt = co.createStatement();
	    Statement mtmt = co.createStatement();
	    String  Paid = amount.getAmount();
	    String  Month = amount.getcomboBox();
	    String Cons_ID = String.valueOf(amount.getid());
	    String P = "SELECT Paid FROM billrec where Cons_ID ='" +Cons_ID+"' && Month ='" +Month+"'"  ;
	    ResultSet da = mtmt.executeQuery(P);
	    while(da.next()) {
	    	W3 = da.getString(1);
	    }
	    int W= Integer.parseInt(W3);
	    if (W!=0) {
	    	JOptionPane.showMessageDialog(contentPane,"Bill is Already Paid ");
	    
	    }
	    else {
	    	String userecord ="use record";
	 	    String set = "SET SQL_SAFE_UPDATES = 0";
	 	    String update="UPDATE billrec SET Paid ='" +Paid+"'  Where Cons_ID ='" +Cons_ID+"' AND Month ='"+Month+"'";
		    mystmt.executeUpdate(userecord);
		    mystmt.executeUpdate(set);
		    mystmt.executeUpdate(update);
		    System.out.println("Update Complete");
		    JOptionPane.showMessageDialog(contentPane, "Bill payed Successfully");
	    }


	

		}	
	public void Edit() {
		try {
		Connection co = getConnection();
	    Statement mystmt = co.createStatement();
		Adm A = new Adm();
		Edit E = new Edit();
		String Id = A.getId();
		a= E.getName();
		c= E.getPN();
		b= E.getMN();
		d= E.getEmail();
		e = E.getAddress(); 
		String update="UPDATE cons SET ConsN ='" +a+"'  Where Id ='"+Id+"'";   
		String updat="UPDATE cons SET MeterN ='" +b+"'  Where Id ='"+Id+"'"; 
		String upda="UPDATE cons SET PhoneN ='" +c+"'  Where Id ='"+Id+"'"; 
		String upd="UPDATE cons SET Email ='" +d+"'  Where Id ='"+Id+"'"; 
		String up="UPDATE cons SET Address ='" +e+"'  Where Id ='"+Id+"'"; 
		
		
		
		mystmt.executeUpdate(update);
		mystmt.executeUpdate(updat);
		mystmt.executeUpdate(upda);
		mystmt.executeUpdate(upd);
		mystmt.executeUpdate(up);
		JOptionPane.showMessageDialog(contentPane,"Consumer Edited Successfully!!");
		dispose();
		
		
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void search() {
		try {
			Connection co = getConnection();
		    Statement mystmt = co.createStatement();
			Adm E = new Adm();
			String Id = E.getId();
		    String P = "SELECT * FROM cons where Id ='" +Id+"'"  ;
		    ResultSet Result =mystmt.executeQuery(P);
		    if(Result.next()) {
				Edit ed = new Edit();
				ed.setVisible(true);
				bo=true;
		    }
		    else {
		    	JOptionPane.showMessageDialog(contentPane,"No such Consumer Exists!! ");
		    }
		    
		    
		    
		}
		catch(Exception r) {
			
		}
		
	}
	
	public void searchName() {

		Adm a = new Adm();
		String Name = a.getName();
		try {
		Connection co = getConnection();
		Statement mystmt = co.createStatement();
		String query = "SELECT * FROM cons where ConsN ='"+Name+"'";
		PreparedStatement posted = co.prepareStatement(query);
		ResultSet  rs = posted.executeQuery();
		ResultSet  r = mystmt.executeQuery(query);
		if(r.next()) {
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		q=true;
		}
		else {
			 JOptionPane.showMessageDialog(contentPane,"No such Consumer!! ");
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	public void 	Bill_Details() {

		try {
		PayBill id = new PayBill();
		String Cons_Id =String.valueOf(id.getid());
		String Month = String.valueOf(id.getcomboBox());
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int Current_Date = calendar.get(Calendar.DAY_OF_MONTH);
		Connection co = getConnection();
	    Statement mystmt = co.createStatement();
	    String SQL = "SELECT *FROM Cons WHERE Id ='" +Cons_Id+"'" ;
	    ResultSet rs =mystmt.executeQuery(SQL);
	    Statement st = co.createStatement();
	    String Due_Date = "SELECT Due_Date FROM billrec where Cons_ID ='" +Cons_Id+"' && Month ='" +Month+"'"  ;
	 	ResultSet d = st.executeQuery(Due_Date);
	 	while(d.next()) {
	 		DD = d.getString(1);
	 		Date =Integer.parseInt(DD);
	 	}
	 	
	 	
	 	Statement Statement = co.createStatement();
	 	String ConsI = "SELECT *FROM billrec WHERE Cons_Id ='" +Cons_Id+"'" ;
	 	ResultSet Result =Statement.executeQuery(ConsI);
		 boolean isFound=false;
	   
	    if(rs.next()) {
	    	 Statement statement = co.createStatement();
			 String month = "SELECT *FROM billrec WHERE Month ='" +Month+"'" ;

			 ResultSet R =statement.executeQuery(month);
			 if(R.next() && Result.next()) {
				 
				 JOptionPane.showMessageDialog(contentPane, "Month of the Id is found");
				 Statement stmt = co.createStatement();
				 if (Current_Date<=Date) {
					 String data = "SELECT Receivable_WDD FROM billrec where Cons_ID ='" +Cons_Id+"' && Month ='" +Month+"'"  ;
					 ResultSet r =stmt.executeQuery(data);    
					 
					   if(r.next()){
					     isFound=true;
					   
					     Amount = r.getString(1);
					     
					   }
					   else {
						   System.out.println(isFound);
					   }}
				 if (Current_Date> Date) {
					 String data = "SELECT Receivable_ADD FROM billrec where Cons_ID ='" +Cons_Id+"' && Month ='" +Month+"'"  ;
					 JOptionPane.showMessageDialog(contentPane,"Due Date Has Passed!! ");
					 ResultSet r =stmt.executeQuery(data);    
					 
					   if(r.next()){
					     isFound=true;
					     Amount = r.getString(1);
					     
					     
					   }
					   else {
						   System.out.println(isFound);
					 
					   }

				 
			 }}
			 else {
				 JOptionPane.showMessageDialog(contentPane, "No Bill found of such Id!!");
			 }
	    }
	    else {
	    	JOptionPane.showMessageDialog(contentPane, "NO ID FOUND");
	    }
	    
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	///////////////////////////////////////
	public void ShowData_Cons() {
		try {
			Connection co = getConnection();
			String query = "SELECT * FROM cons";
			PreparedStatement posted = co.prepareStatement(query);
			ResultSet  rs = posted.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		
		}
		catch(Exception e) {
			System.out.println("Not Done");
		}
	}
	
	public void ShowData_Billrec() {
		try {
			Connection co = getConnection();
			String query = "SELECT * FROM billrec";
			PreparedStatement posted = co.prepareStatement(query);
			ResultSet  rs = posted.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		
		}
		catch(Exception e) {
			System.out.println("Not Done");
		}
	}
	public void ShowData_delrec() {
		try {
			Connection co = getConnection();
			String query = "SELECT * FROM delcons";
			PreparedStatement posted = co.prepareStatement(query);
			ResultSet  rs = posted.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		
		}
		catch(Exception e) {
			System.out.println("Not Done");
		}
	}
	
	 public static Connection getConnection() throws Exception{
		 try{
		   String driver = "com.mysql.jdbc.Driver";
		   String url = "jdbc:mysql://localhost:3306/record";
		   String username = "root";
		   String password = "Umar617796";
		   Class.forName(driver);
		   
		   Connection conn = DriverManager.getConnection(url,username,password);
		   System.out.println("Connected");
		   return conn;
		  } catch(Exception e){System.out.println(e);}
		  
		  
		  return null;
		 }

	 
	 //777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
	public void show_billrec() {
		LastBills obj = new LastBills();
		int Id = obj.getId();
		try {
		Connection co = getConnection();
		 Statement stmt = co.createStatement();
		String ConsI = "SELECT *FROM billrec WHERE Cons_Id ='" +Id+"'" ;
		 ResultSet Result =stmt.executeQuery(ConsI);
	 	if (Result.next()) {
			 Statement s = co.createStatement();
			 String I = "SELECT *FROM billrec WHERE Cons_Id ='" +Id+"'" ;
			 ResultSet R =s.executeQuery(I);
			 table_1.setModel(DbUtils.resultSetToTableModel(R));
			 
	 		
	 		}
	 	else {
	 		 JOptionPane.showMessageDialog(contentPane,"No Bill exists of such Id!! ");
	 	}
		
		
		}
		catch(Exception e) {
			
		}
	}
	 
	 
	 
	 public void delConsumer() {
		 try {
			 DelCons delete = new DelCons();
			 int Id=delete.getid();

//			 Scanner sc = new Scanner (System.in);
			 Connection con = getConnection();
			 Statement mystmt = con.createStatement();
	//		 int Id = sc.nextInt();
			 String SQL = "SELECT *FROM Cons WHERE Id ='" +Id+"'" ;
			 ResultSet rs =mystmt.executeQuery(SQL);
			 if(rs.next()) {
				PreparedStatement cons = con.prepareStatement("CREATE TABLE IF NOT EXISTS DelCons(ConsN varchar(255) UNIQUE, Id varchar(255) NOT NULL UNIQUE,	MeterN varchar(255) UNIQUE, PhoneN varchar(255) UNIQUE ,Email varchar(255) UNIQUE, Address varchar(255),PRIMARY KEY(id)) ");
				cons.executeUpdate();
				PreparedStatement posted = con.prepareStatement("INSERT INTO DelCons SELECT * FROM cons WHERE Id ='"+Id+"'");
				posted.executeUpdate();
				 
				 //System.out.println("Y");
				 String del = "delete from Cons where Id =?";
				 PreparedStatement m =con.prepareStatement(del);
				 m.setInt(1, Id);
				 m.executeUpdate();
				 JOptionPane.showMessageDialog(contentPane,"Consumer deletion successful! ");

				
				 

			 }
			 else {
				 JOptionPane.showMessageDialog(contentPane,"Please Enter Correct ID ");
			 }

		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	 }
	 public String getAmount() {
		 return Amount;
	 }
	 public boolean getboolean() {
		 return q;
	 }
	 public boolean getbo() {
		 return bo;
	 }
}
