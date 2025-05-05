package goj.holy365.api.infrastructure.repository;

import org.springframework.stereotype.Repository;

import goj.holy365.api.domain.interfaces.MemberRepository;
import goj.holy365.api.domain.model.Member;
import goj.holy365.api.infrastructure.mapper.MemberMapper;
import goj.holy365.api.infrastructure.persistence.MemberJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
	private final MemberJpaRepository memberJpaRepository;

	@Override
	public Long createMember(Member member) {
		return memberJpaRepository.save(MemberMapper.toEntity(member)).getId();
	}
}
