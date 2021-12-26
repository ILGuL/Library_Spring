package com.ilgul.library.dto;

import com.ilgul.library.entity.BookInUse;
import lombok.Data;

import java.util.List;

@Data
public class ClientDetailsDto extends ClientSmallDto{
    private List<BookInUseDto> bookInUses;

}
