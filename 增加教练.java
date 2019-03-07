package kk;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.JPanel;
import kk.jdbcfile;

public class 增加教练 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1=new JLabel("姓名",JLabel.CENTER);
	JLabel l2=new JLabel("性别",JLabel.CENTER);
	JLabel l3=new JLabel("身份证号码",JLabel.CENTER);
	JLabel l4=new JLabel("车型",JLabel.CENTER);
	JLabel l5=new JLabel("所教科目",JLabel.CENTER);
	JLabel l6=new JLabel("联系电话",JLabel.CENTER);
	JButton ok=new JButton("添加");
	JButton cancle=new JButton("取消");
	JTextField name=new JTextField(10);
	JTextField gender=new JTextField(10);
	JTextField sfz=new JTextField(20);
	JTextField type=new JTextField(10);
	JTextField item=new JTextField(10);
	JTextField phone=new JTextField(30);
	//JPanel p=new JPanel();
	增加教练(){
		super("教练添加");
		setSize(500,500);
		//this.getContentPane().add(p);
		//p.setLayout(null);
		setLayout(new GridLayout(7,2));
		
		add(l1);add(name);
		add(l2);add(gender);
		add(l3);add(sfz);
		add(l4);add(type);
		add(l5);add(item);
		add(l6);add(phone);
		add(ok);add(cancle);
		ok.addActionListener(this);
		cancle.addActionListener(this);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str_name=name.getText().toString().trim();
		String str_gender=gender.getText().toString().trim();
		String str_sfz=sfz.getText().toString().trim();
		String str_type=type.getText().toString().trim();
		String str_item=type.getText().toString().trim();
		String str_phone=phone.getText().toString().trim();
		
		
		//String sql_ID="select * from student where 号码='"+str_name+"'";
		String sql="insert into ttcoach(name,gender,sfz,type,item,phone) values('"+str_name+"','"+str_gender+"','"+str_sfz+"','"+str_type+"','"+str_item+"','"+str_phone+"')";
		try {
			if(e.getSource()==ok) {
				jdbcfile j=new jdbcfile();
				if(true) {
					int i=j.insert(sql);
					if(i==1) {
						JOptionPane.showMessageDialog(this,"操作成功");
						clear();
						
					}else {
						JOptionPane.showMessageDialog(this,"操作失败");
					}
				}
			}else if(e.getSource()==cancle) {
//				System.out.println(strT);
				System.exit(0);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

private void clear() {
	// TODO Auto-generated method stub
	name.setText("");gender.setText("");sfz.setText("");type.setText("");item.setText("");phone.setText("");
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
new 增加教练();
}

}

			