package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@ApiModel(value="User RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService uService;

	@ApiOperation(value = "로그인", notes = "token 없이 로그인 / user 객체를 받음")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {

		try {
			User loginUser = uService.login(user);

			if(loginUser == null)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {

		try {
			session.removeAttribute("loginUser");
//		session.removeAttribute("access-token");

			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원가입")
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {

		try {
			int result = uService.createUser(user);

			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원 정보 수정")
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {

		try {
			int result = uService.updateUser(user);

			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "회원 탈퇴")
	@DeleteMapping("/quit/{userSeq}")
	public ResponseEntity<?> quit(@PathVariable int userSeq) {

		try {
			int result = uService.deleteUserByUserSeq(userSeq);

			if(result != 0)
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원 아이디로 특정 회원 조회")
	@GetMapping("/read/{userSeq}")
	public ResponseEntity<?> selectUserById(@PathVariable int userSeq) {

		try {
			User user = uService.readUserByUserSeq(userSeq);

			if(user != null)
				return new ResponseEntity<User>(user, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {

		e.printStackTrace();

		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
