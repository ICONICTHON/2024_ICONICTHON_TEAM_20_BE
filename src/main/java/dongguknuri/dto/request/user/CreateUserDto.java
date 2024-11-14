package dongguknuri.dto.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Builder;

@Builder
public record CreateUserDto(
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("department") String department,
        @JsonProperty("mbti") String mbti,
        @JsonProperty("personality") String personality
) implements Serializable {
    public static CreateUserDto of(
            final String name,
            final String email,
            final String password,
            final String department,
            final String mbti,
            final String personality
    ) {
        return CreateUserDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .department(department)
                .mbti(mbti)
                .personality(personality)
                .build();
    }
}
