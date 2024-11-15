package dongguknuri.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalTime;
import lombok.Builder;

@Builder
public record CourseResponseDto(
        @JsonProperty("course_id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("professor") String professor,
        @JsonProperty("day") String day,
        @JsonProperty("start_time")LocalTime startTime,
        @JsonProperty("end_time") LocalTime endTime,
        @JsonProperty("user_id") Long userId
        ) implements Serializable {
    public static CourseResponseDto of(
            final Long id,
            final String name,
            final String description,
            final String professor,
            final String day,
            final LocalTime startTime,
            final LocalTime endTime,
            final Long userId
    ) {
        return CourseResponseDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .professor(professor)
                .day(day)
                .startTime(startTime)
                .endTime(endTime)
                .userId(userId)
                .build();
    }
}
