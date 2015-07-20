package myPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	private JFrame jFrameApp = new JFrame("Cards Program");
	
	//panel startu programu
	private JPanel jPanelLoG = new JPanel();
	private JLabel jlabLogin = new JLabel("Please write Login: ");
	private JTextField jtfLogin = new JTextField(10);
	private JLabel jlabPassword = new JLabel("Please write Password :");
	private JPasswordField jpsPassword = new JPasswordField(10);
	private JButton jbtnOK = new JButton("OK");
	
	Boolean allIsOK=false;
	private String Login="";
	private String Password="";
	
	public GUI() {
		// TODO Auto-generated constructor stub
		InitPanelLogin();
	}

	//inicjalizacja panelu logowania
	public void InitPanelLogin()
	{
		jFrameApp.setSize(400, 250);
		jFrameApp.isAlwaysOnTop();
		jFrameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrameApp.setVisible(true);
		jPanelLoG.setLayout(new GridLayout(3,2));
		jPanelLoG.add(jlabLogin);
		jPanelLoG.add(jtfLogin);
		jPanelLoG.add(jlabPassword);
		jPanelLoG.add(jpsPassword);
		jPanelLoG.add(jbtnOK);
		jbtnOK.addActionListener(this);
		jPanelLoG.setVisible(false);
		jFrameApp.add(jPanelLoG);
		jPanelLoG.setVisible(true);
	}

	public String getLogin(){return Login;}
	public String getPassword(){return Password;}
	public Boolean getOK(){return allIsOK;}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if(source==jbtnOK)
		{
			Login= jtfLogin.getText().toString();
			Password=jpsPassword.getText().toString();
			allIsOK=true;
			jPanelLoG.setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}
}
