package bookapp.repository;

import bookapp.annotation.Bean;
import bookapp.domain.Member;

@Bean
public class MemberRepository extends SimpleRepository<Member, Long> {

}
