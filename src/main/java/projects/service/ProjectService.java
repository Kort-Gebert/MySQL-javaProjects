package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.doa.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

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
	}//end of fetchProjectById method

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID=" + project.getProjectId() + "does not exist."); 
		}//end of if
		
	}//end of modifyProjectDetails method

	public void deleteProject(Integer projectId) {
		
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID=" + projectId + "does not exist."); 
		}//end of if
		
	}
	
}// end of class

