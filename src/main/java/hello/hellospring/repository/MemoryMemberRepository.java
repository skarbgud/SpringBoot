package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//@Repository // 애노테이션이 있으면 스프링 빈으로 자동 등록된다.
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //return store.get(id);   //null이 반환 될 수 있다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  //람다식
                .filter(member -> member.getName().equals(name))
                .findAny(); //하나라도 찾는 것
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
