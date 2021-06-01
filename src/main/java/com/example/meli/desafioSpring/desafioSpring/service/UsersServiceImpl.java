package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.repository.UsersRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void followSellerService(Integer userId, Integer userIdToFllow) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException {
        UsersDTO user = usersRepository.findById(userId);
        UsersDTO follower = usersRepository.findById(userIdToFllow);

        List<FollowersDTO> followersDTOList = user.getFollowers();
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserId(follower.getUserId());
        followersDTO.setUserName(follower.getUserName());

        followersDTOList.add(followersDTO);

        user.setFollowers(followersDTOList);

        List<FollowersDTO> followingDTOList = follower.getFollowing();
        FollowersDTO followingDTO = new FollowersDTO();
        followingDTO.setUserId(user.getUserId());
        followingDTO.setUserName(user.getUserName());

        followingDTOList.add(followingDTO);

        follower.setFollowing(followingDTOList);

        usersRepository.saveFollowersToDataBase(user,follower);
    }

    @Override
    public NumberOfFollowers getNumberFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException {
        UsersDTO user = usersRepository.findById(userId);
        Integer followersCount = user.getFollowers().size();

        NumberOfFollowers numberOfFollowers = new NumberOfFollowers();
        numberOfFollowers.setUserId(userId);
        numberOfFollowers.setUserName(user.getUserName());
        numberOfFollowers.setFollowers_count(followersCount);

        return numberOfFollowers;
    }

    @Override
    public AllFollowersDTO getFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException{
        UsersDTO user = usersRepository.findById(userId);
        AllFollowersDTO allFollowersDTO = new AllFollowersDTO();

        allFollowersDTO.setUserId(userId);
        allFollowersDTO.setUserName(user.getUserName());
        allFollowersDTO.setFollowers(user.getFollowers());

        return allFollowersDTO;
    }

    @Override
    public AllFollowingDTO getFollowedByService(Integer userId) throws UserNotFoundException, DataBaseReadException {
        UsersDTO user = usersRepository.findById(userId);
        AllFollowingDTO allFollowingDTO = new AllFollowingDTO();

        allFollowingDTO.setUserId(userId);
        allFollowingDTO.setUserName(user.getUserName());
        allFollowingDTO.setFollowing(user.getFollowing());

        return allFollowingDTO;
    }


}
