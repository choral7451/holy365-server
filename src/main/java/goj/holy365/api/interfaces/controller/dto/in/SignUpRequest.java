package goj.holy365.api.interfaces.controller.dto.in;

import goj.holy365.api.application.facade.dto.in.SignUpFacadeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignUpRequest(
	@Schema(description = "이름", example = "임성준")
	@NotBlank String name,

	@Schema(description = "이메일", example = "holy@holy365.com")
	@NotBlank @Email String email,

	@Schema(description = "비밀번호", example = "a123456!")
	@NotBlank String password
) {
	public SignUpFacadeDto toFacadeDto() {
		return new SignUpFacadeDto(name, email, password);
	}
}
