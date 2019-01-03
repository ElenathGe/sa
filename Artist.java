package operation;

public class Artist {
	private String artistid;
	private String country;
	private String artistname;
	private String artistsex;
	private String birthday;
	private String birthplace;
	private String profession;
	private String nickname;
	private String relation;
	public String getArtistid() {
		return artistid;
	}
	public void setArtistid(String artistid) {
		if(artistid == null) {
			System.out.println("艺人编号不能为空");
		}else {
			this.artistid = artistid;
		}
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getArtistname() {
		return artistname;
	}
	public void setArtistname(String artistname) {
		if(artistname == null) {
			System.out.println("艺人姓名不能为空");
		}else {
			this.artistname = artistname;
		}
	}
	public String getArtistsex() {
		return artistsex;
	}
	public void setArtistsex(String artistsex) {
		if(artistsex == null) {
			System.out.println("性别不能为空");
		}else {
			this.artistsex = artistsex;
		}
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
}
