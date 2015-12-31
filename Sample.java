import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


 
public class Sample {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public Sample(){
		prepareGUI();
		}
	public static void main(String[] args)  throws IOException{
		Sample  Sample = new Sample();
		java.util.List<Instance> instances = DataSet.readDataSet("dataset1.txt");
	        Logistic logistic = new Logistic(5);
	        logistic.train(instances);  
        	Sample.showButtonDiagnose(logistic);
		}
	private void prepareGUI(){
		mainFrame = new JFrame("Logstic Regression");
		mainFrame.setSize(700,400);
		mainFrame.setLayout(new GridLayout(4, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent windowEvent){
		System.exit(0);
		}        
		});    
	headerLabel = new JLabel("", JLabel.CENTER);        
	statusLabel = new JLabel("",JLabel.CENTER);    
	statusLabel.setSize(350,100);
	controlPanel = new JPanel();
      
	controlPanel.setLayout(new FlowLayout());
	mainFrame.add(headerLabel);
	mainFrame.add(controlPanel);
	mainFrame.add(statusLabel);
	mainFrame.setVisible(true);  
	}
    
private void showButtonDiagnose(Logistic logistic){
	headerLabel.setText("Dengiue fever"); 
        JTextField txt1 = new JTextField(6);
	txt1.setText("1/0");
        JTextField txt2 = new JTextField(6);
	txt2.setText("1/0");
        JTextField txt3 = new JTextField(6);
	txt3.setText("1/0");
        JTextField txt4 = new JTextField(6);
	txt4.setText("1/0");
        JTextField txt5 = new JTextField(6);
	txt5.setText("1/0");
        JTextField rslt = new JTextField(6);
        JButton cancelButton = new JButton("Diagnose");
        cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);   

        cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

			int[] x =new int[5];//{2, 1, 1, 0, 1};
			x[0]=Integer.parseInt(txt1.getText());
			x[1]=Integer.parseInt(txt2.getText());
			x[2]=Integer.parseInt(txt3.getText());
			x[3]=Integer.parseInt(txt4.getText());
			x[4]=Integer.parseInt(txt5.getText());

			//System.out.println("prob(1|x) = " + logistic.classify(x));
			if(logistic.classify(x) >= 0.5 )
				{
				rslt.setText("+ve");
				}
			else
				{
				rslt.setText("-ve");//(lr.returnPrice(userText.getText()));
				}
        	}
                });
      controlPanel.add(txt1); 
      controlPanel.add(txt2); 
      controlPanel.add(txt3); 
      controlPanel.add(txt4); 
      controlPanel.add(txt5);
      controlPanel.add(cancelButton);
      controlPanel.add(rslt); 
      mainFrame.setVisible(true);  
	}
}
