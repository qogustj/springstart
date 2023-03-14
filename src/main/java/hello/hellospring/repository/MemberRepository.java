package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //optional은 자바8에 들어간 내용 null을 그대로 반환하는 것보다 optional로 감싸서 반환
    Optional<Member> findByid(Long id);
    Optional<Member> findByname(String name);
    List<Member> findAll();

}
