package dongguknuri.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Builder;

@Builder
public record BoardResponseDto(
        @JsonProperty("board_id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description
) implements Serializable {
    public static BoardResponseDto of(
            final Long id,
            final String name,
            final String description
    ) {
        return BoardResponseDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }
}
