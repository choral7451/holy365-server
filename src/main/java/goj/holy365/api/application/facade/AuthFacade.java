package goj.holy365.api.application.facade;

import org.springframework.stereotype.Component;

import goj.holy365.api.application.facade.dto.in.SignUpFacadeDto;
import goj.holy365.api.domain.service.MemberService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthFacade {

	private final MemberService memberService;

	public Long signUp(SignUpFacadeDto dto) {
		String encryptedPassword = memberService.encryptPassword(dto.password());
		return memberService.createMember(dto.toServiceDto(encryptedPassword));
	}
}
