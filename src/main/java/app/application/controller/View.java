package app.application.controller;

import app.application.model.dto.EmployeeDto;
import app.application.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class View {

    private final EmployeeService employeeService;


    @GetMapping("/")
    public String index() {
        return "login.html";
    }

    @GetMapping("/employee")
    public String employee() {
        return "employee/index.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "main/index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/main")
    public String main() {
        return "main/index.html";
    }

    @GetMapping("/availablerooms")
    public String availableRoom(){ return "main/availableRooms.html";}

    @GetMapping("/employeeavailablerooms")
    public String employeeavailablerooms(){return "employee/availableRooms.html";}

    @GetMapping("/createaccount")
    public String createAccount(){return "main/createAcc.html";}

    @GetMapping("/accountupdate")
    public String accountupdate(){return "main/accountSettings.html";}

    @GetMapping("/employeeaccountupdate")
    public String employeeaccountupdate(){return "employee/accountSettings.html";}



    @GetMapping("/auth/employee")
    @ResponseBody
    public EmployeeDto currentUserName(Authentication authentication) {
        return employeeService.getByEmail(authentication.getName());
    }

}
