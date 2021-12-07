package com.earnlearn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.earnlearn.config.UserConverter;
import com.earnlearn.dao.RoleDaoInterface;
import com.earnlearn.dao.UserDaoInterface;
import com.earnlearn.dto.UserDTO;
import com.earnlearn.entity.Role;
import com.earnlearn.entity.User;
import com.earnlearn.serviceImpl.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDaoInterface;
	
	@Autowired
	RoleDaoInterface roleDaoInterface;

	@Autowired
	UserConverter userConverter;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public ResponseEntity<?> saveUser(User user) {
		user.setCreatedOn(new Date());
		user.setModifiedOn(new Date());
		userDaoInterface.save(user);
		
		/* Pass mail function to user*/
		
		sendEmail(user);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

		/*	Email Sending function */
	
	void sendEmail(User user) {
		String mailTo = user.getEmail();
        SimpleMailMessage msg = new SimpleMailMessage();	
        msg.setTo(mailTo);
        msg.setSubject("Daily Task Details Portal");
        msg.setText("Dear"+user.getName()+",\n"
        		+"\nYour Task code is generated on daily Work status portal,so now you can access the portal from your side./r/n"
        		+ "\nYou are requested to login portal from http://localhost:9999/loginForm and login./r/n"
        		+ "\nLogin crediential for your daily work status portal are as below:./r/n"
        		+ "\nUsername:"+user.getEmail()+"\n"
        				+ "\nPassword:"+user.getPassword()+"\n"
        						+ "\nRegarding any queries feel to free call us on 1234567879\r\n"
        						+ "\n\nThanks and Regards,"
        						+ "\nEarn And Learn");
       javaMailSender.send(msg);
	}
	
	@Override
	public ResponseEntity<?> updateUser(User user) {
		// TODO Auto-generated method stub
		user.setModifiedOn(new Date());
		userDaoInterface.saveAndFlush(user);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDaoInterface.delete(user);

	}

	@Override
	public List<UserDTO> getUserList() {
		return userConverter.entityToDto(userDaoInterface.findAll());
	}

	@Override
	public UserDTO getById(int id) {
		
		UserDTO response = null;
		Optional<User> userData = userDaoInterface.findById(id);
		if (userData.isPresent()) {
			UserDTO udata = userConverter.entityToDto(userData.get());
			response = udata;
			
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDaoInterface.deleteById(id);
	}

	@Override
	public List<UserDTO> getUsersByRole(int roleId) {
		// TODO Auto-generated method stub
		Role role = roleDaoInterface.findById(roleId).get();
		return userConverter.entityToDto(userDaoInterface.findAllByRole(role));
	}

}
