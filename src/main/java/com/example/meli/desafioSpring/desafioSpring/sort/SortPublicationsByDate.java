package com.example.meli.desafioSpring.desafioSpring.sort;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class SortPublicationsByDate implements Comparator<PublicationsDTO> {
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
}
