package operation;

public interface UserDAO {
	public void register(User user);
	public void logout(String userid, String password);
	public User getInfo(String userid);
}
