import java.awt.*;
import java.awt.event.*;
public class Test{
	public static int current1, current2 ,result, operation;
	Frame f;
	Button b;
	Label li;
 
	Test(){
	f=new Frame();
	li=new Label();
	li.setAlignment(li.RIGHT);

	
	//
	Panel p1=new Panel();
	p1.setLayout(new GridLayout(4,4,4,4));//패널 4행4열로 가로세로간격 4 4
	Button b7=new Button("7"); //얘네를 for문으로 돌릴 수 잇나?
	Button b8=new Button("8");
	Button b9=new Button("9");
	Button bdiv=new Button("/");
	Button b4=new Button("4");
	Button b5=new Button("5");
	Button b6=new Button("6");
	Button bmul=new Button("*");
	Button b1=new Button("1");
	Button b2=new Button("2");
	Button b3=new Button("3");
	Button bmin=new Button("-");
	Button b0=new Button("0");
	Button bc=new Button("C");
	Button br=new Button("=");
	Button bplu=new Button("+");
	p1.add(b7);
	p1.add(b8);
	p1.add(b9);
	p1.add(bdiv);
	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	p1.add(bmul);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(bmin);
	p1.add(b0);
	p1.add(bc);
	p1.add(br);
	p1.add(bplu);
	
	//
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("1")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("2")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("3")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("4")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("5")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("6")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("7")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("8")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b9.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("9")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	b0.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("0")){
			li.setText(li.getText()+cmd);
			}
		}
	});
	
	bplu.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("+")){
				Test.current1 = Integer.parseInt(li.getText());
				Test.operation = 1;
				li.setText("");
			}
		}
	});
	
	bmin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("-")){
			Test.current1 = Integer.parseInt(li.getText());
			Test.operation = 2;
			li.setText("");
			}
		}
	});
	
	bmul.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("*")){
			Test.current1 = Integer.parseInt(li.getText());
			Test.operation = 3;
			li.setText("");
			}
		}
	});
	
	bdiv.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("/")){
			Test.current1 = Integer.parseInt(li.getText());
			Test.operation = 4;
			li.setText("");
			}
		}
	});
	

	br.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("=")){
				Test.current2 = Integer.parseInt(li.getText());
				if(Test.operation == 1){
				Test.result = Test.current1+Test.current2;
				}
				if(Test.operation == 2){
				Test.result = Test.current1-Test.current2;
				}
				if(Test.operation == 3){
					Test.result = Test.current1*Test.current2;
				}
				if(Test.operation == 4){
					Test.result = Test.current1/Test.current2;
				}
				li.setText(String.valueOf(result));
			}
		}
	});
	
	bc.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String cmd=e.getActionCommand();
			if(cmd.equals("C")){
			li.setText("0");
			}
		}
	});
	
	
	
	f.add(li,BorderLayout.NORTH);
	
	f.add(p1,"Center");//
	f.setSize(300,200);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter(){
	         public void windowClosing(WindowEvent e) {
	             System.exit(0);
	         }
	});
	}
 

 
public static void main(String args[]){
	Test a = new Test();
}
 
}

