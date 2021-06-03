package com.example.meli.desafioSpring.desafioSpring.sort;

import com.example.meli.desafioSpring.desafioSpring.DTO.FollowersDTO;

import java.util.Comparator;

public class SortFollowersByName implements Comparator<FollowersDTO> {
    @Override
    public int compare(FollowersDTO o1, FollowersDTO o2) {
        if(o1.getUserName().compareTo(o2.getUserName()) < 0) {
            return -1;
        } else { return 1; }
    }
}
