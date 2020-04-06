package ${groupId}.domain.aws;

public class Account {
	private String id;
	private String name;
	private String geeSubsciberKey;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeeSubsciberKey() {
		return geeSubsciberKey;
	}
	public void setGeeSubsciberKey(String geeSubsciberKey) {
		this.geeSubsciberKey = geeSubsciberKey;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", geeSubsciberKey=" + geeSubsciberKey + "]";
	}
	
	
}
