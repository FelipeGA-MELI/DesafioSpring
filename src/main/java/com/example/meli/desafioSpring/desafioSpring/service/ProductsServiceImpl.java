package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.model.Publications;
import com.example.meli.desafioSpring.desafioSpring.model.Users;
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
    public void createPublicationService(PublicationWithUserIdDTO publication, Boolean hasPromo) {
        Publications publicationDTO = new Publications(publication);
        Integer userId = publication.getUserId();

        if(!hasPromo) {
            publicationDTO.setHasPromo(hasPromo);
            publicationDTO.setDiscount(0.0);
        }

        apiRepository.createPublication(userId,publicationDTO);
    }

    @Override
    public PublicationsByUserDTO getPublicationsByUserService(Integer userId, String order) {
        List<UserIdAndNameDTO> followingDTOList = usersService.getFollowedByService(userId,"name_asc").getFollowing();
        List<Publications> publicationsList = new LinkedList<>();
        PublicationsByUserDTO publicationsByUserDTO = new PublicationsByUserDTO();

        for(UserIdAndNameDTO following: followingDTOList)
            publicationsList.addAll(apiRepository.getAllPublicationsByUserId(following.getUserId()));

        if(order.equals("date_asc")) {
            publicationsList.sort(new SortPublicationsByDate());
        } else {
            publicationsList.sort(new SortPublicationsByDate().reversed());
        }

        List<Publications> publicationsFilteredByDate = publicationsList
                .stream().filter(publication -> getWeeksDifference(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),publication.getDate()) < 3 )
                .collect(Collectors.toList());

        publicationsByUserDTO.setUserId(userId);
        publicationsByUserDTO.setPosts(publicationsFilteredByDate);

        return publicationsByUserDTO;
    }

    @Override
    public NumberOfPublicationsDTO getNumberPublications(Integer userId) {
        Users user = apiRepository.findById(userId);
        Integer numberOfPublications = 0;

        for(Publications publication: user.getPublications()) {
            if(publication.getHasPromo())
                numberOfPublications++;
        }

        NumberOfPublicationsDTO numberOfPublicationsDTO = new NumberOfPublicationsDTO();
        numberOfPublicationsDTO.setUserId(user.getUserId());
        numberOfPublicationsDTO.setUserName(user.getUserName());
        numberOfPublicationsDTO.setPromoproducts_count(numberOfPublications);

        return numberOfPublicationsDTO;
    }

    @Override
    public AllPromoPublicationsDTO getPromoPublications(Integer userId) {
        Users user = apiRepository.findById(userId);
        List<Publications> publicationsPromo = new LinkedList<>();

        for(Publications publication: user.getPublications()) {
            if(publication.getHasPromo())
                publicationsPromo.add(publication);
        }

        AllPromoPublicationsDTO allPromoPublicationsDTO = new AllPromoPublicationsDTO();
        allPromoPublicationsDTO.setUserId(user.getUserId());
        allPromoPublicationsDTO.setUserName(user.getUserName());
        allPromoPublicationsDTO.setPosts(publicationsPromo);

        return allPromoPublicationsDTO;
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
