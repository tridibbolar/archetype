package ${groupId}.domain.mapper;

import org.mapstruct.AfterMapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class, uses = { /*TODO*/})
public interface RequestMapper {

	public static RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

	//TODO
}
