package com.bsys.service;

import org.springframework.stereotype.Service;

import com.bsys.repositories.TransRepo;
import com.bsys.repositories.UserRepo;
import com.bsys.models.Transactions;
import com.bsys.models.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserService {
	@Autowired
	private UserRepo Repo;
	@Autowired
	private TransRepo orepo;
	
    public boolean deleteStaff(int id) {
        if (Repo.findById(id).isPresent()) {
            Repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public List<User> getAllStaff() {
        return Repo.findAll();
    }
    
    //user signUp

	public String SignUpx(User staffx) {
        String email = staffx.getEmail();
        User staffxAuth = Repo.findByEmail(email);
        if (staffxAuth == null) {
            Repo.save(staffx);
            return "Signup Successful !";
        } else {
            if (staffxAuth.getEmail().equals(email)) {
                return "Email ID Already Exists";
            } else {
                return "Invalid Email ID";
            }
        }
    } 
	
	//User Login
	
	public String Loginx(String email, String pwd) {
		User userx = Repo.findByEmail(email);
		if (userx == null) {
			return "Invalid Email !";
		} else {
			if (userx.getPwd().equals(pwd)) {
				return "Login Successful !";
			} else {
				return "Invalid Password";
			}
		}
	}
	
	
	//Create Transactions
	
	public Transactions createOrder(Transactions ord) {
		return orepo.save(ord);
	}
	
	//get Order
	
	public List<Transactions> getAllOrder() {
        return orepo.findAll();
    }
	
	//delete order
	  public String deleteOrderById(int Id)
	  {
	  	orepo.deleteById(Id);
	  	return "Order deleted !";

	  }
	  
	  //Get Role
	  
	  public String getRolex(String email) {
		  User userx = Repo.findByEmail(email);
		  return userx.getRole();
	  }
}
