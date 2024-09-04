package kr.co.ifit.api.service;

import kr.co.ifit.api.request.LikedGroupRequestDTO;
import kr.co.ifit.api.response.GroupResponseDTO;
import kr.co.ifit.db.entity.Group;
import kr.co.ifit.db.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HomeGroupService {

    private final GroupRepository groupRepository;
    private final LikedGroupService likedGroupService;

    //  Group 엔티티를 HomeGroupResponseDTO 객체로 변환
    public List<GroupResponseDTO> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream().map(group -> new GroupResponseDTO(
                group.getCommunityId(),
                group.getTitle(),
                group.getTopboxContent(),
                group.getSport(),
                group.getLocation(),
                group.getPerson(),
                group.getPeopleParticipation(),
                group.getDate())).collect(Collectors.toList());         // 변환된 DTO 객체를 리스트로 수집
    }
    
    //  LikedGroupService에 좋아요 기능 로직을 가져다 씀
    public void toggleLike(LikedGroupRequestDTO likedGroupRequestDTO) {
        if (likedGroupRequestDTO.isHeartFilled()) {
            likedGroupService.toggleLike(likedGroupRequestDTO);
        } else {
            likedGroupService.removeLike(likedGroupRequestDTO);
        }
    }
}
