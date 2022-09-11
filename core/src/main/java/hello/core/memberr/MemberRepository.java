package hello.core.memberr;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
