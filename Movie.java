package operation;
public class Movie {
	private String movieid;
	private String moviename;
	private String director;
	private String scriptwriter;
	private String protagonist;
	private String type;
	private String region;
	private String language;
	private String releasedate;
	private String length;
	private String link;
	private String alternatename;
	public String getmovieid() {
		return movieid;
	}
	public void setmovieid(String movieid) {
		if(movieid == null) {
			System.out.println("电影编号不能为空");
		}else {
			this.movieid = movieid;
		}
	}
	public String getmoviename() {
		return moviename;
	}
	public void setmoviename(String moviename) {
		if(moviename == null) {
			System.out.println("电影名称不能为空");
		}else {
			this.moviename = moviename;
		}
	}
	public String getdirector() {
		return director;
	}
	public void setdirector(String director) {
		if(director == null) {
			System.out.println("导演不能为空");
		}else {
			this.director = director;
		}
	}
	public String getscriptwriter() {
		return scriptwriter;
	}
	public void setscriptwriter(String scriptwriter) {
		if(scriptwriter == null) {
			System.out.println("编剧不能为空");
		}else {
			this.scriptwriter = scriptwriter;
		}
	}
	public String getprotagonist() {
		return protagonist;
	}
	public void setprotagonist(String protagonist) {
		this.protagonist = protagonist;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		if(type == null) {
			System.out.println("电影类型不能为空");
		}else {
			this.type = type;
		}
	}
	public String getregion() {
		return region;
	}
	public void setregion(String region) {
		this.region = region;
	}
	public String getlanguage() {
		return language;
	}
	public void setlanguage(String language) {
		this.language = language;
	}
	public String getreleasedate() {
		return releasedate;
	}
	public void setreleasedate(String releasedate) {
		if(releasedate == null) {
			System.out.println("上映日期不能为空");
		}else {
			this.releasedate = releasedate;
		}
	}
	public String getlength() {
		return length;
	}
	public void setlength(String length) {
		if(length == null) {
			System.out.println("电影时长不能为空");
		}else {
			this.length = length;
		}
	}
	public String getlink() {
		return link;
	}
	public void setlink(String link) {
		this.link = link;
	}
	public String getalternatename() {
		return alternatename;
	}
	public void setalternatename(String alternatename) {
		this.alternatename = alternatename;
	}
}
