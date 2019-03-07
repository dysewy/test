package kk;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import kk.教练信息修改;
import kk.jdbcfile;
import kk.教练信息修改;
public class 教练信息修改 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p=new JPanel();
	JLabel pLb1=new JLabel("查询方式：");
	
	JLabel pLb2=new JLabel("1、按姓名模糊查询：");
	JTextField pT1=new JTextField(10);
	JLabel pLb3=new JLabel("2、按性别查询：");
	Object []state= {"男","女"};
	JComboBox cGender=new JComboBox(state);
	JLabel pLb4=new JLabel("3、按照车型：");
	JTextField pT2=new JTextField(10);
	JButton B1=new JButton("查  询");
	JButton B2=new JButton("刷   新");
	JPanel up=new JPanel();
	JLabel lb1=new JLabel("请输入需要修改信息的ID：");
	static JTextField t1=new JTextField(10);
	JButton b1=new JButton("修改");
	JPanel de=new JPanel();
	JTabbedPane tp=new JTabbedPane();
	DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	static String[] col_all= {"姓名","性别","身份证号码","车型","所教科目","电话"};
	static String[][] values_all;
	static DefaultTableModel tm=new DefaultTableModel(values_all,col_all);
	JTable t=new JTable(tm);
	JScrollPane s=new JScrollPane(t);
	Object Tname;
    static String name;
	static String gender;
	static String sfz;
	static String type;
	static String item;
	static String phone;
	static String sql="select * from ttcoach";
	static String cx(String s) {
		jdbcfile j;
		tm.setRowCount(0);
		try {
			j = new jdbcfile();
			ResultSet rs=j.executeQuery(s);
			while(rs.next()) {
				name=rs.getString("name");
				gender=rs.getString("gender");
				sfz=rs.getString("sfz");
				type=rs.getString("type");
				item=rs.getString("item");
				phone=rs.getString("phone");
				String rowvalues[]= {name,gender,sfz,type,item,phone};
				tm.addRow(rowvalues);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 教练信息修改();
		cx(sql);
	}
	教练信息修改(){
		super("教练信息修改");
		this.setSize(1100,900);
		this.getContentPane().add(p);
		p.setLayout(null);
//		p.setBorder(BorderFactory.createLineBorder(Color.gray,3));
//		tp.setBorder(BorderFactory.createLineBorder(Color.gray,3));
		p.add(tp);
		p.add(s);
		p.add(pLb1);p.add(pLb2);
		p.add(pT1);p.add(pLb3);p.add(cGender);p.add(pLb4);
		p.add(pT2);p.add(B1);p.add(B2);
		pLb1.setBounds(20,650,100,25);
		pLb2.setBounds(100,700,200,25);
		pT1.setBounds(320,700,150,30);
		pLb3.setBounds(100,780,200,25);
		cGender.setBounds(320,778,150,30);
		pLb4.setBounds(620,700,200,25);
		pT2.setBounds(800,700,150,30);
		B1.setBounds(600,760,170,60);;B1.setContentAreaFilled(false);
		B2.setBounds(820,760,170,60);B2.setContentAreaFilled(false);
		s.setBounds(0,145,1095,500);
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		up.setLayout(null);de.setLayout(null);
		tp.setBounds(0,0,1100,150);
		tp.setTabPlacement(JTabbedPane.TOP);
		tp.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		tp.setBorder(BorderFactory.createLoweredBevelBorder());
		tp.addTab("修改信息",up);
		lb1.setBounds(350,40,250,30);
		
		t1.setBounds(560,42,70,30);
		b1.setBounds(650,42,70,30);b1.setContentAreaFilled(false);
	
		
		
		
		up.add(lb1);up.add(t1);up.add(b1);
		
		r.setHorizontalAlignment(JLabel.CENTER);
		t.setDefaultRenderer(Object.class,r);
		B1.addActionListener(this);
		B2.addActionListener(this);
		b1.addActionListener(this);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		t.setRowHeight(30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String strT1=t1.getText().toString().trim();
		//String strT2=t2.getText().toString().trim();
		String strGender=cGender.getSelectedItem().toString().trim();
		String strName=pT1.getText().toString().trim();
		String strType=pT2.getText().toString().trim();
		String sql1="select * from ttcoach where gender='"+strGender+"'";
		String sql2="select * from ttcoach where name like '%"+strName+"%'";
		String sql3="select * from ttcoach where type like '"+strType+"%'";
		
		if(e.getSource()==B1) {
			if(strName.length()==0&strType.length()==0) {
				clear();
				cx(sql1);
			}else if(strName.length()!=0&strType.length()==0) {
				clear();
				cx(sql2);
			}else if(strName.length()==0&strType.length()!=0) {
				clear();
				cx(sql3);
			}else {
				JOptionPane.showMessageDialog(this,"仅限定输入一个查询条件！");
				cx(sql);
				clear();}}else if(e.getSource()==B2) {
					cx(sql);
					clear();
				}else if(e.getSource()==b1) {
					
					if(strT1.length()>0) {
						jdbcfile jdbc;
						String sql4="select name from ttcoach where sfz='"+strT1+"'";
						String sql7="delete from ttcoach where sfz='"+strT1+"'";
						try {
							jdbc = new jdbcfile();
							ResultSet rs=jdbc.executeQuery(sql4);
							if(rs.next()) {
								String strgetName=rs.getString("name");
								int c=jdbc.update(sql7);
								if(c==1) {
									教练信息修改 iu=new 教练信息修改();
									JOptionPane.showMessageDialog(this,"打开修改界面");
									if(e.getSource()==b1) {
										 new 增加教练();	}
									
								}
							}else {
								JOptionPane.showMessageDialog(this,"查不到该用户");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(this,"ID不允许为空！");
					}
					
				}else  {
									JOptionPane.showMessageDialog(this,"请稍后再试");
									cx(sql);
									clear();
								}
							}
						
				public void clear() {
				t1.setText("");
				
				pT1.setText("");
				
			}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	