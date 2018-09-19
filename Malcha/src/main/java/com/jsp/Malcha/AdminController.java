package com.jsp.Malcha;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.Malcha.dao.PeopleDao;
import com.jsp.Malcha.dto.People;
import com.google.appengine.api.datastore.Entity;

@Controller
public class AdminController {
	@RequestMapping("/") // URL 링크를 두 개 설정 가능
	public String homeForm(HttpServletRequest request, Model model) { 
		return "homeForm";
	}

	@RequestMapping("/login") // URL 링크를 두 개 설정 가능
	public String loginForm(HttpServletRequest request, Model model) { // request로 파라미터 가져오기
		return "loginForm";
	}

	@RequestMapping("/input") // URL 링크를 두 개 설정 가능
	public String InputForm(HttpServletRequest request, Model model) { // request로
																		// 파라미터
																		// 가져오기
		return "InputForm";
	}
	
	@RequestMapping("/map") // URL 링크를 두 개 설정 가능
	public String map(HttpServletRequest request, Model model) { // request로
																		// 파라미터
																		// 가져오기
		return "map";
	}

	@RequestMapping("/evacuateMap") // URL 링크를 두 개 설정 가능
	public String evacuateMap(HttpServletRequest request, Model model) { // request로
																		// 파라미터
																		// 가져오기
		return "evacuateMap";
	}

	

	@RequestMapping("/save_data") // URL 링크를 두 개 설정 가능
	public String SavedData(HttpServletRequest request, Model model) { // request로
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String number = request.getParameter("number");
		PeopleDao dao = new PeopleDao();
		dao.writeDao(id, age, number, name);		
		
		return "homeForm";
	}

	@RequestMapping("/people")
	@ResponseBody // json으로 반환
	public List<People> people() {
		PeopleDao dao = new PeopleDao();
		List<Entity> listEntity = dao.listDao();
		List<People> listDto = new ArrayList<People>();

		for (int i = 0; i < listEntity.size(); i++) {
			Entity en = listEntity.get(i);
			String age = (String) en.getProperty("age");
			String number = (String) en.getProperty("number");
			String name = (String) en.getProperty("name");

			listDto.add(new People("100", Integer.parseInt(age), Integer.parseInt(number), name));
		}
		return listDto;
	}

}