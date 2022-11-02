package com.gdsc.waffle.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}
