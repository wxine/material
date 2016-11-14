package com.test.material.web;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.material.domain.Material;
import com.test.material.domain.PageUtil;
import com.test.material.domain.Project;
import com.test.material.domain.Record;
import com.test.material.repository.MaterialDao;
import com.test.material.repository.RecordDao;

@Controller
public class MaterialController {
	@Resource
	private MaterialDao materialDao;
	@Resource
	private RecordDao recordDao;

	@RequestMapping(value = "/index", method = RequestMethod.GET) // 翻页查询
	public String view(Model m, Material material,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, String keyword) {
		if (page < 1) {
			page = 1;
		}
		materialDao.Infopage(keyword);
		PageUtil pageUtil = materialDao.queryByPage(page, keyword);
		m.addAttribute("pageUtil", pageUtil);
		m.addAttribute("keyword", keyword);
		return "index";
	}

	@RequestMapping(value = "/material_save", method = RequestMethod.POST) // 保存
	public String save(Material material) {
		Date nowtime = new Date();
		material.setCtime(nowtime);
		material.setId(UUID.randomUUID().toString().replace("-", ""));
		materialDao.save(material);
		return "redirect:/index";
	}

	@RequestMapping(value = "/material_delete", method = RequestMethod.GET) // 删除
	public String Delete(String id) {
		Material material = materialDao.findById(id);
		materialDao.delete(material);
		return "redirect:/index";
	}

	@RequestMapping(value = "/material_update", method = RequestMethod.GET) // 查数据到页面
	public String Update(Model m, String id) {
		Material material = materialDao.findById(id);
		m.addAttribute("update", material);
		return "material_update";
	}

	@RequestMapping(value = "/material_updates", method = RequestMethod.POST) // 修改后保存
	public String Merge(String id, String name, String projectname, String username, String location,
			String parameter) {
		Material material = materialDao.findById(id);
		Date nowtime = new Date();
		material.setCtime(nowtime);
		material.setName(name);
		material.setParameter(parameter);
		material.setLocation(location);
		materialDao.update(material);
		return "redirect:/index";
	}

}
