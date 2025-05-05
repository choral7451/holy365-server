package goj.holy365.api.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import goj.holy365.api.domain.interfaces.MemberRepository;
import goj.holy365.api.domain.model.Member;
import goj.holy365.api.domain.service.dto.in.CreateMemberServiceDto;
import goj.holy365.common.enums.ApiErrorType;
import goj.holy365.common.exception.CoreException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final PasswordEncoder passwordEncoder;
	private final MemberRepository memberRepository;

	public Long createMember(CreateMemberServiceDto dto) {
		return memberRepository.createMember(new Member(
			dto.name(),
			dto.email(),
			dto.password()
		));
	}

	public String encryptPassword(String password) {
		if (!isValidPassword(password)) {
			throw new CoreException(ApiErrorType.INVALID_PASSWORD);
		}

		return passwordEncoder.encode(password);
	}

	public Boolean isValidPassword(String password) {
		if (password == null || password.length() < 8)
			return false;

		boolean hasLetter = password.matches(".*[a-zA-Z].*");
		boolean hasDigit = password.matches(".*\\d.*");
		boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>\\[\\]\\\\/~`_+=;'\\-].*");

		return hasLetter && hasDigit && hasSpecial;
	}
}
