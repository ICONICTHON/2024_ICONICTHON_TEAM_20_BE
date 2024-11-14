package dongguknuri.service;

import dongguknuri.domain.board.Board;
import dongguknuri.dto.request.CreateBoardDto;
import dongguknuri.dto.response.BoardResponseDto;
import dongguknuri.repository.board.BoardRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getAllBoards() {
        return boardRepository.findAll().stream()
                .map(board -> BoardResponseDto.of(
                        board.getBoardId(),
                        board.getName(),
                        board.getDescription()
                )).collect(Collectors.toList());
    }

    @Transactional
    public boolean createBoard(CreateBoardDto createBoardDto){
        boardRepository.save(Board.builder()
                .name(createBoardDto.name())
                .description(createBoardDto.description())
                .build());

        return Boolean.TRUE;
    }
}
