package com.test.material.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.material.domain.Project;
import com.test.material.domain.Record;
import com.test.material.service.RecordService;

@Controller
public class RecordController {
	@Resource
	private RecordService recordService;

	@RequestMapping(value = "/record_save", method = RequestMethod.GET)
	public String save(Project project, Record record, HttpSession httpsession, String materialid) {
		recordService.save(project, record, httpsession, materialid);
		return "redirect:/index";
	}

	@RequestMapping(value = "/record_seondsave", method = RequestMethod.GET)
	public String secondsave(String materialid) {
		recordService.seondsave(materialid);
		return "redirect:/project";
	}

}
