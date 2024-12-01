package mvc.controller.ui;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.service.businessLogic;

@Controller
@Scope("prototype")
@SessionAttributes("username")
public class UIcontroller {
	@Autowired
	businessLogic bl;
	@RequestMapping("/authCheck")
	public String auth(@RequestParam String userid,@RequestParam String password, Model model ) {
		System.out.println("in controller");

		boolean res= bl.checkUserPwd(userid, password);
		
		if (res==true) {
			model.addAttribute("username", userid); 
			return "success";}
		else
			return "Failure";
	}
	
	@RequestMapping("/register")
	public String reg(@RequestParam String userid,@RequestParam String password) {
		System.out.println("in controller");
		
		boolean result= bl.register(userid, password);
		System.out.println("in controller again");
		
		if (result==true)
			return "success";
		else
			return "Failure";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String userid) {
		System.out.println("in controller");
		boolean result=bl.delete(userid);
		System.out.println("in controller again");
		if (result==true)
			return "success";
		else
			return "Failure";
		
	}
	
	@RequestMapping("/changePasswordPage")
	public String changePasswordPage() {
	    return "changePassword"; // Return the view name for the change password page
	}
	

	@RequestMapping("/changePassword")
    public String changePassword(@RequestParam String password,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 RedirectAttributes redirectAttributes,
                                 HttpSession session) {
        System.out.println("in controller in change password");
        String username = (String) session.getAttribute("username");
        boolean passwordChanged = bl.changePassword(username, password, newPassword, confirmPassword);

//        if (passwordChanged) {
//            redirectAttributes.addFlashAttribute("username", username);
//            redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully.");
//            redirectAttributes.addFlashAttribute("errorMessage", ""); // Clear error message
//        } else {
//            redirectAttributes.addFlashAttribute("errorMessage", "Failed to change password. Please check your current password or ensure the new passwords match.");
//            redirectAttributes.addFlashAttribute("successMessage", ""); // Clear success message
//        }

		    return "success";
		}
	

}
