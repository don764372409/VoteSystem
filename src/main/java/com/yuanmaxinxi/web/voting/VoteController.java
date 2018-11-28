package com.yuanmaxinxi.web.voting;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuanmaxinxi.domain.voting.Voting;
import com.yuanmaxinxi.service.voting.VotingService;

/**
 * 
* @ClassName: VoteController
* @Description: TODO(投票相关)
* @author Liudan
* @date 2018年11月28日
*
 */
@RestController
@RequestMapping("/vote")
public class VoteController {
	@Autowired
    VotingService votingservice;
	
	@GetMapping("/votinglist")
	public List<Voting> votinglist(){
		return votingservice.selectAll();
	}
	

}
