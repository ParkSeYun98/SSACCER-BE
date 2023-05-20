package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.service.UserService;
import com.ssafy.ssaccer.util.JwtUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@ApiModel(value="User RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

	private final JwtUtil jwtUtil;

    private final UserService uService;
    
//	@ApiOperation(value = "로그인", notes = "token 없이 로그인 / user 객체를 받음")
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
//
//		try {
//			User loginUser = uService.login(user);
//
//			if(loginUser == null)
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//
//			session.setAttribute("loginUser", loginUser);
//			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//		} catch(Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	
	@ApiOperation(value = "로그인", notes = "jwt 활용 / user 객체를 받음")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		HttpStatus status = null;

		// user를 이용해서 service -> dao -> db를 통해 실제 유저인지 확인해야하는데 그거는 직접 하셈
		User loginUser = uService.login(user);

		if(loginUser == null)
			throw new IllegalArgumentException("로그인 유저 검사했는데 null로 나옴");

		// 아이디가 널이 아니거나 길이가 있거나
		try {
			if(user.getUserId() != null || user.getUserId().length() > 0) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("loginUser", loginUser);
				result.put("message", "SUCCESS");
				status = HttpStatus.ACCEPTED;
			}
			else {
				result.put("message", "FAIL");
				status = HttpStatus.NO_CONTENT;
			}
		} catch(UnsupportedEncodingException e) {
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String,Object>>(result, status);
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
	@DeleteMapping("/quit/{userId}")
	public ResponseEntity<?> quit(@PathVariable String userId) {

		try {
			int result = uService.deleteUserByUserId(userId);

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
