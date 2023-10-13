package com.example.restdocs.member.service;

import com.example.restdocs.member.model.dto.request.MemberJoinRequest;
import com.example.restdocs.member.model.entity.Member;
import com.example.restdocs.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

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

    public Member findByMemberId(Long memberId){

        return memberRepository.findByMemberId(memberId);

    }

}
