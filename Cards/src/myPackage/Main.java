package myPackage;

public class Main {
	
	
	static User ActiveUser=null;
	
	public static Boolean checkLogin(String Login, String Password)
	{
		DataBase myDB=new DataBase();
		User[] my = myDB.getUsers();
		Boolean result=false;
		for(int x=0;x<my.length;x++)
		{
			String l=my[x].getLogin();
			String p=my[x].getPassword();
			if(l.contains(Login)&&p.contains(Password))
			{
				ActiveUser=my[x];
				result= true;
				break;
			}
		}
		myDB.ClosDataBase();
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI mI = new GUI();
		while(!mI.getOK()){}
		if(checkLogin(mI.getLogin(), mI.getPassword()))
		{
			System.out.println("Zalogowano jako "+ActiveUser.getName()+" "+ActiveUser.getSurname());
			DataBase DB = new DataBase();
			Task[] m = DB.getListmyTask(ActiveUser);
			for(int i=0;i<m.length;i++)
			{
				System.out.println("Mój task to : "+m[i].getName());
			}
		}
		else
		{
			System.out.println("Nie zalogowano");
		}

	}

}
