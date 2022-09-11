package hello.core.memberr;

import java.util.HashMap;
import java.util.Map;

//DB가 구체화 되지 않았고, 정해지지 않았기 때문에 해당 인터페이스 사용. 메모리 회원 저장소.(회원 저장소 중 하나) 자세한건 PPT 도메인 설계 참조.
public class MemmoryMemberRepository implements MemberRepository{

    //저장소
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
