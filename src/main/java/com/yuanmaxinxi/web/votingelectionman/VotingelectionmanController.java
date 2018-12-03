package com.yuanmaxinxi.web.votingelectionman;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yuanmaxinxi.service.votingelectionman.VotingelectionmanService;

@Controller
@RequestMapping("/votingelection")
public class VotingelectionmanController {
	
	@Autowired
	VotingelectionmanService veservice;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Map<String, Object>> list = veservice.selectAll();
		model.addAttribute("list", list);
		return "votingelection/list";
	}

}
