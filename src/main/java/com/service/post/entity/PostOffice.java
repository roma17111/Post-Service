package com.service.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "post_offices")
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    long id;

    @Column(name = "index",
            nullable = false,
            unique = true,
            length = 10)
    String index;

    @Column(name = "name",
            nullable = false,
            length = 20)
    String name;

    @Column(name = "address",
            nullable = false,
            unique = true,
            length = 60)
    String address;

}
