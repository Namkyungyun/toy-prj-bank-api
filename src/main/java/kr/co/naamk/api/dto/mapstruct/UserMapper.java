package kr.co.naamk.api.dto.mapstruct;

import kr.co.naamk.api.dto.RoleDto;
import kr.co.naamk.api.dto.UserDto;
import kr.co.naamk.domain.TbUserRole;
import kr.co.naamk.domain.TbUsers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    TbUsers createRequestDtoToEntity(UserDto.CreateRequest dto);

    @Mapping(target = "roles", expression = "java(getRoleResponseDtos(entity.getUserRoles()))")
    UserDto.ListResponse entityToListResponseDto(TbUsers entity);

    List<UserDto.ListResponse> entitiesToListResponseDtos(List<TbUsers> entities);

    @Mapping(target = "roles", expression = "java(getRoleResponseDtos(entity.getUserRoles()))")
    UserDto.DetailResponse entityToDetailResponseDto(TbUsers entity);


    default List<RoleDto.RoleResponse> getRoleResponseDtos(List<TbUserRole> userRoles) {
        return userRoles.stream()
                .map(userRole -> RoleMapper.INSTANCE.entityToRoleResponse(userRole.getRole()))
                .toList();
    }
}