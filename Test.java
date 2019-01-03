package operation;
import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String moviename = null;
		String movieid = null;
		String userid = null;
		String password =null;
		String artistname = null;
		Evaluation evaluation = new Evaluation();
		Operation op = new Operation();
		User user = new User();
		System.out.println("欢迎来到影评界面!");
		System.out.println("以下是影视库作品编号:");
		op.getAllMovie(movieid);
		String button = "1";
		while(button != "0"){
			System.out.println("请选择你的操作:'1'新用户注册;'2'查询电影信息;'3'查询影评信息;'4'编写影评(仅限注册过的用户);'5'查询艺人信息'6'账号注销;'0'退出操作");
			String select = sc.nextLine();
			switch(select) {
			case"1":op.register(user);break;
			case"2":op.getMovie(moviename);break;
			case"3":op.getEvaluation(movieid);break;
			case"4":op.insertEvaluation(evaluation);break;
			case"5":op.getArtist(artistname);break;
			case"6":op.logout(userid, password);break;
			case"7":op.getInfo(userid);break;
			case"0":button = "0";break;
			default:System.out.println("请输入正确的操作符");
			}
		}
		System.out.println("系统提示:退出操作");
	}
}