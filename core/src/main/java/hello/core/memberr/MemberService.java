package hello.core.memberr;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
