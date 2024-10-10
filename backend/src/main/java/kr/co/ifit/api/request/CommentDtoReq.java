package kr.co.ifit.api.request;

import kr.co.ifit.db.entity.Post;
import kr.co.ifit.db.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDtoReq {

//    private Post post;
//    private User user;
    private Long postId;
    private Long userId;
    private String content;
}
