package hello.core.memberr;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemmoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member); //호출하면 다형성에 의해 MemmoryMemberRepository 있는 save가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
