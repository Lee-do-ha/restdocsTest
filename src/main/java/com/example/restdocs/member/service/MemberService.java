package com.example.restdocs.member.service;

import com.example.restdocs.member.model.dto.request.MemberJoinRequest;
import com.example.restdocs.member.model.dto.request.MemberUpdateRequest;
import com.example.restdocs.member.model.entity.Member;
import com.example.restdocs.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberJoinRequest request){

        memberRepository.findById(request.getId())
                        .ifPresent((member) -> {
                            throw new RuntimeException("중복 회원가입");
                        });

        memberRepository.save(Member.builder()
                        .id(request.getId())
                        .password(request.getPassword())
                        .name(request.getName())
                .build());

    }

    @Transactional
    public Member findById(String id){

        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));

    }

    @Transactional
    public void update(MemberUpdateRequest request) {

        memberRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다."))
                .setPassword(request.getPassword());

    }
}
