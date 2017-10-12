package may.i.jhq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import may.i.jhq.domain.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
	
	

}
