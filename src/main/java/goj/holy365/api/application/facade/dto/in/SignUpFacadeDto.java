package goj.holy365.api.application.facade.dto.in;

import goj.holy365.api.domain.service.dto.in.CreateMemberServiceDto;

public record SignUpFacadeDto(
	String name,
	String email,
	String password
) {
	public CreateMemberServiceDto toServiceDto(String encryptedPassword) {
		return new CreateMemberServiceDto(
			name,
			email,
			encryptedPassword
		);
	}
}
