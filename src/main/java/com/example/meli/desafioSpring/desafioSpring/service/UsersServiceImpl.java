package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.repository.UsersRepository;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void followSellerService(Integer userId, Integer userIdToFllow) throws DataBaseReadException {
       // UsersDTO user = usersRepository.findById(userId);
      //  UsersDTO follower = usersRepository.findById(userIdToFllow);

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserId(1);
        usersDTO.setUserName("Felipe");
        usersDTO.setFollowers(null);
        usersDTO.setSeller(true);
        usersDTO.setFollowing(null);

        List<UsersDTO> usersDTOList = new LinkedList<>();
        usersDTOList.add(usersDTO);

        try {
            usersRepository.writeToDataBase(usersDTOList);
        } catch (DataBaseWriteException e) {
            e.printStackTrace();
        }
    }


}
