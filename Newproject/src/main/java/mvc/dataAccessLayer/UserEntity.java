package mvc.dataAccessLayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@Column(name="username")
	String uid;
	@Column(name="password")
	String pwd;
	
	public UserEntity(String uid,String pwd )
	{
		this.uid=uid;
		this.pwd=pwd;
	}
	public UserEntity(String uid)
	{
		this.uid=uid;
	}
	public UserEntity()
	{
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
	
	
	


