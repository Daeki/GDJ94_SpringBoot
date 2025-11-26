package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public void list(@RequestParam(defaultValue = "1") Long page, Model model)throws Exception{
		Pager pager = new Pager();
		log.info("호출전 : {}", pager.getTotalPage());
		List<NoticeDTO> list= noticeService.list(page, pager);
		log.info("호출후 : {}", pager.getTotalPage());
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
	}

}
