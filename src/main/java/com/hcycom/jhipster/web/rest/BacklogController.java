package com.hcycom.jhipster.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.jhipster.domain.Backlog;
import com.hcycom.jhipster.service.mapper.BacklogMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = { "待办事宜管理" }, description = "待办事宜管理接口")
public class BacklogController {
	private final Logger log = LoggerFactory.getLogger(BacklogController.class);

	@Autowired
	private BacklogMapper backlogMapper;

	@RequestMapping(value = "/Backlog", method = RequestMethod.POST)
	@Timed
	@ApiOperation(value = "添加待办事宜", notes = "传入待办事宜表参数，创建待办事宜", httpMethod = "POST")
	public ResponseEntity<Map<String, Object>> Backlog(@RequestBody Backlog backlog) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i=backlogMapper.addBacklog(backlog);
		if(i>0){
			map.put("msg", "待办事宜添加成功！");
			map.put("error_code", 1);
		}else{
			map.put("msg", "待办事宜添加失败！");
			map.put("error_code", 0);
		}
			
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/Backlog_delete", method = RequestMethod.DELETE)
	@Timed
	@ApiOperation(value = "删除待办事宜", notes = "传入待办事宜的id，删除此待办事宜", httpMethod = "DELETE")
	public ResponseEntity<Map<String, Object>> Backlog_delete(@RequestParam("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i=backlogMapper.deleteBacklog(id);
		if(i>0){
			map.put("msg", "待办事宜删除成功！");
			map.put("error_code", 1);
		}else{
			map.put("msg", "待办事宜删除失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}


	@RequestMapping(value = "/Backlog_put", method = RequestMethod.PUT)
	@Timed
	@ApiOperation(value = "修改待办事宜内容", notes = "传入待办事宜id以及新的待办事宜内容，根据id修改待办事宜内容", httpMethod = "PUT")
	public ResponseEntity<Map<String, Object>> Backlog_put(@RequestBody Backlog backlog) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i=backlogMapper.updateBacklog(backlog);
		if(i>0){
			map.put("msg", "待办事宜内容修改成功！");
			map.put("error_code", 1);
		}else{
			map.put("msg", "待办事宜内容修改失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Backlog_putStatus", method = RequestMethod.PUT)
	@Timed
	@ApiOperation(value = "修改待办事宜状态", notes = "传入待办事宜id以及待办事宜状态，根据id修改待办事宜状态", httpMethod = "PUT")
	public ResponseEntity<Map<String, Object>> Backlog_putStatus(@RequestBody Backlog backlog) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i=backlogMapper.updateBacklogCheckbox(backlog);
		if(i>0){
			map.put("msg", "待办事宜状态修改成功！");
			map.put("error_code", 1);
		}else{
			map.put("msg", "待办事宜状态修改失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}



	@RequestMapping(value = "/Backlog_get", method = RequestMethod.GET)
	@Timed
	@ApiOperation(value = "获取用户待办事宜详情", notes = "根据uuid获取待办事宜详情", httpMethod = "GET")
	public ResponseEntity<Map<String, Object>> Backlog_get(@RequestParam("uuid") String uuid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Backlog> list=backlogMapper.findBacklogByUUID(uuid);
		if(list.size()>0){
			map.put("data", list);
			map.put("msg", "待办事宜获取成功！");
			map.put("error_code", 1);
		}else{
			map.put("msg", "待办事宜获取失败或者为空！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
