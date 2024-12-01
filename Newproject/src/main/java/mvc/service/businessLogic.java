package mvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dataAccessLayer.UserEntity;
import mvc.dataAccessLayer.UserRespository;

@Service
public class businessLogic {
	@Autowired
	UserRespository ur;
	public boolean checkUserPwd(String userid,String password) {
		System.out.println("in service");
		int res= ur.checkUidPwdInDB(userid, password);
//if(userid.equals("john") && password.equals("john1!"))
		if(res ==0)
			return false;
		else
			return true;
	}
	
	public boolean register(String userid, String pwd) {
		System.out.println("in service");
		UserEntity ue=new UserEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
		return true;
	}
	
	public boolean delete(String userid) {
		UserEntity ue=new UserEntity();
		ue.setUid(userid);
		ur.delete(ue);
		return true;
	}
	
	@Transactional
	public boolean changePassword(String userId, String password, String newPassword, String confirmPassword) {
        // Perform validation and logic for changing password
		System.out.println("in service of passwordchange");
        int userExists = ur.checkUidPwdInDB(userId, password);

        if (userExists > 0 && newPassword.equals(confirmPassword)) {
            // Password change logic
            ur.updatePassword(newPassword, userId);
            return true;
        } else {
            return false;
        }
    }
}
