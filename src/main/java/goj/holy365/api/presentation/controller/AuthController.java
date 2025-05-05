package goj.holy365.api.presentation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goj.holy365.api.application.facade.AuthFacade;
import goj.holy365.api.presentation.controller.dto.in.SignUpRequest;
import goj.holy365.common.dto.response.ApiResponse;
import goj.holy365.common.dto.response.LongIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth", description = "Auth API")
public class AuthController {
	private final AuthFacade authFacade;

	@PostMapping("/sign-up")
	@Operation(summary = "member sign-up", description = "회원 가입 신청")
	public ApiResponse<LongIdResponse> signUp(@Validated @RequestBody SignUpRequest request) {
		return ApiResponse.success(new LongIdResponse(authFacade.signUp(request.toFacadeDto())));
	}
}
