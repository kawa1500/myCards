package myPackage;


public class User {

	int IDUser;
	String Name;
	String Surname;
	String Mail;
	String CreatedDate;
	String LastLoginDate;
	int Status;
	String Login;
	String Password;
	
	public User(int ID, String nName, String nSurname, String nMail, String CrDate, String LastDate, int nStatus, String nLogin, String nPassword) {
		IDUser=ID;
		Name=nName;
		Surname=nSurname;
		Mail=nMail;
		CreatedDate=CrDate;
		LastLoginDate=LastDate;
		Status=nStatus;
		Login=nLogin;
		Password=nPassword;
	}
	
	public int getID(){return IDUser;}
	public String getName(){return Name;}
	public String getSurname(){return Surname;}
	public String getMail(){return Mail;}
	public String getDateCreated(){return CreatedDate;}
	public String getLastDate(){return LastLoginDate;}
	public int getStatus(){return Status;}
	public String getLogin(){return Login;}
	public String getPassword(){return Password;}
	
	public void setMail(String nMail){Mail=nMail;}
	public void setName(String nName){Name=nName;}
	public void setSurname(String nSurname){Surname=nSurname;}
	public void setLastDate(String nDate){LastLoginDate=nDate;}
	public void setStatus(int nStatus){Status=nStatus;}
	public void setLogin(String nLogin){Login=nLogin;}
	public void setPassword(String nPass){Password=nPass;}
		
	
}
