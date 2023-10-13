package com.example.restdocs.member.controller;

import com.example.restdocs.member.model.dto.request.MemberJoinRequest;
import com.example.restdocs.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberJoinRequest request){

        try {

            memberService.save(request);

            return ResponseEntity.ok("회원가입 성공");

        } catch (RuntimeException e){

            return ResponseEntity.status(401).body("회원가입 중복 에러");

        }

    }

    @GetMapping("/detail/{memberId}")
    public ResponseEntity<?> detail(@PathVariable("memberId") Long memberId){

        return ResponseEntity.ok(memberService.findByMemberId(memberId));

    }

}
