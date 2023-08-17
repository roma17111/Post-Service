package com.service.post.entity;

import com.service.post.entity.dto.PostRegisterDto;
import com.service.post.entity.enums.TypeOfPostDelivery;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@Entity
@Table(name = "posts")
@ToString(exclude = "statuses")
public class PostDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    long postId;

    @Column(name = "type_of_posts", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    TypeOfPostDelivery typeOfPost;

    @Column(name = "index_recieved", nullable = false, length = 8)
    String indexOfRecieved;

    @Column(name = "address_recieved", nullable = false, length = 50)
    String addressOfRecieved;

    @Column(name = "name", nullable = false, length = 20)
    String name;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<PostStatus> statuses;

    public void addStatusToPost(PostStatus status) {
        if (statuses == null) {
            statuses = new ArrayList<>();
        } else {
            statuses.add(status);
        }
    }


}
