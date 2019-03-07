package kk;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 学员学费入账 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1=new JLabel("姓名",JLabel.CENTER);
	JLabel l2=new JLabel("性别",JLabel.CENTER);
	JLabel l3=new JLabel("身份证号码",JLabel.CENTER);
	JLabel l4=new JLabel("单据编号",JLabel.CENTER);
	JLabel l5=new JLabel("联系电话",JLabel.CENTER);
	JLabel l6=new JLabel("收费金额",JLabel.CENTER);
	JButton ok=new JButton("确认");
	JButton cancle=new JButton("取消");
	JTextField name=new JTextField(10);
	JTextField gender=new JTextField(10);
	JTextField id=new JTextField(20);
	JTextField number=new JTextField(10);
	JTextField phone=new JTextField(20);
	JTextField money=new JTextField(20);
	学员学费入账(){
		super("学员收费入账");
		setSize(500,500);
		setLayout(new GridLayout(7,2));
		add(l1);add(name);
		add(l2);add(gender);
		add(l3);add(id);
		add(l4);add(number);
		add(l5);add(phone);
		add(l6);add(money);
		add(ok);add(cancle);
		ok.addActionListener(this);
		cancle.addActionListener(this);
		setVisible(true);
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str_name=name.getText().toString();
		String str_gender=gender.getText().toString();
		String str_shefenzheng=id.getText().toString();
		String str_type=number.getText().toString();
		String str_phone=phone.getText().toString();
		String str_money=money.getText().toString();
		
		
		//String sql_ID="select * from stu_money where ='"+str_name+"'";
		String sql_insert="insert into stu_money values('"+str_name+"','"+str_gender+"','"+str_shefenzheng+"','"+str_type+"','"+str_phone+"','"+str_money+"')";
		try {
			if(e.getSource()==ok) {
				jdbcfile j=new jdbcfile();
				if(true) {
					int i=j.insert(sql_insert);
					if(i==1) {
						JOptionPane.showMessageDialog(this,"操作成功");
						clear();
						
					}else {
						JOptionPane.showMessageDialog(this,"操作失败");
					}
				}
			}else if(e.getSource()==cancle) {
//				System.out.println(strT);
			}else {
				System.exit(0);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}





	private void clear() {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
 new 学员学费入账();
	}

}


