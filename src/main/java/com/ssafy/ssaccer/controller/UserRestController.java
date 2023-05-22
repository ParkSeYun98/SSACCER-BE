package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.service.UserService;
import com.ssafy.ssaccer.util.JwtUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value="User RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

	private final JwtUtil jwtUtil;

	private final UserService uService;

	private final ResourceLoader resLoader;

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

	@ApiOperation(value = "유저 목록 리스트")
	@GetMapping("/read/list")
	public ResponseEntity<?> getUserList() {

		try {
			List<User> userList = uService.readUserList();

			if(userList != null)
				return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "회원 이미지 업로드")
	@PutMapping("/uploadimage/{userSeq}")
	public ResponseEntity<?> uploadImage(@PathVariable int userSeq, @RequestParam("img") MultipartFile file) {

		try {
			User user = null;

			if(file != null && file.getSize() > 0) {
				Resource res = resLoader.getResource("classpath:static/resources/upload");

				if(!res.getFile().exists())
					res.getFile().mkdir();

				List<User> list = uService.readUserList();

				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getUserSeq() == userSeq)
						user = list.get(i);
				}

				if(user != null) {
//					user.setImg(file.getOriginalFilename());
					user.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
					user.setOrgimg(file.getOriginalFilename());

					file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImg()));
				}
			}

			int result = uService.updateUser(user);

			if(result != 0) {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/display")
	public ResponseEntity<Resource> display(@RequestParam("userSeq") String userSeq) throws IOException {
		Resource res = resLoader.getResource("classpath:static/resources/upload");
		User user = new User();
		List<User> list = uService.readUserList();

		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUserSeq() == Integer.parseInt(userSeq))
				user = list.get(i);
		}
		String path = res.getFile().getCanonicalPath() + "/" + user.getImg();
		Resource resource = new FileSystemResource(path);
		System.out.println(user.getImg());

		if(!resource.exists())
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);

		HttpHeaders header = new HttpHeaders();
		Path filePath = null;

		try{
			filePath = Paths.get(path);
			header.add("Content-type", Files.probeContentType(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {

		e.printStackTrace();

		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}