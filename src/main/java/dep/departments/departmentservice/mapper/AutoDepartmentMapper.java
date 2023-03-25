package dep.departments.departmentservice.mapper;

import dep.departments.departmentservice.dto.DepartmentDto;
import dep.departments.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    Department mapToDepartment(DepartmentDto departmentDto);
    DepartmentDto mapToDepartmentDto(Department department);
}
