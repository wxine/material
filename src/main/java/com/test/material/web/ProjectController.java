package com.test.material.web;

import java.util.Date;
import java.util.UUID;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.material.domain.Material;
import com.test.material.domain.Project;
import com.test.material.domain.Record;
import com.test.material.repository.ProjectDao;

@Controller
public class ProjectController {
	@Resource
	private ProjectDao projectDao;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String view(Model m) {
		List<Project> list = projectDao.findAll();
		m.addAttribute("pjlist", list);
		return "project";
	}

	@RequestMapping(value = "/find_project", method = RequestMethod.GET)
	public String findProjectRecord(Model m, String id) {
		Project pj = projectDao.findById(id);
		m.addAttribute("aaa", pj.getProjectset());
		/*for (Record record : pj.getProjectset()) {
			System.out.println(record.getMaterial().getId());
		}*/
		return "projectset";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Project project) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid Project project, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		Date nowtime = new Date();
		project.setCtime(nowtime);
		project.setId(UUID.randomUUID().toString().replace("-", ""));
		projectDao.save(project);
		return "project";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpsession,String pname,String password){
		List<Project> result = projectDao.select(pname, password);
		if (!(result.isEmpty())) {
			httpsession.setAttribute("project", result.get(0));
			System.out.println("用户名:"+result.get(0).getPname());
			return "redirect:/index";
		}
		return "login";
	}
}
