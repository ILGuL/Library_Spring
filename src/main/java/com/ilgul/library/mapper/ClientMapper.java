package com.ilgul.library.mapper;

import com.ilgul.library.dto.ClientDetailsDto;
import com.ilgul.library.dto.ClientSmallDto;
import com.ilgul.library.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientSmallDto toSmall(Client client);

    ClientDetailsDto toDetails(Client client);

}
