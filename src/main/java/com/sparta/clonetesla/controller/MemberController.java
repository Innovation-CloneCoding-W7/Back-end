package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.request.LoginRequestDto;
import com.sparta.clonetesla.controller.request.MemberRequestDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.UserDetailsImpl;
import com.sparta.clonetesla.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public ResponseDto<?> signup(@RequestBody @Valid MemberRequestDto requestDto) {
//        System.out.println(requestDto.getMbti());
        return memberService.signup(requestDto);
    }

    @PostMapping("/member/login")
    public ResponseDto<?> login(@RequestBody @Valid LoginRequestDto requestDto, HttpServletResponse response){
        System.out.println(requestDto.getNickname());
        return memberService.login(requestDto,response);
    }

    @PostMapping("/member/logout")
    public ResponseDto<?> logout(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return memberService.logout(userDetails);
    }
}