package dongguknuri.repository.board;

import dongguknuri.domain.board.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
