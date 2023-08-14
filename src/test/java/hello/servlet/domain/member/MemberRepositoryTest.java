package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void memberRepositorySave(){
        //given
        Member member = new Member("Hong Gil Dong", 30);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member byId = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(byId.getUsername()).isEqualTo("Hong Gil Dong");
    }

    @Test
    void findAll(){
        memberRepository.save(new Member("홍길동", 30));
        memberRepository.save(new Member("홍길순", 45));

        List<Member> allMember = memberRepository.findAll();

        allMember.forEach(
                e -> System.out.println(e.getUsername())
        );

        Assertions.assertThat(allMember.size()).isEqualTo(2);
    }
}
