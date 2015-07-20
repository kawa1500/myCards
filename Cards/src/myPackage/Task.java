package myPackage;

public class Task {

	int ID;
	String Name;
	int creatorID;
	String createDate;
	int Status;
	int Column;
	int OwnerID;
	String lastDate;
	int Priorytet;
	
	
	public Task(int nID, String nName, int nCID, String cDate, int nStatus, int nColumn, int nOID, String lDate, int Prio) {
		ID=nID;
		Name=nName;
		creatorID=nCID;
		createDate=cDate;
		Status=nStatus;
		Column=nColumn;
		OwnerID=nOID;
		lastDate=lDate;
		Priorytet=Prio;
	}
	
	public int getID(){return ID;}
	public String getName(){return Name;}
	public int getCreatorID(){return creatorID;}
	public String getCreateDate(){return createDate;}
	public int getStatus(){return Status;}
	public int getColumn(){return Column;}
	public int getOwner(){return OwnerID;}
	public String getLastDate(){return lastDate;}
	public int getPriorytet(){return Priorytet;}
	
	public void setName(String nName){Name=nName;}
	public void setStatus(int nStat){Status=nStat;}
	public void setColumn(int nColum){Column=nColum;}
	public void setOwner(int ID){OwnerID=ID;}
	public void setDate(String Last){lastDate=Last;}


}
