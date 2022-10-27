package com.gdsc.waffle.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate start_Date;

    @Column
    @NotNull
    private LocalDate end_Date;

    @Column
    @NotNull
    private String content;

    @Column
    @NotNull
    private Boolean status;
}
