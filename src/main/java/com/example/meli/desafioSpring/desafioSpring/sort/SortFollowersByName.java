package com.example.meli.desafioSpring.desafioSpring.sort;

import com.example.meli.desafioSpring.desafioSpring.DTO.UserIdAndNameDTO;

import java.util.Comparator;

public class SortFollowersByName implements Comparator<UserIdAndNameDTO> {
    @Override
    public int compare(UserIdAndNameDTO o1, UserIdAndNameDTO o2) {
        if(o1.getUserName().compareTo(o2.getUserName()) < 0) {
            return -1;
        } else { return 1; }
    }
}
