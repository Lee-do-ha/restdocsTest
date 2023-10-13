package com.example.restdocs.member.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberJoinRequest {

    private String id;
    private String password;
    private String name;

}
