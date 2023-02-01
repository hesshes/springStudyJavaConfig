package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	// spring 4.3 이상에서 단일 파라미터를 받는 생성자의 경우 필요한 파라미터를 자동으로 주입 가능
	// 즉, lombok 사용시 AllArgsConstructor 어노테이션을 사용한 경우 autowired 생략 가능.
	
	@Autowired 
	//@Setter (onMethod_ = @Autowired)
	private BoardService boardService;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list=============================");
		model.addAttribute("list", boardService.getList());
	}
	
}
