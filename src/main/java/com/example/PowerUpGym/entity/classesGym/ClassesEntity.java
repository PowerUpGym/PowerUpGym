package com.example.PowerUpGym.entity.classesGym;


import com.example.PowerUpGym.entity.users.AdminEntity;
import com.example.PowerUpGym.entity.users.PlayersEntity;
import com.example.PowerUpGym.entity.users.TrainerEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mst_class")
public class ClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "schedule", nullable = false)
    private LocalDate schedule;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "class_name", nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainer;

    @ManyToMany(mappedBy = "enrolledClasses")
    private List<PlayersEntity> enrolledPlayers;

    @ManyToOne //
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

}
