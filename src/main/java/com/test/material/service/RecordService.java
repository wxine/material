package com.test.material.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.test.material.domain.Material;
import com.test.material.domain.Project;
import com.test.material.domain.Record;
import com.test.material.repository.MaterialDao;
import com.test.material.repository.RecordDao;

@Service
public class RecordService {
	@Resource
	private RecordDao recordDao;
	@Resource
	private MaterialDao materialDao;

	public void save(Project project, Record record, HttpSession httpsession, String materialid) {
		System.out.println(httpsession.getAttribute("project"));
		if (httpsession.getAttribute("project") != null) {
			Material material = materialDao.findById(materialid);
			Date nowtime = new Date();
			record.setRecordctime(nowtime);
			record.setId(UUID.randomUUID().toString().replace("-", ""));
			record.setProject((Project) httpsession.getAttribute("project"));
			record.setMaterial(material);
			recordDao.save(record);
		} else {
			System.out.println("没有用户");
		}
	}

	public void seondsave(String materialid) {
		Material material = materialDao.findById(materialid);
		Record record = recordDao.findBymaterial(material);
		Date nowtime = new Date();
		record.setSecondtime(nowtime);
		recordDao.update(record);
	}

}
