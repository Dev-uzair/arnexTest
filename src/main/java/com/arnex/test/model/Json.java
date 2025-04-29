package com.arnex.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Json {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jsonId;

    @Column(columnDefinition = "json")
    private String jsonData;
}
