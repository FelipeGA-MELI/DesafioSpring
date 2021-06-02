package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.repository.APIRepository;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{
    private final APIRepository apiRepository;
    private final UsersService usersService;

    public ProductsServiceImpl(UsersService usersService, APIRepository apiRepository) {
        this.apiRepository = apiRepository;
        this.usersService = usersService;
    }

    @Override
    public void createPublicationService(PublicationWithUserIdDTO publication) throws DataBaseWriteException, DataBaseReadException, UserNotFoundException {
        PublicationsDTO publicationDTO = new PublicationsDTO(publication);
        Integer userId = publication.getUserId();

        apiRepository.createPublication(userId,publicationDTO);
    }

    @Override
    public PublicationsByUserDTO getPublicationsByUserService(Integer userId) throws DataBaseReadException, UserNotFoundException {
        List<FollowersDTO> followingDTOList = usersService.getFollowedByService(userId).getFollowing();
        List<PublicationsDTO> publicationsDTOList = new LinkedList<>();
        PublicationsByUserDTO publicationsByUserDTO = new PublicationsByUserDTO();

        for(FollowersDTO following: followingDTOList)
            publicationsDTOList.addAll(apiRepository.getAllPublicationsByUserId(following.getUserId()));

        sortPublicationsByDate(publicationsDTOList);

        publicationsByUserDTO.setUserId(userId);
        publicationsByUserDTO.setPosts(publicationsDTOList);

        return publicationsByUserDTO;
    }

    private void sortPublicationsByDate(List<PublicationsDTO> publications) {
      publications.sort(new Comparator<>() {
          private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

          @Override
          public int compare(PublicationsDTO o1, PublicationsDTO o2) {
              try {
                  if (formatter.parse(o1.getDate()).compareTo(formatter.parse(o2.getDate())) < 0) {
                      return -1;
                  } else {
                      return 1;
                  }
              } catch (ParseException e) {
                  e.printStackTrace();
              }

              return 0;
          }
      });
    }
}
