package kr.co.naamk.api.dto.mapstruct;

import kr.co.naamk.api.dto.PermDto;
import kr.co.naamk.domain.TbPerms;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PermMapper {
    PermMapper INSTANCE = Mappers.getMapper(PermMapper.class);

    PermDto.PermResponse entityToResponseDto(TbPerms tbPerms);


}