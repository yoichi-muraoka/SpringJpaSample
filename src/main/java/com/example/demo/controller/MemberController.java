package com.example.demo.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberType;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberTypeRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberTypeRepository memberTypeRepository;
	
	@Autowired
	private HttpSession session;
	
	// 会員一覧表示
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		return "list";
	}
	
	// 会員種別による絞り込み表示
	@GetMapping("/list/{typeId}")
	public String listByType(@PathVariable Integer typeId,
			Model model) {
		MemberType mt = memberTypeRepository.findById(typeId).orElse(null);
		model.addAttribute("typeName", mt.getName());
		model.addAttribute("members", mt.getMembers());
		return "listByType";
	}
	
	// 会員IDに基づく個別表示
	@GetMapping("/show/{id}")
	public String show(@PathVariable Integer id,
			Model model) {
		Optional<Member> member = memberRepository.findById(id);
		model.addAttribute("member", member.orElse(new Member()));
		return "show";
	}
	
	// 会員情報の追加・編集
	@GetMapping("/save")
	public String save(
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		Member member;
		if(id == null) {		
			MemberType mt = new MemberType();
			mt.setId(1);
			member = new Member();
			member.setMemberType(mt);
		}
		else {
			member = memberRepository.findById(id).orElse(new Member());
			session.setAttribute("created", member.getCreated());
		}
		
		model.addAttribute(member);
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Member member) {
		Date created = new Date();
		if(session.getAttribute("created") != null) {
			created = (Date) session.getAttribute("created");
			session.removeAttribute("created");
		}
		member.setCreated(created);
		memberRepository.save(member);
		return "redirect:/list";
	}
	
	// 会員情報の削除
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		memberRepository.deleteById(id);
		return "redirect:/list";
	}

}
