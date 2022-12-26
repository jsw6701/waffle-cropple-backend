package com.gdsc.waffle.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
//@Table(name = "todos")
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

    //@ManyToOne
    //@JoinColumn(name = "category")
    //private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "todoEntity")
    private List<CategoryEntity> categoryEntityList = new ArrayList<>();
}
