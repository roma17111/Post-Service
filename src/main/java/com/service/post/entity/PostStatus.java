package com.service.post.entity;

import com.service.post.entity.enums.TypeOfOperations;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_statuses")
public class PostStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    long id;

    @Column(name = "date", nullable = false)
    LocalDateTime date;

    @Column(name = "type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    TypeOfOperations type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_office",
            referencedColumnName = "office_id",
            nullable = false)
    PostOffice postOffice;

}
