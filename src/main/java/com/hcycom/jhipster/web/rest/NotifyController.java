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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.annotation.Timed;
import com.hcycom.jhipster.domain.Notify;
import com.hcycom.jhipster.domain.SenderNotify;
import com.hcycom.jhipster.service.userService;
import com.hcycom.jhipster.service.DTO.MessageLogDTO;
import com.hcycom.jhipster.service.mapper.NotifyMapper;
import com.hcycom.jhipster.service.mapper.SenderNotifyMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = { "消息通知管理" }, description = "消息通知管理接口")
public class NotifyController {
	private final Logger log = LoggerFactory.getLogger(NotifyController.class);

	@Autowired
	private NotifyMapper notifyMapper;

	@Autowired
	private SenderNotifyMapper senderNotifyMapper;
	
	@Autowired
	private userService userService;

	@RequestMapping(value = "/Notify", method = RequestMethod.POST)
	@Timed
	@ApiOperation(value = "添加消息通知", notes = "传入消息通知表参数，创建消息通知", httpMethod = "POST")
	public ResponseEntity<Map<String, Object>> Notify(@RequestBody MessageLogDTO message) {
		Map<String, Object> map = new HashMap<String, Object>();
		Notify notify = new Notify();
		notify.setTime(message.getTime());
		notify.setTitle(message.getTitle());
		notify.setContent(message.getContent());
		notify.setUuid(message.getAddresseeuuid());
		notify.setSender(message.getSender());
		notify.setStatus(0);
		SenderNotify senderNotify = new SenderNotify();
		senderNotify.setTime(message.getTime());
		senderNotify.setTitle(message.getTitle());
		senderNotify.setContent(message.getContent());
		senderNotify.setUuid(message.getSenderuuid());
		senderNotify.setAddressee(message.getAddressee());
		int i = notifyMapper.addNotify(notify);
		i = senderNotifyMapper.addSenderNotify(senderNotify);
		if (i > 0) {
			map.put("msg", "消息通知添加成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "消息通知添加失败！");
			map.put("error_code", 0);
		}

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/SystemNotify", method = RequestMethod.POST)
	@Timed
	@ApiOperation(value = "添加系统消息通知", notes = "传入消息通知表参数，创建系统消息通知", httpMethod = "POST")
	public ResponseEntity<Map<String, Object>> SystemNotify(@RequestBody Notify notify) {
		Map<String, Object> map = new HashMap<String, Object>();
		String json=userService.allusers();
		JSONObject jsonObject=JSON.parseObject(json);
		notify.setSender("SystemNotify");
		notify.setStatus(0);
		if(jsonObject.getInteger("error_code")==1){
			JSONArray jsonArray=jsonObject.getJSONArray("allUser");
			int jslenth=jsonArray.size();
			for(int i=0;i<jslenth;i++){
				String id=jsonArray.getJSONObject(i).getString("id");
				notify.setUuid(id);
				notifyMapper.addNotify(notify);
			}
			map.put("msg", "系统消息通知添加成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "系统消息通知添加失败！");
			map.put("error_code", 0);
		}
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/Notify_delete", method = RequestMethod.DELETE)
	@Timed
	@ApiOperation(value = "删除消息通知", notes = "传入消息通知的id，删除此消息通知", httpMethod = "DELETE")
	public ResponseEntity<Map<String, Object>> Notify_delete(@RequestParam("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = notifyMapper.deleteNotify(id);
		if (i > 0) {
			map.put("msg", "消息通知删除成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "消息通知删除失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/SenderNotify_delete", method = RequestMethod.DELETE)
	@Timed
	@ApiOperation(value = "删除发件人消息", notes = "传入发件人消息的id，删除此发件人消息", httpMethod = "DELETE")
	public ResponseEntity<Map<String, Object>> SenderNotify_delete(@RequestParam("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = senderNotifyMapper.deleteSenderNotify(id);
		if (i > 0) {
			map.put("msg", "发件人消息删除成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "发件人消息删除失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/Notify_put", method = RequestMethod.PUT)
	@Timed
	@ApiOperation(value = "修改消息通知状态", notes = "传入消息通知id以及新的消息通知状态，根据id修改消息通知状态", httpMethod = "PUT")
	public ResponseEntity<Map<String, Object>> Notify_put(@RequestBody Notify notify) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = notifyMapper.updateNotify(notify);
		if (i > 0) {
			map.put("msg", "消息通知状态修改成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "消息通知状态修改失败！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/Notify_get", method = RequestMethod.GET)
	@Timed
	@ApiOperation(value = "获取用户消息通知详情", notes = "根据uuid获取消息通知详情", httpMethod = "GET")
	public ResponseEntity<Map<String, Object>> Notify_get(@RequestParam("uuid") String uuid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Notify> list = notifyMapper.findNotifyByUUID(uuid);
		if (list.size() > 0) {
			map.put("data", list);
			map.put("msg", "消息通知获取成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "消息通知获取失败或者为空！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/SenderNotify_get", method = RequestMethod.GET)
	@Timed
	@ApiOperation(value = "获取用户发件消息详情", notes = "根据uuid获取发件消息详情", httpMethod = "GET")
	public ResponseEntity<Map<String, Object>> SenderNotify_get(@RequestParam("uuid") String uuid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SenderNotify> list = senderNotifyMapper.findSenderNotifyByUUID(uuid);
		if (list.size() > 0) {
			map.put("data", list);
			map.put("msg", "发件消息获取成功！");
			map.put("error_code", 1);
		} else {
			map.put("msg", "发件消息获取失败或者为空！");
			map.put("error_code", 0);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/Notify_getcount", method = RequestMethod.GET)
	@Timed
	@ApiOperation(value = "获取用户未读消息数量", notes = "根据uuid获取消息通知详情", httpMethod = "GET")
	public ResponseEntity<Map<String, Object>> Notify_getcount(@RequestParam("uuid") String uuid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = notifyMapper.findNotifyCountByUUID(uuid);
		map.put("data", num);
		map.put("msg", "消息通知获取成功！");
		map.put("error_code", 1);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
