package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.model.Users;
import com.example.meli.desafioSpring.desafioSpring.repository.APIRepository;
import com.example.meli.desafioSpring.desafioSpring.sort.SortFollowersByName;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    private final APIRepository apiRepository;

    public UsersServiceImpl(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public void followSellerService(Integer userIdToFollow, Integer userId) {
        Users user = apiRepository.findById(userId);
        Users userToFollow = apiRepository.findById(userIdToFollow);

        List<UserIdAndNameDTO> userIdAndNameDTOList = user.getFollowers();
        UserIdAndNameDTO userIdAndNameDTO = new UserIdAndNameDTO();
        userIdAndNameDTO.setUserId(userToFollow.getUserId());
        userIdAndNameDTO.setUserName(userToFollow.getUserName());

        userIdAndNameDTOList.add(userIdAndNameDTO);

        user.setFollowers(userIdAndNameDTOList);

        List<UserIdAndNameDTO> followingDTOList = userToFollow.getFollowing();
        UserIdAndNameDTO followingDTO = new UserIdAndNameDTO();
        followingDTO.setUserId(user.getUserId());
        followingDTO.setUserName(user.getUserName());

        followingDTOList.add(followingDTO);

        userToFollow.setFollowing(followingDTOList);

        apiRepository.setFollower(user,userToFollow);
    }

    @Override
    public NumberOfUserIdAndNameDTO getNumberFollowersService(Integer userId) {
        Users user = apiRepository.findById(userId);
        Integer followersCount = user.getFollowers().size();

        NumberOfUserIdAndNameDTO numberOfFollowersDTO = new NumberOfUserIdAndNameDTO();
        numberOfFollowersDTO.setUserId(userId);
        numberOfFollowersDTO.setUserName(user.getUserName());
        numberOfFollowersDTO.setFollowers_count(followersCount);

        return numberOfFollowersDTO;
    }

    @Override
    public AllUserIdAndNameDTO getFollowersService(Integer userId, String order) {
        Users user = apiRepository.findById(userId);
        AllUserIdAndNameDTO allFollowersDTO = new AllUserIdAndNameDTO();

        List<UserIdAndNameDTO> followers = user.getFollowers();

        if(order.equals("name_asc")) {
            followers.sort(new SortFollowersByName());
        } else {
            followers.sort(new SortFollowersByName().reversed());
        }

        allFollowersDTO.setUserId(user.getUserId());
        allFollowersDTO.setUserName(user.getUserName());
        allFollowersDTO.setFollowers(followers);

        return allFollowersDTO;
    }

    @Override
    public AllFollowingDTO getFollowedByService(Integer userId, String order) {
        Users user = apiRepository.findById(userId);
        AllFollowingDTO allFollowingDTO = new AllFollowingDTO();

        List<UserIdAndNameDTO> following = user.getFollowing();

        if(order.equals("name_asc")) {
            following.sort(new SortFollowersByName());
        } else {
            following.sort(new SortFollowersByName().reversed());
        }

        allFollowingDTO.setUserId(user.getUserId());
        allFollowingDTO.setUserName(user.getUserName());
        allFollowingDTO.setFollowing(following);

        return allFollowingDTO;
    }

    @Override
    public void unfollowSellerService(Integer userId, Integer userIdToUnfollow) {
        Users user = apiRepository.findById(userId);
        Users userToUnfollow = apiRepository.findById(userIdToUnfollow);

        List<UserIdAndNameDTO> followingDTOList = user.getFollowing();
        followingDTOList.removeIf(userRem -> userRem.getUserId().equals(userIdToUnfollow));
        user.setFollowing(followingDTOList);

        List<UserIdAndNameDTO> userIdAndNameDTOList = userToUnfollow.getFollowers();
        userIdAndNameDTOList.removeIf(usrUnFollowRem -> usrUnFollowRem.getUserId().equals(userId));
        userToUnfollow.setFollowers(userIdAndNameDTOList);

        apiRepository.setFollower(user,userToUnfollow);
    }
}
