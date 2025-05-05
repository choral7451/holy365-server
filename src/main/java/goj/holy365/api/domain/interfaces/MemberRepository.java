package goj.holy365.api.domain.interfaces;

import goj.holy365.api.domain.model.Member;

public interface MemberRepository {
	Long createMember(Member member);
}
