package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Member {
    private String username;
    private Long id;
    private int age;

    public Member(){}

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
