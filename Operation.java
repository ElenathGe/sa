package operation;
import java.util.*;
import java.io.*;
import java.sql.*;
import operation.User;

public class Operation extends DAOBase implements UserDAO{
	public static void input(User user) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入注册信息:");
		System.out.println("账号:");
		user.setUserid(sc.nextLine());
		System.out.println("设置我的昵称:");
		user.setUsername(sc.nextLine());
		System.out.println("设置我的密码:");
		user.setPassword(sc.nextLine());
		System.out.println("设置我的域名:");
		user.setDomainname(sc.nextLine());
		System.out.println("设置我的邮箱地址:");
		user.setEmail(sc.nextLine());
		System.out.println("设置手机号:");
		user.setPhonenumber(sc.nextLine());
		System.out.println("所在地:");
		user.setAddress(sc.nextLine());
	}
	private static final String CREATE_USER_SQL = "INSERT INTO Customer (userid, username, password, domainname, email, phonenumber, address) VALUES (?,?,?,?,?,?,?)";
	public void register(User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			input(user);
			pst = conn.prepareStatement(CREATE_USER_SQL);
			pst.setString(1,user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3,user.getPassword());
			pst.setString(4,user.getDomainname());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getPhonenumber());
			pst.setString(7,user.getAddress());
			int row = pst.executeUpdate();
			System.out.println("注册成功\t"+user.getUsername()+"你好!");
			pst.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				try {
					pst.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static final String SERACH_USER_PWD = "SELECT password FROM Customer WHERE userid=";
	public void logout(String userid, String password) {
		Connection conn = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		User user = new User();
		int row;
		try {
			conn = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入需要注销的账号:");
			userid = sc.nextLine();
			System.out.println("请输入你的密码:");
			password = sc.nextLine();
			String endsql = SERACH_USER_PWD + userid;
			PreparedStatement pst = conn.prepareStatement(endsql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String judge = rs.getString("password");
				if(password.equals(judge)) {
					String sqld = "delete from Customer where userid =";
					stmt2 = conn.createStatement();
					row = stmt2.executeUpdate(sqld+userid);
					System.out.println("账号已被注销");
					stmt2.close();
				}else {
					System.out.println("密码有误");
				}
			}
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	private static final String SEARCH_USER = "SELECT userid,username,domainname,email,phonenumber,address FROM Customer WHERE userid=";
	public User getInfo(String userid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			Scanner ReadStr=new Scanner(System.in);
			System.out.println("请输入要查询的用户账号:");		 
			userid=ReadStr.nextLine();
			String endsql = null;
			endsql = SEARCH_USER +userid;
			rs=stmt.executeQuery(endsql);
			while(rs.next()){				
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setDomainname(rs.getString("domainname"));
				user.setEmail(rs.getString("email"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setAddress(rs.getString("address"));
				System.out.println("账号:"+user.getUserid()+"\t昵称"+user.getUsername()+"\t域名:"+user.getDomainname()+"\n邮箱:"+user.getEmail()+"\t手机:"+user.getPhonenumber()+"\n所在地:"+user.getAddress());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	private static final String SEARCH_MOVIE = "SELECT movieid, moviename, director, scriptwriter, protagonist, type, region, language, releasedate, length, link, alternatename FROM Movie WHERE moviename =";
	public Movie getMovie(String moviename) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Movie movie = new Movie();
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			Scanner ReadStr=new Scanner(System.in);
			System.out.println("请输入要查询的影片名称:");		 
			moviename=ReadStr.nextLine();
			String endsql = null;
			endsql = SEARCH_MOVIE + moviename;
			rs=stmt.executeQuery(endsql);
			while(rs.next()) {
				movie.setmovieid(rs.getString("movieid"));
				movie.setmoviename(rs.getString("moviename"));
				movie.setdirector(rs.getString("director"));
				movie.setscriptwriter(rs.getString("scriptwriter"));
				movie.setprotagonist(rs.getString("protagonist"));
				movie.settype(rs.getString("type"));
				movie.setregion(rs.getString("region"));
				movie.setlanguage(rs.getString("language"));
				movie.setreleasedate(rs.getString("releasedate"));
				movie.setlength(rs.getString("length"));
				movie.setlink(rs.getString("link"));
				movie.setalternatename(rs.getString("alternatename"));
				System.out.println(movie.getmovieid()+"\t片名:"+movie.getmoviename()+"\n导演:"+movie.getdirector()+"\n编剧:"+movie.getscriptwriter()+"\n主要演员:"+movie.getprotagonist()+"\n类型:"+movie.gettype()+"\n地区:"+movie.getregion()+"\n语言:"+movie.getlanguage()+"\n上映时间:"+movie.getreleasedate()+"\n电影时长:"+movie.getlength()+"\n专题链接:"+movie.getlink()+"\n影片别名:"+movie.getalternatename());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	private static final String SEARCH_EVALUATION = "SELECT movieid, userid, comment, grade FROM movie_evaluation WHERE movieid =";
	public Evaluation getEvaluation(String movieid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Evaluation evaluation = new Evaluation();
		Movie movie = new Movie();
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			Scanner ReadStr=new Scanner(System.in);
			System.out.println("请输入要查询的电影:");		 
			movieid=ReadStr.nextLine();
			String endsql = null;
			endsql = SEARCH_EVALUATION + movieid;
			rs=stmt.executeQuery(endsql);
			while(rs.next()) {
				evaluation.setMovieid(rs.getString("movieid"));
				evaluation.setUserid(rs.getString("userid"));
				evaluation.setComment(rs.getString("comment"));
				evaluation.setGrade(rs.getString("grade"));
				System.out.println("影片编号:"+evaluation.getMovieid()+"\t账号:"+evaluation.getUserid()+"\t评分:"+evaluation.getGrade()+"\n评论:"+evaluation.getComment());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	public static void inputE(Evaluation e) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入评论信息:");
		System.out.println("电影编号:");
		e.setMovieid(sc.nextLine());
		System.out.println("用户账号:");
		e.setUserid(sc.nextLine());
		System.out.println("请写评论:");
		e.setComment(sc.nextLine());
		System.out.println("请写评分(10.0):");
		e.setGrade(sc.nextLine());
	}
	public void insertEvaluation(Evaluation e) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = new User();
		try {
			conn = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你的的账号:");
			String userid = sc.nextLine();
			System.out.println("请输入你的密码:");
			String password = sc.nextLine();
			String sqls = "select password from Customer where userid = " + userid;
			String CREATE_EVALUATION_SQL = "INSERT INTO [movie_evaluation] (movieid, userid, comment, grade) VALUES (?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(sqls);
			rs = pst1.executeQuery();
			while(rs.next()) {
				user.setPassword(rs.getString("password"));
				if(password.equals(user.getPassword())) {
					conn = getConnection();
					inputE(e);
					pst = conn.prepareStatement(CREATE_EVALUATION_SQL);
					pst.setString(1, e.getMovieid());
					pst.setString(2, userid);
					pst.setString(3, e.getComment());
					pst.setString(4, e.getGrade());
					int row = pst.executeUpdate();
					System.out.println("成功更新了"+row+"条评论");
					pst.close();
					conn.close();
				}else {
					System.out.println("密码有误");
				}
			}
			pst1.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			if(pst!=null) {
				try {
					pst.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	private static final String SEARCH_ARTIST = "SELECT artistid, country, artistname, artistsex, birthday, birthplace, profession, nickname, relation FROM Artist WHERE artistname =";
	public Artist getArtist(String artistname) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Artist artist = new Artist();
		try{
			conn = getConnection();
			stmt = conn.createStatement();			
			@SuppressWarnings("resource")
			Scanner ReadStr=new Scanner(System.in);
			System.out.println("请输入要查询的艺人姓名:");		 
			artistname=ReadStr.nextLine();
			String endsql = null;
			endsql = SEARCH_ARTIST + artistname;
			rs=stmt.executeQuery(endsql);
			while(rs.next()) {
				artist.setArtistid(rs.getString("artistid"));
				artist.setCountry(rs.getString("country"));
				artist.setArtistname(rs.getString("artistname"));
				artist.setArtistsex(rs.getString("artistsex"));
				artist.setBirthday(rs.getString("birthday"));
				artist.setBirthplace(rs.getString("birthplace"));
				artist.setProfession(rs.getString("profession"));
				artist.setNickname(rs.getString("nickname"));
				artist.setRelation(rs.getString("relation"));
				System.out.println(artist.getArtistid()+"\t国籍:"+artist.getCountry()+"\n姓名:"+artist.getArtistname()+"\t性别:"+artist.getArtistsex()+"\n出生年月:"+artist.getBirthday()+"\t出生地:"+artist.getBirthplace()+"\n职业:"+artist.getProfession()+"\t艺名:"+artist.getNickname()+"\n人物关系:"+artist.getRelation());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	private static final String SEARCH_MOVIE_ALL = "SELECT * FROM MOVIE";
	public Movie getAllMovie(String movieid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Movie movie = new Movie();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String endsql = SEARCH_MOVIE_ALL;
			rs = stmt.executeQuery(endsql);
			while(rs.next()) {
				movie.setmovieid(rs.getString("movieid"));
				movie.setmoviename(rs.getString("moviename"));
				movie.setdirector(rs.getString("director"));
				movie.setscriptwriter(rs.getString("scriptwriter"));
				movie.setprotagonist(rs.getString("protagonist"));
				movie.settype(rs.getString("type"));
				movie.setregion(rs.getString("region"));
				movie.setlanguage(rs.getString("language"));
				movie.setreleasedate(rs.getString("releasedate"));
				movie.setlength(rs.getString("length"));
				movie.setlink(rs.getString("link"));
				movie.setalternatename(rs.getString("alternatename"));
				System.out.println(movie.getmovieid()+"\t片名:"+movie.getmoviename());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
