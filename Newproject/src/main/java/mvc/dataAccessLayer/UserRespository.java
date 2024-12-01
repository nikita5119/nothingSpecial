package mvc.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRespository extends JpaRepository<UserEntity, String> {
	@Query(value="SELECT count(1) FROM users WHERE username= ?1 and password=?2",nativeQuery = true)
	public int checkUidPwdInDB(String username,String password);
	
	@Modifying
    @Query(value = "UPDATE User SET password = ?1 WHERE userid = ?2", nativeQuery = true)
    public void updatePassword(String newPassword, String users);
	

}
