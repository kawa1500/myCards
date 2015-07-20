package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//https://bitbucket.org/xerial/sqlite-jdbc/downloads/sqlite-jdbc-3.8.10.1.jar

public class DataBase {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String Host = "jdbc:sqlite:cards.sqlite";
	private Connection con = null;//³¹czenie z baza
	private Statement state = null;//zapytanie do bazy
	private ResultSet rs = null;//wynik zapytania
	int CounterUser=0;
	
	public DataBase() {
		
		try {
            Class.forName(DataBase.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
        }
 
        try {
            con = DriverManager.getConnection(Host);
            state = con.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
        }
	}
	
	public void ClosDataBase(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int[] getListIDUser()
	{
		CounterUser=0;
		int[] result=null;
		String query = "select * from Users";
		try {
			rs = state.executeQuery(query);
			while(rs.next()){CounterUser++;}
			result = new int[CounterUser];
			CounterUser=0;
			rs = state.executeQuery(query);
			while(rs.next())
			{
				result[CounterUser] = rs.getInt("IDUser");
				CounterUser++;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private User getUser(int ID)
	{
		User myUser=null;
		String query = "select * from Users where IDUser="+String.valueOf(ID);
		try {
			rs=state.executeQuery(query);
			String Name=rs.getString(2);
			String Surname=rs.getString(3);
			String Mail=rs.getString(4);
			String cDate=rs.getString(5);
			String lDate=rs.getString(6);
			int Status=rs.getInt(7);
			String Login=rs.getString(8);
			String Password=rs.getString(9);
			
			myUser = new User(ID, Name, Surname, Mail,cDate ,lDate,Status ,Login ,Password );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myUser;
	}
	
	public User[] getUsers()
	{
		User[] Users= null;
		int[] n=getListIDUser();
		Users = new User[CounterUser];
		for(int i=0;i<CounterUser;i++){
			User myUser = getUser(n[i]);
			Users[i]=myUser;
		}	
		
		return Users;
	}

	public void updateUser(User nUser)
	{
		//System.out.println(nUser.getMail());
		String query = "update Users set Name=?, Surname=?,  Mail=? , LastLoging=?, Status=?, Login=?, Password=? where IDUser=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nUser.getName());
			pstmt.setString(2, nUser.getSurname());
			pstmt.setString(3, nUser.getMail());
			pstmt.setString(4, nUser.getLastDate());
			pstmt.setInt(5, nUser.getStatus());
			pstmt.setString(6, nUser.getLogin());
			pstmt.setString(7, nUser.getPassword());
			pstmt.setInt(8, nUser.getID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Task[] getListmyTask(User nUser)
	{
		Task[] wynik=null;
		int countTask=0;
		String query = "select * from Instances where IDUser=? and Status=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nUser.getID());
			pstmt.setInt(2, 1);
			rs = pstmt.executeQuery();
			while(rs.next()){countTask++;}
			wynik= new Task[countTask];
			countTask=0;
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				query="select * from Tasks where IDTask=?";
				PreparedStatement pstmt1 = con.prepareStatement(query);
				pstmt1.setInt(1, rs.getInt("IDTask"));
				ResultSet rs1 = pstmt1.executeQuery();
				
				int ID=rs1.getInt(1);
				String Name=rs1.getString(2);
				int creator=rs1.getInt(3);
				String cDate=rs.getString(4);
				int Status=rs1.getInt(5); 
				int Column=rs1.getInt(6);
				int Owner=rs1.getInt(7);
				String lDate=rs1.getString(8);
				int prio=rs1.getInt(9);
				
				wynik[countTask]=new Task(ID, Name, creator, cDate, Status, Column, Owner, lDate, prio);
				countTask++;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wynik;
	}
}
