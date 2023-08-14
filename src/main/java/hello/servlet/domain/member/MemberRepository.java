package hello.servlet.domain.member;

import java.util.*;

public class MemberRepository {
    
    //싱글톤이 보장되기때문에 멤버변수 static이 없어도 상관없음
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository(){};

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
