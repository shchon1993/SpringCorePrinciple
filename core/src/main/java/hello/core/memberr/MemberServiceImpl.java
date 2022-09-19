package hello.core.memberr;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //MemberRepository에 뭐가 들어갈지는 생성자를 통해서 주입
    //추상화에만 의존 DIP, 구현체에 대한 정보는 아예 모름, 생성자를 통해 어떤 구현 객체가 들어올지 모른다.
    //설계 변경으로 MemberServiceImpl은 MemmoryMemberRepository를 의존하지 않는다. DIP 지킴
    //MemberRepository 인터페이스에만 의존
    //실행에만 의존할 수 있다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //호출하면 다형성에 의해 MemmoryMemberRepository 있는 save가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
