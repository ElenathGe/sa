package operation;

public class Evaluation {
	private String movieid;
	private String userid;
	private String comment;
	private String grade;
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		if(movieid == null) {
			System.out.println("电影编号不能为空");
		}else {
			this.movieid = movieid;
		}
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		if(userid == null) {
			System.out.println("用户账号不能为空");
		}else {
			this.userid = userid;
		}
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}