package com.bsys.Controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bsys.service.*;
import com.bsys.models.Transactions;
import com.bsys.models.*;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class ApiController {
	
	@Autowired
    private UserService Service;
    
    @Autowired
    private RestTemplate restTemplate ;

    @GetMapping("/getBalance")
    public List<User> getAllStaffs() {
        return Service.getAllStaff();
    }
    
    @GetMapping("/getAllTransaction")
    public List<Transactions> getAllOrder() {
        return Service.getAllOrder();
    }
    
    
    @PostMapping("/dash/newTransaction")
    
    public Transactions addOrder(@RequestBody Transactions ord)
    
    {
    	return Service.createOrder(ord);
    }
    
    
    @PostMapping("/auth/signup")
    public String addStaff(@RequestBody User f) {
        return Service.SignUpx(f);
    }
    @PostMapping("/auth/login")
	private String Login(@RequestBody Map<String, String> Loginx) {
	    String email = Loginx.get("email");
	    String password = Loginx.get("pwd");
	    String result = Service.Loginx(email, password);
	    return result;
	}
 

    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable int id) {
        return (Service.deleteStaff(id)) ? "User deleted successfully" : "User Not Found";
    }
    
    @DeleteMapping("/del/{Trans_id}")

	public String deletedetails(@PathVariable("Ord_id") int Ord_id)

	{

	return Service.deleteOrderById(Ord_id);

	}
    
    //get Role
    
    @PostMapping("/auth/login/role")
    public String getRole(@RequestBody Map<String, String> Rolex) {
    	String email = Rolex.get("email");
    	System.out.print(email);
        return Service.getRolex(email);
    }
   
   

}
