package springreactredux.project_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springreactredux.project_manager.domain.Project;
import springreactredux.project_manager.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project)
    {
        //Logic
        return projectRepository.save(project);
    }

}
