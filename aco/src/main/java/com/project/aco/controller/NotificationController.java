package com.project.aco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aco.dto.Notify;
import com.project.aco.service.TeamService;

@Controller
@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TeamService teamService;
	
	@PostMapping
	public void notifyTeam(@RequestBody Notify notify) {
		logger.info("IN notifyTeam :{}", notify);
		teamService.notify(notify);
	}

}
