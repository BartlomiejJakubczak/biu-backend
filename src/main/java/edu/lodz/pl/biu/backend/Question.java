package edu.lodz.pl.biu.backend;

import edu.lodz.pl.biu.backend.security.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String topic;

    @NotBlank
    @Size(max = 150)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Question(String topic, String text, User user) {
        this.topic = topic;
        this.text = text;
        this.user = user;
    }

}
