package com.gdsc.waffle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CategoryEntity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    @NotNull
    private String categoryTitle;

    @OneToMany(mappedBy = "categoryEntity")
    @JsonIgnore
    private List<TodoEntity> todoEntityList = new ArrayList<>();

}
