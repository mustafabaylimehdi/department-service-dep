package dep.departments.departmentservice.service.impl;

import dep.departments.departmentservice.exception.ResourceNotFoundException;
import dep.departments.departmentservice.mapper.AutoDepartmentMapper;
import dep.departments.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import dep.departments.departmentservice.dto.DepartmentDto;
import dep.departments.departmentservice.entity.Department;
import dep.departments.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if(department == null)
            throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
