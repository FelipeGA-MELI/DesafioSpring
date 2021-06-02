package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.repository.APIRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    private final APIRepository apiRepository;

    public UsersServiceImpl(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public void followSellerService(Integer userIdToFollow, Integer userId) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException {
        UsersDTO user = apiRepository.findById(userId);
        UsersDTO userToFollow = apiRepository.findById(userIdToFollow);

        List<FollowersDTO> followersDTOList = user.getFollowers();
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserId(userToFollow.getUserId());
        followersDTO.setUserName(userToFollow.getUserName());

        followersDTOList.add(followersDTO);

        user.setFollowers(followersDTOList);

        List<FollowersDTO> followingDTOList = userToFollow.getFollowing();
        FollowersDTO followingDTO = new FollowersDTO();
        followingDTO.setUserId(user.getUserId());
        followingDTO.setUserName(user.getUserName());

        followingDTOList.add(followingDTO);

        userToFollow.setFollowing(followingDTOList);

        apiRepository.setFollower(user,userToFollow);
    }

    @Override
    public NumberOfFollowers getNumberFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException {
        UsersDTO user = apiRepository.findById(userId);
        Integer followersCount = user.getFollowers().size();

        NumberOfFollowers numberOfFollowers = new NumberOfFollowers();
        numberOfFollowers.setUserId(userId);
        numberOfFollowers.setUserName(user.getUserName());
        numberOfFollowers.setFollowers_count(followersCount);

        return numberOfFollowers;
    }

    @Override
    public AllFollowersDTO getFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException{
        UsersDTO user = apiRepository.findById(userId);
        AllFollowersDTO allFollowersDTO = new AllFollowersDTO();

        allFollowersDTO.setUserId(userId);
        allFollowersDTO.setUserName(user.getUserName());
        allFollowersDTO.setFollowers(user.getFollowers());

        return allFollowersDTO;
    }

    @Override
    public AllFollowingDTO getFollowedByService(Integer userId) throws UserNotFoundException, DataBaseReadException {
        UsersDTO user = apiRepository.findById(userId);
        AllFollowingDTO allFollowingDTO = new AllFollowingDTO();

        allFollowingDTO.setUserId(userId);
        allFollowingDTO.setUserName(user.getUserName());
        allFollowingDTO.setFollowing(user.getFollowing());

        return allFollowingDTO;
    }

    @Override
    public void unfollowSellerService(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, DataBaseReadException, DataBaseWriteException {
        UsersDTO user = apiRepository.findById(userId);
        UsersDTO userToUnfollow = apiRepository.findById(userIdToUnfollow);

        List<FollowersDTO> followingDTOList = user.getFollowing();
        followingDTOList.removeIf(userRem -> userRem.getUserId().equals(userIdToUnfollow));
        user.setFollowing(followingDTOList);

        List<FollowersDTO> followersDTOList = userToUnfollow.getFollowers();
        followersDTOList.removeIf(usrUnFollowRem -> usrUnFollowRem.getUserId().equals(userId));
        userToUnfollow.setFollowers(followersDTOList);

        apiRepository.setFollower(user,userToUnfollow);
    }
}
