package com.service.post.service;

import com.service.post.entity.PostDelivery;
import com.service.post.entity.PostOffice;
import com.service.post.entity.PostStatus;
import com.service.post.entity.dto.PostInfoDto;
import com.service.post.entity.dto.PostRegisterDto;
import com.service.post.entity.enums.TypeOfOperations;
import com.service.post.repository.PostOfficeRepository;
import com.service.post.repository.PostRepository;
import com.service.post.repository.PostStatusRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final PostStatusRepository postStatusRepository;


    @Override
    public PostInfoDto register(PostRegisterDto postRegister) {
        getIndexValidation(postRegister);
        PostOffice postOffice = registerPostOffice(postRegister);
        PostStatus status = addRegisterStatus(postOffice);
        PostDelivery postDelivery = registerPostDelivery(postRegister, status);
        postOfficeRepository.save(postOffice);
        postRepository.save(postDelivery);
        PostInfoDto info = getRegisterPostInfo(postOffice, postDelivery, status);
        log.info("Зарегистрирована посылка: " + info.toString());
        return info;

    }

    private PostInfoDto getRegisterPostInfo(PostOffice postOffice,
                                            PostDelivery postDelivery,
                                            PostStatus status) {
        return PostInfoDto.builder()
                .postId(postDelivery.getPostId())
                .typeOfPost(postDelivery.getTypeOfPost().name())
                .status(status.getType().name())
                .nameOfRecieved(postDelivery.getName())
                .indexOfRecieved(postDelivery.getIndexOfRecieved())
                .addressOfRecieved(postDelivery.getAddressOfRecieved())
                .nameOfOrg(postOffice.getName())
                .indexOfOrg(postOffice.getIndex())
                .addressOfOrg(postOffice.getAddress())
                .date(status.getDate().toString())
                .build();
    }

    private PostOffice registerPostOffice(PostRegisterDto reg) {
        PostOffice office = postOfficeRepository.findByIndex(reg.getIndexOfOrg());
        if (office != null) {
            return office;
        } else {
            office = PostOffice.builder()
                    .address(reg.getAddressOfOrg())
                    .index(reg.getIndexOfOrg())
                    .name(reg.getNameOfOrg())
                    .build();

            return office;
        }
    }

    private PostDelivery registerPostDelivery(PostRegisterDto reg,
                                              PostStatus status) {
        PostDelivery postDelivery = PostDelivery.builder()
                .typeOfPost(reg.getType())
                .name(reg.getNameOfRecieved())
                .indexOfRecieved(reg.getIndexOfRecieved())
                .addressOfRecieved(reg.getAddressOfRecieved())
                .build();
        postDelivery.addStatusToPost(status);

        return postDelivery;
    }

    private PostStatus addRegisterStatus(PostOffice postOffice) {
        return PostStatus.builder()
                .type(TypeOfOperations.REGISTRATION)
                .date(LocalDateTime.now())
                .postOffice(postOffice)
                .build();
    }


    private boolean isValidIndex(String index) {
        if (index.length() > 8) {
            return false;
        }
        for (int i = 0; i < index.length(); i++) {
            if (Character.isAlphabetic(index.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void getIndexValidation(PostRegisterDto postRegister) {
        if (!isValidIndex(postRegister.getIndexOfRecieved()) &&
                !isValidIndex(postRegister.getIndexOfOrg())) {
            throw new UnsupportedOperationException("Некорректный индекс получателя или " +
                    "некорректный индекс организации");
        }
    }
}
