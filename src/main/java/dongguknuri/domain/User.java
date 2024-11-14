package dongguknuri.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "department")
    private String department;

    @Column(name = "mbti")
    private String mbti;

    @Column(name = "personality")
    private String personality;

    @Column(name = "points")
    private int points;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserClub> userClubs = new ArrayList<>();

    @Builder
    public User(String name, String email, String password, String department, String mbti, String personality,
                int points) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.mbti = mbti;
        this.personality = personality;
        this.points = points;
    }

    public void addClub(Club club) {
        UserClub userClub = new UserClub(this, club);
        userClubs.add(userClub);
        club.getUserClubs().add(userClub);
    }
}
