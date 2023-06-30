package pe.edu.upc.finanzasbackend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.finanzasbackend.domain.User;
import pe.edu.upc.finanzasbackend.resource.UserResource;
import pe.edu.upc.finanzasbackend.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

}
