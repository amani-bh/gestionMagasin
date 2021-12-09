package tn.esprit.magasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.magasin.entity.AuthRequest;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.repositories.IClientRepository;
import tn.esprit.magasin.services.IClientService;
import tn.esprit.magasin.utils.JwtUtil;

@RestController
public class WelcomeController {
	@Autowired
	IClientService service;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody Client authRequest) throws Exception {
        try {
        	System.out.println(authRequest);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
    @PostMapping("/registration") 
    public String createNewUser( @RequestBody Client user) throws Exception { 
    	System.out.println(user);
    	String msg="";
    	Client userExists = service.getByUserName(user.getUserName()); 
    	if (userExists != null) {
    		msg="There is already a user registered with the user name provided"; 
    		} else { 
    			service.addClient(user);
    		msg="OK";
    		} 
    	return msg; 
    		}
    
}
