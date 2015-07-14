package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.User;
public class DatabaseController {
	static Statement statWrite1;
	static Statement statWrite2;
	static Statement statWrite3;
	static Statement statWrite4;
	static Statement statReader;
	/*public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://114.212.43.37:3306/yw","wjc","wjc");
			String sql1="drop table tb1";
			String sql2="create table UserTable(userID varchar(20),userName varchar(20),primary key(userID));";
			 statWrite=conn.createStatement();
			statWrite.execute(sql1);
			statWrite.execute(sql2);
			System.out.println("123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	public  static void  writeUserPO(String userID,String userName,String password,int state){
		String sql="insert into UserTable values('"+userID+"','"+userName+"','"+password+"','"+state+"');";
		try {
			statWrite1.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void setConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connWrite = DriverManager.getConnection("jdbc:mysql://114.212.43.37:3306/yw","wjc","wjc");
		statWrite1=connWrite.createStatement();
		statWrite2=connWrite.createStatement();
		statWrite3=connWrite.createStatement();
		statWrite4=connWrite.createStatement();
		Connection connReader = DriverManager.getConnection("jdbc:mysql://114.212.43.37:3306/yw","wjc","wjc");
		statReader=connReader.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean searchUserPO(String userID,String password){
		boolean is=false;
		String sql="select * from UserTable where userID='"+userID+"'and password='"+password+"';";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				is=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	public static User getUserByID(String ID){
		User u=new User();
		String sql="select * from UserTable where userID='"+ID+"';";
		try{
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				u.setUserID(ID);
				u.setPassword(rs.getString("password"));
				u.setState(rs.getInt("state"));
				u.setUserName(rs.getString("userName"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public static void setUserState(String ID){
		String sql="update usertable set inRoom=1 where userID='"+ID+"';";
		try {
			statWrite1.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void ReturnState(String ID){
		String sql="update usertable set inRoom=0 where userID='"+ID+"';";
		try {
			statWrite1.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean checkUser(String userID){
		boolean is=false;
		String sql="select * from UserTable where userID='"+userID+"';";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				is=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	public static void changeUserName(String ID,String userName){
		String sql="update usertable set username="+userName+"where userID='"+ID+"';";
		try {
			statWrite1.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  static void  writeRoomPO(String ID,String name,String stime,String etime,String act,String loa,int pnum){
		String sql="insert into roomtable values('"+ID+"','"+name+"','"+stime+"','"+etime+"','"+act+"','"+loa+"','"+pnum+"');";
		try {
			statWrite2.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  static void  writeChattingPO(String ID,String time,String speaker,String listener,String content){
		String sql="insert into chat values('"+ID+"','"+time+"','"+speaker+"','"+listener+"','"+content+"');";
		try {
			statWrite3.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void addNum(String ID){
		String sql="update roomtable set pnum=pum+1 where roomID='"+ID+"';";
		try {
			statWrite2.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void subNum(String ID){
		String sql="select pnum from roomtable where roomID='"+ID+"';";
		int pnum=0;
		try {
			ResultSet rs=statReader.executeQuery(sql);
			if(rs.next()){
				pnum=rs.getInt("pnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pnum--;
		if(pnum>0){
			String sql2="update roomtable set pnum='"+pnum+"' where roomID='"+ID+"';";
			try {
				statWrite2.execute(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			String sql3="delete from roomtable where roomID='"+ID+"';";
			try {
				statWrite2.execute(sql3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean checkRoomID(String ID){
		boolean is=false;
		String sql="select * from roomtable where roomID='"+ID+"';";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				is=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	public static ArrayList<String> getTwentyMess(String ID){
		ArrayList<String> mes=new ArrayList<String>();
		String sql="select * from chat where roomID='"+ID+"' order by time desc";
		int i=0;
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				i++;
				String temp=rs.getString("roomID")+"//"+rs.getString("time")+"//"+rs.getString("speaker")+"//"+rs.getString("listener")+"//"+rs.getString("content");
				mes.add(temp);
				if(i>20){
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mes;
	}
	public static ArrayList<String> showRoom(){
		ArrayList<String> rooms=new ArrayList<String>();
		String sql="select * from roomtable";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				String temp=rs.getString("roomID")+"//"+rs.getString("starttime")+"//"+rs.getString("endtime")+"//"+rs.getString("activity")+"//"+rs.getString("location")+"//"+rs.getInt("pnum");
				rooms.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;
	}
	public static void leave(String userID){
		String sql="select roomID from roomusertable where userID='"+userID+"';";
		String roomID="";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			if(rs.next()){
				roomID=rs.getString("roomID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statWrite2.execute("delete from roomusertable where userID='"+userID+"';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		subNum(roomID);
	}
	public static void come(String userID,String roomID){
		String sql="insert into roomusertable values('"+userID+"','"+roomID+"');";
		try {
			statWrite2.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		addNum(roomID);
	}
	public static ArrayList<String> search(String roomID){
		ArrayList<String> result=new ArrayList<String>();
		String sql="select *  where  roomID='"+roomID+"';";
		try {
			ResultSet rs=statReader.executeQuery(sql);
			while(rs.next()){
				result.add(rs.getString("roomID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[]args){
		setConnection();
		//getTwentyMess("10000");
		System.out.print(getTwentyMess("10000"));
		//writeChattingPO("10000","1990-10-23","333","dafeiji","509");
		//System.out.print("Y");
	}
	public static void deleteRoom(String ID){
		String sql3="delete from roomtable where roomID='"+ID+"';";
		try {
			statWrite2.execute(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
