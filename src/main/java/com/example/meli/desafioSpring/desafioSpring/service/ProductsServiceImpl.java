package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.repository.APIRepository;
import com.example.meli.desafioSpring.desafioSpring.sort.SortPublicationsByDate;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService{
    private final APIRepository apiRepository;
    private final UsersService usersService;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public ProductsServiceImpl(UsersService usersService, APIRepository apiRepository) {
        this.apiRepository = apiRepository;
        this.usersService = usersService;
    }

    @Override
    public void createPublicationService(PublicationWithUserIdDTO publication) {
        PublicationsDTO publicationDTO = new PublicationsDTO(publication);
        Integer userId = publication.getUserId();

        apiRepository.createPublication(userId,publicationDTO);
    }

    @Override
    public PublicationsByUserDTO getPublicationsByUserService(Integer userId, String order) {
        List<FollowersDTO> followingDTOList = usersService.getFollowedByService(userId,"name_asc").getFollowing();
        List<PublicationsDTO> publicationsDTOList = new LinkedList<>();
        PublicationsByUserDTO publicationsByUserDTO = new PublicationsByUserDTO();

        for(FollowersDTO following: followingDTOList)
            publicationsDTOList.addAll(apiRepository.getAllPublicationsByUserId(following.getUserId()));

        if(order.equals("date_asc")) {
            publicationsDTOList.sort(new SortPublicationsByDate());
        } else {
            publicationsDTOList.sort(new SortPublicationsByDate().reversed());
        }

        List<PublicationsDTO> publicationsFilteredByDate = publicationsDTOList
                .stream().filter(publication -> getWeeksDifference(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),publication.getDate()) < 3 )
                .collect(Collectors.toList());

        publicationsByUserDTO.setUserId(userId);
        publicationsByUserDTO.setPosts(publicationsFilteredByDate);

        return publicationsByUserDTO;
    }

    private long getWeeksDifference(String date1, String date2) {
        Date firstDate = new Date();
        Date secondDate = new Date();

        try {
            firstDate = formatter.parse(date1);
            secondDate = formatter.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diffInWeeks = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)/7;

        return diffInWeeks;
    }
}
