package goj.holy365.api.domain.service.dto.in;

public record CreateMemberServiceDto(
	String name,
	String email,
	String password
) {
}
