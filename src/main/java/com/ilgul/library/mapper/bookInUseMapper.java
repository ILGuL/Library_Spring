package com.ilgul.library.mapper;

import com.ilgul.library.dto.ExpiredInUseDto;
import com.ilgul.library.entity.BookInUse;
import com.ilgul.library.service.TimeService;
import lombok.Getter;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.temporal.ChronoUnit;

@Mapper
@Getter
public abstract class bookInUseMapper {

    @Autowired
    private TimeService timeService;

    @Value("${time.expired.after}")
    private Integer expiredAfter;

    @Mapping(target = "expiredDays", ignore = true)
    public abstract ExpiredInUseDto toDto(BookInUse bookInUse);

    @AfterMapping
    void map(@MappingTarget ExpiredInUseDto dto, BookInUse bookInUse){
        var now = timeService.currentDate();
        var expiredDays = now.isAfter(dto.getInUseFrom().plusDays(expiredAfter)) ?
                ChronoUnit.DAYS.between(bookInUse.getInUseFrom().plusDays(expiredAfter), now) :
                0;

        dto.setExpiredDays(expiredDays);
    }

}
