package com.gdsc.waffle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private LocalDateTime createdDateTime;

    @Column
    @NotNull
    private String content;

    @Column
    @NotNull
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity categoryEntity;
}
