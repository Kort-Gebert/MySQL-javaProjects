package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.doa.ProjectDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	
	
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}//end of addProject method

	public List<Project> fetchAllProjects() {	
		return projectDao.fetchAllProjects();
	}//end of fetchAllProjects method

	public Project fetchProjectById(Integer projectId) {
		Optional<Project> op = projectDao.fetchProjectById(projectId);
		return op.orElseThrow(() -> new NoSuchElementException(
				"Project with project ID=" + projectId + " does not exist."));
	}
	
}// end of class

